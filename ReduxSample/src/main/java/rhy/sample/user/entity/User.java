package rhy.sample.user.entity;

import rhy.sample.common.entity.RHYBaseEntity;

public class User extends RHYBaseEntity {
    private static final long serialVersionUID = -7141391636879295583L;

    private String usrId; 
    
    private boolean authFg;
    
    private String cmpyId;
    
    private String loginId;
    
    private String password;
    
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

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
