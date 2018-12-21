package 数据结构与容器.ArrayListTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	/**
	  * 测试两个集合间的操作
	  * addAll()
	  * removeAll()
	  * retainAll()
	  * iterator()
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list1=new ArrayList<String>();
		list1.add("aa");
		list1.add("bb");
		list1.add("cc");
		
		List<String> list2=new ArrayList<String>();
		list2.add("bb");
		list2.add("cc");
		list2.add("ee");
		
//		list1.addAll(list2);
	
//		list1.removeAll(list2);
		
//		list1.retainAll(list2);
		
//		System.out.println(list1);
	
//		Iterator<String> it=list1.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
	}
}
