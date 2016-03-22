package rhy.sample.common.util;

public class StringUtil {
    
    
    /**
     * 문자열이 null이거나 길이가 없으면 True 리턴
     * 
     * @param str : 입력 문자열 
     * @return 빈 문자열인지 여부
     */
    public static boolean isEmpty(String str) {
        return ( str == null || str.length() == 0 );
    }
    
    /**
     * 문자열이 비어있지 않다면 True 리턴
     * 
     * @param str : 입력 문자열 
     * @return 비어있지 않은 문자열인지 여부
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    
    /**
     * 입력 문자열이 비어있는 경우 별도 문자열을 리턴하는 메소드
     * 
     * @param str 입력 문자열
     * @param ifNull 입력 문자열이 isEmpty인 경우 리턴할 문자열
     * @return str이 isEmpty이면 ifNull, 그렇지 않은 경우 str 그대로 리턴
     */
    public static String nvl(String str, String ifNull) {
        return isEmpty(str) ? ifNull : str;
    }
    
    /**
     * 입력 문자열이 비어있는 경우 "" 을 리턴하는 메소드
     * 
     * @param str 입력 문자열
     * @return str이 isEmpty이면 "", 그렇지 않은 경우 str 그대로 리턴
     */
    public static String nvl(String str) {
        return isEmpty(str) ? "" : str;
    }
}
