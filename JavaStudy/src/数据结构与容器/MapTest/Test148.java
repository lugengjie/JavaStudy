package 数据结构与容器.MapTest;

import java.util.HashMap;
import java.util.Map;
/**
 * map接口常用方法
 * @author jie
 *键对象不能重复，重复的，新的会覆盖久的
 */
public class Test148 {
	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<Integer,String>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
	
		System.out.println(map.get(1));
		System.out.println(map.isEmpty());
		System.out.println(map.containsKey(1));
		System.out.println(map.containsValue("Two"));
//		map.put(3, "Override");
//		map.remove(3);
//		map.clear();
		Map<Integer,String> map2=new HashMap<Integer,String>();
		map2.put(4,"four");
		map.putAll(map2);
		System.out.println(map);
	}
}
