package design.model.business.domain.entity;

import java.io.Serializable;

/**
 * 用户操作日志实体
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2023/01/02 13:01:00
 */
public class UserOperationLogEntity implements Serializable {

    private static final long serialVersionUID = 3864884180759675910L;
    /**
     * id
     */
    private String id;

    /**
     * 用户代码
     */
    private String userCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * ip addr
     */
    private String ipAddr;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * url
     */
    private String url;

    /**
     * 行为类型
     */
    private String behaviorType;

    /**
     * 描述
     */
    private String description;

    /**
     * 模型
     */
    private String model;

    /**
     * 操作时间
     */
    private String operationTime;

    /**
     * 结果
     */
    private String result;

    /**
     * 类名
     */
    private String className;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String parameter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Override
    public String toString() {
        return "UserOperationLogEntity{" +
                "id='" + id + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", url='" + url + '\'' +
                ", behaviorType='" + behaviorType + '\'' +
                ", description='" + description + '\'' +
                ", model='" + model + '\'' +
                ", operationTime='" + operationTime + '\'' +
                ", result='" + result + '\'' +
                ", className='" + className + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }
}
