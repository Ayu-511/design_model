package design.model.business.utils.annotation;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import design.model.business.domain.entity.UserOperationLogEntity;
import design.model.business.mapper.aop.OperationLogMapper;
import design.model.business.utils.id.UuidUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 操作日志切面
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2022/12/30 17:12:74
 */
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperationLogMapper operationLogMapper;

    private static final Logger logger = LoggerFactory.getLogger(OperationLogAspect.class);

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 设置操作日志切入点   在注解的位置切入代码
     */
    @Pointcut("@annotation(design.model.business.utils.annotation.OperationLogAnnotation)")
    public void operationLogAspect() {
    }

    @AfterReturning(value = "operationLogAspect()")
    public void insertOperationLog(JoinPoint joinPoint) {
        logger.info("切面日志");
        UserOperationLogEntity userOperationLogEntity = new UserOperationLogEntity();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 获取RequestAttributs
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        OperationLogAnnotation annotation = method.getAnnotation(OperationLogAnnotation.class);
        try {
            if (null != annotation) {
                userOperationLogEntity.setModel(annotation.modul());
                userOperationLogEntity.setBehaviorType(annotation.type());
                userOperationLogEntity.setDescription(annotation.desc());
            }
            userOperationLogEntity.setUserCode(System.currentTimeMillis() + "");
            userOperationLogEntity.setUserName(System.currentTimeMillis() + "用户");
            userOperationLogEntity.setId(UuidUtils.getUuId());
            userOperationLogEntity.setIpAddr(request.getRemoteHost()); //获取调用ip地址： 127.0.0.1
            userOperationLogEntity.setUrl(request.getRequestURL().toString()); // 获取请求的路径： http://127.0.0.1:8080/user/operation/log/login
            userOperationLogEntity.setClassName(joinPoint.getTarget().getClass().getName()); // 获取请求的类名： design.model.business.controller.UserOperationLogController
            userOperationLogEntity.setRequestMethod(((MethodSignature) joinPoint.getSignature()).getMethod().getName());  // 获取方法名称: UserLogin
            Object[] args = joinPoint.getArgs(); // 获取参数值
            StringBuffer requestBody = new StringBuffer();
            for (Object arg : args) {
                ObjectMapper mapper = new ObjectMapper();
                String s = mapper.writeValueAsString("1");
                requestBody.append(mapper.writeValueAsString(arg));
            }
            String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames(); // 获取参数名

            userOperationLogEntity.setParameter(requestBody.toString());
            logger.info("[{}]", JSON.toJSONString(userOperationLogEntity));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作日志失败: {}", e.toString());
        } finally {
            userOperationLogEntity.setOperationTime(sdf.format(new Date())); // 2023-01-02 15:15:16
            operationLogMapper.insert(userOperationLogEntity);
        }

    }
}
