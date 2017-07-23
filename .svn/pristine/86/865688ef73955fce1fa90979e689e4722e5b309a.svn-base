package com.deppon.lts.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.lts.api.JobConfigService;
import com.deppon.lts.common.utils.JsonUtils;
import com.deppon.lts.dao.JedisClient;
import com.depponlts.pojo.LtsJobentity;

public class JobConfigServiceImplRedis implements JobConfigService {
	@Autowired
	private JedisClient jedisClient;
	@Override
	public String insertCache(String key, LtsJobentity ltsJobentity) {
		try {
			String reString = jedisClient.set(key, JsonUtils.objectToJson(ltsJobentity));
			if(StringUtils.isNoneBlank(reString)){
				return reString;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String queryCache(String key) {
		try {
			String reString = jedisClient.get(key);
			if(StringUtils.isNoneBlank(reString)){
				return reString;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
