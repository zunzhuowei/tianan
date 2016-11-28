package com.org.test.keega.dao;

import com.org.test.keega.model.FeedBack;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Created by Administrator on 2016/9/27.
 */
@Repository("feedBackDao")
public class FeedBackDao implements IFeedBackDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(FeedBack feedBack) {
        System.out.println("未提供添加！");
    }

    @Override
    public void update(FeedBack feedBack, String plandId, String objectId) {
        int rowCount =this.jdbcTemplate.queryForObject("SELECT count(*) FROM per_object WHERE object_id = "+objectId+" AND plan_id = '"+plandId+"'", Integer.class);
        if (rowCount > 0) {
            jdbcTemplate.update("UPDATE per_object SET feedback = ? WHERE object_id = ? AND plan_id = ?", feedBack.getFeedBack(), objectId, plandId);
        }
    }

    @Override
    public void delete(int id) {
        System.out.println("未提供删除！");
    }

    @Override
        public FeedBack load(String plandId, String objectId) {
        int rowCount =this.jdbcTemplate.queryForObject("SELECT count(*) FROM per_object WHERE object_id = "+objectId+" AND plan_id = '"+plandId+"'", Integer.class);
        if (rowCount > 0) {
            FeedBack actor = this.jdbcTemplate.queryForObject(
                    "SELECT id, feedback FROM per_object WHERE plan_id = ? AND object_id = ?", new Object[]{plandId, objectId},
                    new RowMapper<FeedBack>() {
                        public FeedBack mapRow(ResultSet rs, int rowNum) throws SQLException {
                            FeedBack actor = new FeedBack();
                            actor.setId(rs.getInt("id"));
                            actor.setFeedBack(rs.getString("feedback"));
                            return actor;
                        }
                    });
            return actor;
        } else {
            return null;
        }
    }
}
