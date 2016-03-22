package rhy.sample.common.exception;

import java.util.List;

import rhy.sample.common.util.StringUtil;

public class RHYBaseException extends Exception {

    private static final long serialVersionUID = 2569614334516890083L;

    /** error code. */
    protected String errorCode;

    /** error message. */
    protected String errorMessage;
    
    /** arguments */
    protected List<Object> arguments;

    /** additional message */
    protected String additionalMessage;

    /**
     * The Constructor.
     * 
     * @param causeThrowable
     *            the cause throwable
     */
    public RHYBaseException(Throwable causeThrowable) {
        super(causeThrowable);
    }

    /**
     * The Constructor.
     * 
     * @param errCodeKey
     *            the err code key
     */
    public RHYBaseException(String errCodeKey) {
        super(StringUtil.nvl(errCodeKey));
    }

    /**
     * The Constructor.
     * 
     * @param errCodeKey
     *            the err code key
     * @param causeThrowable
     *            the cause throwable
     */
    public RHYBaseException(String errCodeKey, Throwable causeThrowable) {
        super(errCodeKey, causeThrowable);
    }

    /**
     * code 와 locale 정보로 message bundle에서 메세지를 가져온다.
     * 
     * @param code
     *            the code
     * @return the message
     */
    public String getMessage(String code) {
        //TODO : 다국어 지원시 code 값으로 message 가져오는 부분 구현 필요
        return "## ERROR : " + code;
    }

    /**
     * code 와 argument, locale 정보로 message bundle에서 메세지를 가져온다.
     * 
     * @param code
     *            the code
     * @param arguments
     *            the arguments
     * @return the message
     */
    public String getMessage(String code, List<Object> arguments) {
        //TODO : 다국어 지원시 code 값으로 message 가져오는 부분 구현 필요
        return "## ERROR : " + code;
    }

    /**
     * Gets the error code.
     * 
     * @return the error code
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     * 
     * @param errorCode
     *            the new error code
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the arguments
     * 
     * @return the arguments
     */
    public List<Object> getArguments() {
        return arguments;
    }

    /**
     * Sets the arguments
     * 
     * @param arguments
     */
    public void setArguments(List<Object> arguments) {
        this.arguments = arguments;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public void setAdditionalMessage(String additionalMessage) {
        this.additionalMessage = additionalMessage;
    }
}
