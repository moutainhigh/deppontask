package com.deppon.lts.api;
import com.depponlts.pojo.LtsJobentity;
/**
 * 任务中心JOB参数缓存同步接口
* @title: JobConfigService 
* @author： 李玉帅
* @date： 2017-4-8 下午3:08:57
 */
public interface JobConfigService {
	
	/**
	 * JOB参数set进coids
	* @MethodName: insertCache 
	* @author：李玉帅 
	* @date： 2017-4-7 下午4:25:30
	* @param key
	* @param value
	* @return String
	 */
	String insertCache(String key, LtsJobentity ltsJobentity);
	
	/**
	 * 获取JOB 参数
	* @MethodName: queryCache 
	* @author：李玉帅 
	* @date： 2017-4-8 上午9:43:20
	* @param key
	* @param ltsJobentity
	* @return String
	 */
	String queryCache(String key );
	
}
