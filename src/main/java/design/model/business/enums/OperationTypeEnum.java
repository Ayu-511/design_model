package design.model.business.enums;

/**
 * 操作类型枚举
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2022/12/30 11:12:98
 */
public enum OperationTypeEnum {
    /**
     * 登录
     */
    LOGIN("business", "登录"),

    /**
     * 插入
     */
    INSERT("insert", "新增"),

    /**
     * 更新
     */
    UPDATE("update", "更新"),

    /**
     * 删除
     */
    DELETE("delete", "删除"),

    /**
     * 查询
     */
    QUERY("query", "查询"),
    ;


    private  String type;

    private  String typeName;

    public String getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public static String getDescription(String type) {
        for (OperationTypeEnum enums : OperationTypeEnum.values()) {
            if (enums.type.equals(type)) {
                return enums.typeName;
            }
        }
        return null;
    }


    OperationTypeEnum(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }
}
