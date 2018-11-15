package 手写Httpserver项目;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java中的各种结构（方法、属性、构造器、类名)映射成一个个的java对象
 * 1、获取Class对象
 * 三种方式：Class.forName("包名.类名")
 * 2、可以动态创建对象
 * temp.getConstructor().newInstance()
 * @author jie
 *
 */
public class Test252 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//三种方式
		//1.对象getClass()
		IPhone iphone=new IPhone();
		Class temp=iphone.getClass();
		//2.类.class
		temp=IPhone.class;
		//3.Class.forName("包名.类名")
		temp=Class.forName("手写Httpserver项目.IPhone");
		
		//创建对象
		IPhone iphone2=(IPhone)temp.getConstructor().newInstance();
		System.out.println(iphone2);
	}
}
class IPhone{
	public IPhone() {
	
	}
	
}