package 数据结构与容器.SetTest;

import java.util.HashMap;

/**
 * 手动实现HashSet
 * @author jie
 *
 */
public class Test159 {
	private HashMap map;
	private static final Object PRESENT=new Object();
	public Test159() {
		this.map = new HashMap();
	}
	public void add(Object o) {
		map.put(o,PRESENT);
	}
	public int size() {
		return map.size();
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("[");
		for(Object key:map.keySet()) {
			sb.append(key+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public static void main(String[] args) {
		Test159 hashSet=new Test159();
		hashSet.add("first");
		hashSet.add("second");
		hashSet.add("third");
		System.out.println(hashSet);
	}
	
}
