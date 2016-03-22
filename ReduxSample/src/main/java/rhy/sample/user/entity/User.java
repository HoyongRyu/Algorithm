package rhy.sample.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import rhy.sample.common.entity.RHYBaseEntity;

@Entity
@Table(name = "TBAS_USER")
public class User extends RHYBaseEntity {
    private static final long serialVersionUID = -7141391636879295583L;

    @Id
    private String usrId; 
    
    @NotNull
    private boolean authFg;
    
    private String cmpyId;
    
    @Transient
    private String loginId;
    
    @Transient
    private String password;
    
    @Transient
    private String sessionToken;
    
    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public boolean isAuthFg() {
        return authFg;
    }

    public void setAuthFg(boolean authFg) {
        this.authFg = authFg;
    }

    public String getCmpyId() {
        return cmpyId;
    }

    public void setCmpyId(String cmpyId) {
        this.cmpyId = cmpyId;
    }

    @Transient
    public String getLoginId() {
        return loginId;
    }

    @Transient
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Transient
    public String getPassword() {
        return password;
    }

    @Transient
    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getSessionToken() {
        return sessionToken;
    }

    @Transient
    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
