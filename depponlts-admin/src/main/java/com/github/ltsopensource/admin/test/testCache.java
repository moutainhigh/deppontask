package com.github.ltsopensource.admin.test;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

//import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.depponlts.pojo.LtsJobentity;
import com.github.ltsopensource.core.cluster.Config;
import com.github.ltsopensource.core.domain.JobType;
import com.github.ltsopensource.core.json.JSON;
import com.github.ltsopensource.core.spi.ServiceLoader;
import com.github.ltsopensource.queue.domain.JobPo;
import com.github.ltsopensource.queue.mysql.MysqlCronJobQueue;
import com.github.ltsopensource.store.jdbc.SqlTemplate;
import com.github.ltsopensource.store.jdbc.SqlTemplateFactory;
import com.github.ltsopensource.store.jdbc.builder.InsertSql;
import com.github.ltsopensource.store.jdbc.datasource.DataSourceProvider;

public class testCache {
//	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//		List<TbContent> contenList = contentService.getContenList((long) 89);
//		for (TbContent tbContent : contenList) {
//			System.out.println(tbContent.getId());
//		}
//	}
	
/*	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		ContentService contentService = (ContentService) ctx.getBean("contentService");
		String contenList = contentService.queryCache("INDEX_CONTENT_REDIS_KEY");
			System.out.println(contenList);
	}
	
	@Test
	public void test01(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		ContentService contentService = (ContentService) ctx.getBean("contentService");
		
		LtsJobentity jobentity = new LtsJobentity();
		jobentity.setId("123");
		jobentity.setJobName("aaaa1");
		contentService.insertCache("INDEX_CONTENT_REDIS_KEY", jobentity);
	}*/
	
	public static void main(String[] args){
		JobPo jobPo = new JobPo();
		jobPo.setJobType(JobType.CRON);
		jobPo.setJobId("112313313");
		add("lts_cron_job_queue", jobPo);
	}
	public static boolean add(String tableName, JobPo jobPo){
		Config config = new Config();
		config.setIdentity("chenhaitao12123");
		config.setParameter("configs.jdbc.url", "jdbc:mysql://127.0.0.1:3306/lts");
		config.setParameter("configs.jdbc.username", "root");
		config.setParameter("configs.jdbc.password", "root");
		return new InsertSql(SqlTemplateFactory.create(config))
                .insert(tableName)
                .columns("job_id",
                        "job_type",
                        "priority",
                        "retry_times",
                        "max_retry_times",
                        "rely_on_prev_cycle",
                        "task_id",
                        "real_task_id",
                        "gmt_created",
                        "gmt_modified",
                        "submit_node_group",
                        "task_tracker_node_group",
                        "ext_params",
                        "internal_ext_params",
                        "is_running",
                        "task_tracker_identity",
                        "need_feedback",
                        "cron_expression",
                        "trigger_time",
                        "repeat_count",
                        "repeated_count",
                        "repeat_interval")
                .values(jobPo.getJobId(),
                        jobPo.getJobType() == null ? null : jobPo.getJobType().name(),
                        jobPo.getPriority(),
                        jobPo.getRetryTimes(),
                        jobPo.getMaxRetryTimes(),
                        jobPo.getRelyOnPrevCycle(),
                        jobPo.getTaskId(),
                        jobPo.getRealTaskId(),
                        jobPo.getGmtCreated(),
                        jobPo.getGmtModified(),
                        jobPo.getSubmitNodeGroup(),
                        jobPo.getTaskTrackerNodeGroup(),
                        JSON.toJSONString(jobPo.getExtParams()),
                        JSON.toJSONString(jobPo.getInternalExtParams()),
                        jobPo.isRunning(),
                        jobPo.getTaskTrackerIdentity(),
                        jobPo.isNeedFeedback(),
                        jobPo.getCronExpression(),
                        jobPo.getTriggerTime(),
                        jobPo.getRepeatCount(),
                        jobPo.getRepeatedCount(),
                        jobPo.getRepeatInterval())
                .doInsert() == 1;
	}
	
	
}
