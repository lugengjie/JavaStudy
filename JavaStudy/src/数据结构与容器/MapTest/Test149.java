package 数据结构与容器.MapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Hashmap常用方法测试2
 * @author jie
 *
 */
public class Test149 {
	public static void main(String[] args) {
		Map<Integer,Employee> map=new HashMap<Integer,Employee>();
		Employee e1=new Employee("小明",1,1);
		Employee e2=new Employee("小黄",2,2);
		Employee e3=new Employee("小黑",3,3);
		map.put(1, e1);
		map.put(2, e2);
		map.put(3, e3);
		System.out.println(map.get(2));
		
	}
}
 class Employee{
	String name;
	int salary;
	int age;
	
	public Employee(String name, int salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;	
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}
	
}
