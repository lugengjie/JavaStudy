package ��дHttpserver��Ŀ;

import java.lang.reflect.InvocationTargetException;

/**
 * ���䣺��java�еĸ��ֽṹ�����������ԡ�������������)ӳ���һ������java����
 * 1����ȡClass����
 * ���ַ�ʽ��Class.forName("����.����")
 * 2�����Զ�̬��������
 * temp.getConstructor().newInstance()
 * @author jie
 *
 */
public class Test252 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//���ַ�ʽ
		//1.����getClass()
		IPhone iphone=new IPhone();
		Class temp=iphone.getClass();
		//2.��.class
		temp=IPhone.class;
		//3.Class.forName("����.����")
		temp=Class.forName("��дHttpserver��Ŀ.IPhone");
		
		//��������
		IPhone iphone2=(IPhone)temp.getConstructor().newInstance();
		System.out.println(iphone2);
	}
}
class IPhone{
	public IPhone() {
	
	}
	
}