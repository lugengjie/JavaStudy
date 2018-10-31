package 数据结构与容器.MapTest;

import java.util.Map;
import java.util.TreeMap;

public class Test157 {
	public static void main(String[] args) {
//		Map<Integer,String> treeMap=new TreeMap<Integer,String>();
//		treeMap.put(1,"first");
//		treeMap.put(5,"second");
//		treeMap.put(3,"third");
//		
//		for(Integer i:treeMap.keySet()) {
//			System.out.println("hash:"+i+"->"+treeMap.get(i));
//		}
		Map<Emp,String> treeMap2=new TreeMap<>();
		treeMap2.put(new Emp(3,3,"c"), "c");
		treeMap2.put(new Emp(1,1,"a"), "a");
		treeMap2.put(new Emp(2,2,"b"), "b");
		treeMap2.put(new Emp(1,3,"c"), "d");
		for(Emp ep:treeMap2.keySet()) {
			System.out.println("hash:"+ep+"->"+treeMap2.get(ep));
		}
	}
}
class Emp implements Comparable<Emp>{
	int id;
	double salary;
	String name;
	
	public Emp(int id, double salary, String name) {
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}


	@Override
	public int compareTo(Emp o) {
		if(this.salary>o.salary) {
			return 1;
		}else if(this.salary<o.salary) {
			return -1;
		}else {
			if(this.id>o.id) {
				return 1;
			}else if(this.id<o.id) {
				return -1;
			}else {
				return 0;
			}
		}
	}
}
