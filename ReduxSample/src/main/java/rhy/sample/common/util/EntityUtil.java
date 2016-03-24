package rhy.sample.common.util;

import java.util.Date;

import rhy.sample.common.entity.RHYBaseEntity;

public class EntityUtil {

    public static RHYBaseEntity setManagementColumn(RHYBaseEntity entity, String usrId){
        Date currentDateTime = DateUtil.getCurrentDateTime();
        entity.setCrtDt(currentDateTime);
        entity.setCrtrId(usrId);
        entity.setMdfyDt(currentDateTime);
        entity.setMdfrId(usrId);
        return entity;
    }
    
}
