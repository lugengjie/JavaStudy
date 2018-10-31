package 数据结构与容器.SetTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Iterator迭代器遍历容器元素（List/Set/Map)
 * @author jie
 *
 */
public class Test161 {
	public static void main(String[] args) {
		mapTest();
		listTest();
	}
	private static void mapTest() {
		Map<Integer,String> map=new HashMap<Integer,String>(); 
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		Set<Entry<Integer,String>> eis=map.entrySet();
		for(Iterator<Entry<Integer,String>> iter=eis.iterator();iter.hasNext();) {
			Entry<Integer,String> temp=iter.next();
			System.out.println(temp.getKey()+"---"+temp.getValue());
		}
	}
	private static void listTest() {
		List<String> list=new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		for(Iterator<String> iter=list.iterator();iter.hasNext();) {
			String temp=iter.next();
			System.out.println(temp);
		}
	}
}


