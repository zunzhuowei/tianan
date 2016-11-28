package com.org.test.keega.service;

import com.org.test.keega.model.FeedBack;
/**
 * Created by Administrator on 2016/9/27.
 */
public interface IFeedBackService {
    public void update(FeedBack feedBack, String plandId, String objectId);

    public FeedBack load(String plandId, String objectId);
}
