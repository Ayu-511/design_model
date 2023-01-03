package design.model.business.reflect;

import java.io.Serializable;

/**
 * 反映演示
 *
 * Java 反射机制主要提供了以下功能，这些功能都位于java.lang.reflect包。
 * 在运行时判断任意一个对象所属的类。
 * 在运行时构造任意一个类的对象。
 * 在运行时判断任意一个类所具有的成员变量和方法。
 * 在运行时调用任意一个对象的方法。
 * 生成动态代理。
 *
 *         ===============反射可访问的常用信息=================
 * 类型           访问方法                        返回值类型                       说明
 * 包路径	    getPackage()	                Package 对象	            获取该类的存放路径
 * 类名称	    getName()	                    String 对象	            获取该类的名称
 * 继承类	    getSuperclass()	                Class 对象	            获取该类继承的类
 * 实现接口	    getlnterfaces()	                Class 型数组	            获取该类实现的所有接口
 * 构造方法	    getConstructors()	            Constructor型数组	    获取所有权限为 public 的构造方法
 * 构造方法       getDeclaredContruectors()	    Constructor 对象	        获取当前对象的所有构造方法
 * 方法	        getMethods()	                Methods 型数组	        获取所有权限为 public 的方法
 * 方法          getDeclaredMethods()	        Methods 对象	            获取当前对象的所有方法
 * 成员变量	    getFields()	                    Field 型数组	            获取所有权限为 public 的成员变量
 * 成员变量       getDeclareFileds()	            Field 对象	            获取当前对象的所有成员变量
 * 内部类	    getClasses()	                Class 型数组	            获取所有权限为 public 的内部类
 * 内部类        getDeclaredClasses()	        Class 型数组	            获取所有内部类
 * 内部类的声明类	getDeclaringClass()	            Class 对象	            如果该类为内部类，则返回它的成员类，否则返回 null
 *
 * 在调用 getFields() 和 getMethods() 方法时将会依次获取权限为 public 的字段和变量，
 * 然后将包含从超类中继承到的成员变量和方法。而通过 getDeclareFields() 和 getDeclareMethod() 只是获取在本类中定义的成员变量和方法。
 *
 * Java 反射机制的优缺点
 * 优点：
 * 能够运行时动态获取类的实例，大大提高系统的灵活性和扩展性。
 * 与 Java 动态编译相结合，可以实现无比强大的功能。
 * 对于 Java 这种先编译再运行的语言，能够让我们很方便的创建灵活的代码，这些代码可以在运行时装配，无需在组件之间进行源代码的链接，更加容易实现面向对象。
 *
 * 缺点：
 * 反射会消耗一定的系统资源，因此，如果不需要动态地创建一个对象，那么就不需要用反射；
 * 反射调用方法时可以忽略权限检查，获取这个类的私有方法和属性，因此可能会破坏类的封装性而导致安全问题。
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2023/01/02 14:01:80
 */
public class ReflectDemo {
    public void get() {

    }

}
