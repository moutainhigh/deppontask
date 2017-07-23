package com.github.ltsopensource.admin.request;

import java.util.Date;

public class SpringQuartzConfReq extends PaginationReq{
	private String  id;
	private String triggerGroup;
	private String triggerName;
	private Date triggerTime;
	private String jobGroup;
	private String jobName;
	private String description;
	private Number triggerType;
	private String triggerExpression;
	private String jobClass;
	private String jobData;
	private Integer active;
	private Date updateTime;
	private Date startGmtModified;
    private Date endGmtModified;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTriggerGroup() {
		return triggerGroup;
	}
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public Date getTriggerTime() {
		return triggerTime;
	}
	public void setTriggerTime(Date triggerTime) {
		this.triggerTime = triggerTime;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Number getTriggerType() {
		return triggerType;
	}
	public void setTriggerType(Number triggerType) {
		this.triggerType = triggerType;
	}
	public String getTriggerExpression() {
		return triggerExpression;
	}
	public void setTriggerExpression(String triggerExpression) {
		this.triggerExpression = triggerExpression;
	}
	public String getJobClass() {
		return jobClass;
	}
	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}
	public String getJobData() {
		return jobData;
	}
	public void setJobData(String jobData) {
		this.jobData = jobData;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getStartGmtModified() {
		return startGmtModified;
	}
	public void setStartGmtModified(Date startGmtModified) {
		this.startGmtModified = startGmtModified;
	}
	public Date getEndGmtModified() {
		return endGmtModified;
	}
	public void setEndGmtModified(Date endGmtModified) {
		this.endGmtModified = endGmtModified;
	}
    
}
