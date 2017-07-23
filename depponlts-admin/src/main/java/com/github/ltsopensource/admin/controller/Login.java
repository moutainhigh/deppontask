/**
* @Copyright ? 2017-4-27 shine.cn.Co.,Ltd
* @depponlts-admin 下午4:24:59
* @Version TODO
* All right reserved.
*
*/

package com.github.ltsopensource.admin.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.depponlts.pojo.LtsJobentity;
import com.github.ltsopensource.admin.access.domain.UserEntity;
import com.github.ltsopensource.admin.response.PaginationRsp;
import com.github.ltsopensource.admin.web.support.Builder;
import com.github.ltsopensource.admin.web.support.CheckLogin;
import com.github.ltsopensource.admin.web.vo.RestfulResponse;
import com.github.ltsopensource.core.cluster.Config;
import com.github.ltsopensource.core.commons.utils.StringUtils;
import com.github.ltsopensource.core.support.CronExpression;
import com.github.ltsopensource.queue.domain.JobPo;
import com.github.ltsopensource.store.jdbc.SqlTemplateFactory;
import com.github.ltsopensource.store.jdbc.builder.InsertSql;
import com.github.ltsopensource.store.jdbc.builder.OrderByType;
import com.github.ltsopensource.store.jdbc.builder.SelectSql;
import com.github.ltsopensource.store.jdbc.builder.WhereSql;

/**
 * @title: Login 
 * @description：TODO
 * @author： 李玉帅
 * @date： 2017-4-27 下午4:24:59
 */
@Controller
public class Login {
	
	@Value("${configs.jdbc.url}")
	private String jdbcUrl;
	@Value("${configs.jdbc.username}")
	private String jdbcUsername;
	@Value("${configs.jdbc.password}")
	private String jdbcPassword;
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	/**
	 * 用户登录验证
	* @MethodName: Login 
	* @description : TODO
	* @author：李玉帅 
	* @date： 2017-4-28 下午3:04:00
	* @param tableName
	* @param entity
	* @return RestfulResponse
	 */
	
	 @RequestMapping("/job-queue/login") 
	 @ResponseBody
	    public RestfulResponse Login( UserEntity entity) {
		 	RestfulResponse response = new RestfulResponse();
	        PaginationRsp<UserEntity> paginationRsp = getLogin("lts_user",entity);
	        if(paginationRsp.getResults()>0){
	        	UserEntity userEntity=paginationRsp.getRows().get(0);
	            response.setUserEntity(userEntity);
	            response.setSuccess(true);
	            response.setMsg("登录成功");
	            return response;
	        }else{
	        	response.setSuccess(false);
	        	response.setMsg("帐号密码错误");
	        	return response;
	        }
	      
	    }
	 
	 /**
	  * 用户登录查询
	  */
	    public PaginationRsp<UserEntity>getLogin (String tableName,UserEntity entity){
	    	WhereSql whereSql = new WhereSql()
				                .andOnNotEmpty("username = ?", entity.getUserName())
				                .andOnNotEmpty("password = ?", entity.getPassWord());
	    	Config config = new Config();
			config.setParameter("configs.jdbc.url", jdbcUrl);
			config.setParameter("configs.jdbc.username", jdbcUsername);
			config.setParameter("configs.jdbc.password", jdbcPassword);
			PaginationRsp<UserEntity> response = new PaginationRsp<UserEntity>();
			Long results = new SelectSql(SqlTemplateFactory.createNew(config))
					    	.select()
					        .columns("count(1)")
					        .from()
					        .table(tableName)
					        .whereSql(whereSql)
					        .single();
			response.setResults(results.intValue());
	        if (results > 0) {
	        	List<UserEntity> ltsentity = new SelectSql(SqlTemplateFactory.createNew(config))
													    	.select()
													    	.all()
													        .from()
													        .table(tableName)
													        .whereSql(whereSql)
										                    .list(CheckLogin.lts_login);
	        	response.setRows(ltsentity);
	        }
	    	return response;
	    }
	    @RequestMapping("/select-add") 
		 @ResponseBody
		    public RestfulResponse querySe( UserEntity entity) {
			 	RestfulResponse response = new RestfulResponse();
		        try {
					PaginationRsp<UserEntity> paginationRsp = queryUsername("lts_user",entity);
					if(paginationRsp.getRows()!=null && paginationRsp.getRows().size()>0){
					    List<UserEntity> list = new ArrayList<UserEntity>();
					    list=paginationRsp.getRows();
					    response.setList(list);
					    response.setSuccess(true);
					    return response;
					}else{
						response.setSuccess(false);
						return response;
					}
				} catch (IllegalArgumentException e) {
					response.setSuccess(false);
					response.setMsg("程序异常,请重新登录");
					return response;
				}
		      
		    }
	    
	    /**
	     * 部门下拉列表
	    * @MethodName: queryUsername 
	    * @description : TODO
	    * @author：李玉帅 
	    * @date： 2017-5-9 下午3:15:33
	    * @param tableName
	    * @param entity
	    * @return PaginationRsp<UserEntity>
	     */
		    public PaginationRsp<UserEntity>queryUsername (String tableName,UserEntity entity){
		    	WhereSql whereSql = new WhereSql()
					                .andOnNotEmpty("username = ?", entity.getUserName())
					                .andOnNotEmpty("password = ?", entity.getPassWord());
		    	Config config = new Config();
				config.setParameter("configs.jdbc.url", jdbcUrl);
				config.setParameter("configs.jdbc.username", jdbcUsername);
				config.setParameter("configs.jdbc.password", jdbcPassword);
				PaginationRsp<UserEntity> response = new PaginationRsp<UserEntity>();
	        	List<UserEntity> ltsentity = new SelectSql(SqlTemplateFactory.createNew(config))
													    	.select()
													    	.all()
													        .from()
													        .table(tableName)
													        .groupBy(" deptname ASC")
										                    .list(CheckLogin.lts_login);
	        	response.setRows(ltsentity);
		    	return response;
		    }
}
