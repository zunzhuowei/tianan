package com.org.test.keega.dao;

import com.org.test.keega.model.FeedBack;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public interface IFeedBackDao {
    public void add(FeedBack feedBack);

    public void update(FeedBack feedBack,String plandId, String objectId);

    public void delete(int id);

    public FeedBack load(String plandId, String objectId);

//    public List<FeedBack> findAllFeedBack();
}
