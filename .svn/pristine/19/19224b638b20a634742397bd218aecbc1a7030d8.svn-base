package com.deppon.lts.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.lts.api.JobConfigService;
import com.deppon.lts.common.utils.JsonUtils;
import com.deppon.lts.dao.CodisManager;
import com.depponlts.pojo.LtsJobentity;
public class JobConfigServiceImpl implements JobConfigService {
	@Autowired
	private CodisManager codisManager;
	/**
	 * JOB参数SET进codis
	 * <p>Title: getContenList</p>
	 * <p>Description: </p>
	 * @param categoryId
	 * @return: List<LtsJobentity>
	 */
	@Override
	public String insertCache(String key, LtsJobentity ltsJobentity) {
		try {
			String reString = codisManager.set(key, JsonUtils.objectToJson(ltsJobentity));
			if(StringUtils.isNoneBlank(reString)){
				return reString;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
 		return null;
	}
	/**
	 * 获取缓存中的JOB参数
	 * <p>Title: getContenList</p>
	 * <p>Description: </p>
	 * @param categoryId
	 * @return: List<LtsJobentity>
	 */
	@Override
	public String queryCache(String key) {
		try {
			String reString = codisManager.get(key );
			if(StringUtils.isNoneBlank(reString)){
				return reString;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
 		return null;
	}
	
}
