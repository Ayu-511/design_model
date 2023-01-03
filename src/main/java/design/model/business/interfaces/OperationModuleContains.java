package design.model.business.interfaces;

import java.util.HashMap;
import java.util.Map;

public interface OperationModuleContains {

    String MODULE_BUSINESS = "business";

    String MODULE_MANAGE = "manage";

    String MODULE_GATEWAY = "gateway";

    public interface OperationTypeContains {


        String LOGIN = "登录操作";

        String INSERT = "新增操作";

        String UPDATE = "更新操作";

        String DELETE = "删除操作";

        String QUERY = "查询操作";

        String EXPORT = "导出操作";

        String IMPORT = "导入操作";
    }

}
