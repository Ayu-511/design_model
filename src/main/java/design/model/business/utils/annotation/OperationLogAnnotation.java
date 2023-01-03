package design.model.business.utils.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注释
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2022/12/29 15:12:25
 */
@Target(ElementType.METHOD) ////注解放置的目标位置即方法级别
/**
 * @Target(ElementType.TYPE)——接口、类、枚举、注解
 * @Target(ElementType.FIELD)——字段、枚举的常量
 * @Target(ElementType.METHOD)——方法
 * @Target(ElementType.PARAMETER)——方法参数
 * @Target(ElementType.CONSTRUCTOR) ——构造函数
 * @Target(ElementType.LOCAL_VARIABLE)——局部变量
 * @Target(ElementType.ANNOTATION_TYPE)——注解
 * @Target(ElementType.PACKAGE)——包，用于记录java文件的package信息
 */
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
/**
 * RetentionPolicy.SOURCE
 * 表示注解只保留在源文件，当java文件编译成class文件，就会消失	源文件	只是做一些检查性的操作，，比如 @Override 和 @SuppressWarnings
 * RetentionPolicy.CLASS
 * 注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期	class文件（默认）	要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife）
 * RetentionPolicy.RUNTIME
 * 注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在	运行时也存在	需要在运行时去动态获取注解信息
 */
@Documented
public @interface OperationLogAnnotation {


    String modul() default ""; // 操作模块

    String type() default ""; //操作类型

    String desc() default ""; //操作说明

}
