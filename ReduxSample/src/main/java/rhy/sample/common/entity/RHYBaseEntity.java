package rhy.sample.common.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@MappedSuperclass
public abstract class RHYBaseEntity implements Serializable{
    
    private static final long serialVersionUID = 4809702013448363119L;

    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime crtDt;
    
    @NotNull
    private String crtrId;
    
    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime mdfyDt;
    
    @NotNull
    private String mdfrId;
    
    public DateTime getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(DateTime crtDt) {
        this.crtDt = crtDt;
    }

    public String getCrtrId() {
        return crtrId;
    }

    public void setCrtrId(String crtrId) {
        this.crtrId = crtrId;
    }

    public DateTime getMdfyDt() {
        return mdfyDt;
    }

    public void setMdfyDt(DateTime mdfyDt) {
        this.mdfyDt = mdfyDt;
    }

    public String getMdfrId() {
        return mdfrId;
    }

    public void setMdfrId(String mdfrId) {
        this.mdfrId = mdfrId;
    }
}
