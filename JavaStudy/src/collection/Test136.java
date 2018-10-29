package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList索引与顺序相关方法
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
		 * 在索引为1的位置加入value,原来的元素向后移位
		 */
		list.add(1,"d");
		System.out.println(list);
		
		list.set(1, "e");
		System.out.println(list);
		
		/**
		 * int indexOf(Object c);
		 * 返回Objext C第一次出现位置的索引
		 * 无返回-1
		 */
		System.out.println(list.indexOf("a"));
		System.out.println(list.lastIndexOf("gg"));
		
	}
}
