package com.org.test.keega.service;

import com.org.test.keega.dao.IFeedBackDao;
import com.org.test.keega.model.FeedBack;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/27.
 */
@Service("feedBackService")
public class FeedBackService implements IFeedBackService {

    @Resource
    private IFeedBackDao feedBackDao;

    @Override
    public void update(FeedBack feedBack, String plandId, String objectId) {
        this.feedBackDao.update(feedBack,plandId,objectId);
    }

    @Override
    public FeedBack load(String plandId, String objectId) {
        return this.feedBackDao.load(plandId,objectId);
    }
}
