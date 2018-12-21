package 数据结构与容器.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * 表格数据存储
 * javabean,List
 * @author jie
 *
 */
public class Test165 {
	public static void main(String[] args) {
		User u1=new User(1,1,"a");
		User u2=new User(2,2,"b");
		User u3=new User(3,3,"c");
		List<User> list=new ArrayList<>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		for(User user:list) {
			System.out.println(user);
		}
	}
}
class User{
	private int id;
	private double Salary;
	private String name;
	
	
	public User() {
	}
	
	public User(int id, double salary, String name) {
		this.id = id;
		Salary = salary;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Salary=" + Salary + ", name=" + name + "]";
	}
	
	
}
