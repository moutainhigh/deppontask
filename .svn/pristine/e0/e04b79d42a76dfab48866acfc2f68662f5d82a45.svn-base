package com.github.ltsopensource.admin.web.support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.depponlts.pojo.LtsJobentity;
import com.github.ltsopensource.admin.access.domain.UserEntity;
import com.github.ltsopensource.store.jdbc.dbutils.ResultSetHandler;

/**
 * 
* @title: CheckLogin 
* @description：TODO
* @author： 李玉帅
* @date： 2017-5-9 下午3:37:17
 */
public class CheckLogin {
	    
	    public static final ResultSetHandler<List<UserEntity>> lts_login = new ResultSetHandler<List<UserEntity>>() {
	        @Override
	        public List<UserEntity> handle(ResultSet rs) throws SQLException {
	            List<UserEntity> listEntity = new ArrayList<UserEntity>();
	            while (rs.next()) {
	            	listEntity.add(getUserEntity(rs));
	            }
	            return listEntity;
	        }
	    };
	    private static UserEntity getUserEntity(ResultSet rs) throws SQLException {
	    	UserEntity userEntity = new UserEntity();
	    	userEntity.setId(rs.getString("id"));
	    	userEntity.setUserName(rs.getString("userName"));
	    	userEntity.setAuthority(rs.getString("authority"));
	    	userEntity.setPassWord(rs.getString("passWord"));
	    	userEntity.setDeptCode(rs.getString("deptCode"));
	    	userEntity.setDeptName(rs.getString("deptName"));
	        return userEntity;
	    }
}


