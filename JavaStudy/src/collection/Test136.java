package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList������˳����ط���
 * @author jie
 *
 */
public class Test136 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list);
		
		/*
		 * ������Ϊ1��λ�ü���value,ԭ����Ԫ�������λ
		 */
		list.add(1,"d");
		System.out.println(list);
		
		list.set(1, "e");
		System.out.println(list);
		
		/**
		 * int indexOf(Object c);
		 * ����Objext C��һ�γ���λ�õ�����
		 * �޷���-1
		 */
		System.out.println(list.indexOf("a"));
		System.out.println(list.lastIndexOf("gg"));
		
	}
}
