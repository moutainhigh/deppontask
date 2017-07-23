package com.github.ltsopensource.admin.web.support;

import com.depponlts.pojo.LtsJobentity;
import com.github.ltsopensource.biz.logger.domain.JobLogPo;
import com.github.ltsopensource.biz.logger.domain.LogType;
import com.github.ltsopensource.core.cluster.NodeType;
import com.github.ltsopensource.core.commons.utils.StringUtils;
import com.github.ltsopensource.core.constant.Level;
import com.github.ltsopensource.core.domain.JobRunResult;
import com.github.ltsopensource.core.domain.JobType;
import com.github.ltsopensource.core.json.JSON;
import com.github.ltsopensource.core.json.TypeReference;
import com.github.ltsopensource.queue.domain.JobFeedbackPo;
import com.github.ltsopensource.queue.domain.JobPo;
import com.github.ltsopensource.queue.domain.NodeGroupPo;
import com.github.ltsopensource.store.jdbc.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author chenhaitao
 *
 */
public class RshHolderQuartz {

   
    
    public static final ResultSetHandler<List<LtsJobentity>> QUARTZ_PO_LIST_RSH = new ResultSetHandler<List<LtsJobentity>>() {
        @Override
        public List<LtsJobentity> handle(ResultSet rs) throws SQLException {
            List<LtsJobentity> jobentities = new ArrayList<LtsJobentity>();
            while (rs.next()) {
            	jobentities.add(getJobEntity(rs));
            }
            return jobentities;
        }
    };
    private static LtsJobentity getJobEntity(ResultSet rs) throws SQLException {
    	LtsJobentity jobentity = new LtsJobentity();
    	jobentity.setId(rs.getString("id"));
//    	jobentity.setActive(rs.getInt("active"));
    	jobentity.setDescription(rs.getString("description"));
    	jobentity.setJobClass(rs.getString("job_class"));
    	jobentity.setJobData(rs.getString("job_data"));
    	jobentity.setJobGroup(rs.getString("job_group"));
    	jobentity.setJobName(rs.getString("job_name"));
    	jobentity.setTriggerExpression(rs.getString("trigger_expression"));
    	jobentity.setTriggerGroup(rs.getString("trigger_group"));
    	jobentity.setTriggerName(rs.getString("trigger_name"));
//    	jobentity.setTriggerTime(rs.getDate("triggerTime"));
//    	jobentity.setTriggerType(rs.getString("trigger_type"));
//    	jobentity.setUpdateTime(rs.getDate("update_time"));
        return jobentity;
    }
}


