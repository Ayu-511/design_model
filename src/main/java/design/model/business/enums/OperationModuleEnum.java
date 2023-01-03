package design.model.business.enums;

/**
 * 操作模块枚举
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2022/12/30 11:12:98
 */
public enum OperationModuleEnum {
    /**
     * 模块业务
     */
    MODULE_BUSINESS("business", "业务模块"),

    /**
     * 模块管理
     */
    MODULE_MANAGE("manage", "后台管理"),

    /**
     * 模块网关
     */
    MODULE_GATEWAY("gateway", "网关模块"),
    ;


    private final String module;

    private final String moduleName;

    public String getModule() {
        return module;
    }

    public String getModuleName() {
        return moduleName;
    }

    OperationModuleEnum(String module, String moduleName) {
        this.module = module;
        this.moduleName = moduleName;
    }
}
