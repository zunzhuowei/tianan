package com.org.test.keega.service;

import java.util.List;

import com.org.test.keega.model.InitClass;
import com.org.test.keega.model.P04;
import com.org.test.keega.model.TargetAndP04;

public interface IP04Service {
    public void add(P04 p04);

    public void delete(int id);

    public void update(P04 p04);

    public P04 load(String id);

    public List<P04> listAllP04(String planid, String objectid,String template_id);

    //objectid,mainbodyid,planid
    public List<TargetAndP04> listTargetAndP04(List<P04> t, IEvalutionService es, ITargetService targetService, String objectid, String mainbodyid, String planid);

    public InitClass getInitClassByA0100(String a0100);
}
