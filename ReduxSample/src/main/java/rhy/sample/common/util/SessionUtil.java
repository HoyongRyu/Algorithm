package rhy.sample.common.util;

import javax.servlet.http.HttpServletRequest;

import rhy.sample.common.config.RHYConstants;
import rhy.sample.user.entity.User;

public class SessionUtil {
    
    
    public static void createSession(HttpServletRequest request){
        User user = (User) SessionUtil.getData(request, RHYConstants.SESSION_KEY_LOGIN);
        if ( user == null ) {
            SessionUtil.setData(request, RHYConstants.SESSION_KEY_LOGIN, null);
        }
    }
    
    /**
     * <p>Session 에 저장된 attribute 중 key 로 저장된 내용을 삭제한다</p>
     * 
     * @param request HttpServlerRequest
     *            
     * @param key String
     *            session key value
     */
    public static void removeData(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }

    /**
     * <p>Session 에서 key 로 저장된 attribute 내용을 조회한다</p>
     * 
     * @param request HttpServletRequest
     * @param key String
     *            session key value
     * @return Object the data
     */
    public static Object getData(HttpServletRequest request, String key) {
        if ( request.getSession() != null ){
            return request.getSession().getAttribute(key);
        }
        
        return null;
    }

    /**
     * <p>Session 에 (key, data) 의 데이터를 attribute 로 추가한다.
     * 
     * @param request HttpServletRequest
     * @param key String
     *            session key value
     * @param data Object
     */
    public static void setData(HttpServletRequest request, String key, Object data) {
        if ( key != null && data != null && request.getSession() != null ) {
            request.getSession().setAttribute(key, data);
        }
    }
    
}
