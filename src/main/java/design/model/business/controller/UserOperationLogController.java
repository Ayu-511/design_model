package design.model.business.controller;

import design.model.business.interfaces.OperationModuleContains;
import design.model.business.utils.annotation.OperationLogAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/operation/log")
public class UserOperationLogController {

    @OperationLogAnnotation(modul = OperationModuleContains.MODULE_BUSINESS,
            type = OperationModuleContains.OperationTypeContains.LOGIN)
    @RequestMapping ("/login")
    public String userLogin(@RequestParam("id") String id, @RequestParam("password") String password) {
        return "登录成功: id:[" + id + "], " + "password: [" + password + "]";
    }
}
