package rhy.sample.common.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class RHYBaseEntity implements Serializable{
    
    private static final long serialVersionUID = 4809702013448363119L;

    private Date crtDt;
    
    private String crtrId;
    
    private Date mdfyDt;
    
    private String mdfrId;
    
    public Date getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(Date crtDt) {
        this.crtDt = crtDt;
    }

    public String getCrtrId() {
        return crtrId;
    }

    public void setCrtrId(String crtrId) {
        this.crtrId = crtrId;
    }

    public Date getMdfyDt() {
        return mdfyDt;
    }

    public void setMdfyDt(Date mdfyDt) {
        this.mdfyDt = mdfyDt;
    }

    public String getMdfrId() {
        return mdfrId;
    }

    public void setMdfrId(String mdfrId) {
        this.mdfrId = mdfrId;
    }
}
