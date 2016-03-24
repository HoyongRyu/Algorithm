package rhy.sample.common.util;

import org.joda.time.DateTime;

import rhy.sample.common.entity.RHYBaseEntity;

public class EntityUtil {

    public static RHYBaseEntity setManagementColumn(RHYBaseEntity entity, String usrId){
        DateTime currentDateTime = DateUtil.getCurrentDateTime();
        entity.setCrtDt(currentDateTime);
        entity.setCrtrId(usrId);
        entity.setMdfyDt(currentDateTime);
        entity.setMdfrId(usrId);
        return entity;
    }
    
}
