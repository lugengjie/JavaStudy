package 数据结构与容器.SetTest;

import java.util.Set;
import java.util.TreeSet;




/**
 * TreeSet的使用
 * @author jie
 *
 */
public class Test160 {
	public static void main(String[] args) {
//		Set<Integer> set=new TreeSet<Integer>();
//		set.add(9);
//		set.add(5);
//		set.add(4);
//		//递增排序
//		for(Integer i:set) {
//			System.out.println(i);
//		}
		Set<Emp2> set2=new TreeSet<Emp2>();
		set2.add(new Emp2(3,3,"c"));
		set2.add(new Emp2(1,1,"a"));
		set2.add(new Emp2(2,2,"b"));
		set2.add(new Emp2(1,3,"c"));
		for(Emp2 emp:set2) {
			System.out.println(emp);
		}
	}
}
class Emp2 implements Comparable<Emp2>{
	int id;
	double salary;
	String name;
	
	
	public Emp2(int id, double salary, String name) {
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}


	@Override
	public int compareTo(Emp2 o) {
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
