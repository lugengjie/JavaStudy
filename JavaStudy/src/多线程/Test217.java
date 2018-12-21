package 多线程;
/**
 * 开心影院 
 */
import java.util.ArrayList;
import java.util.List;

public class Test217 {
	public static void main(String[] args) {
		List available=new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(4);
		available.add(5);
		available.add(6);
		
		Cinema cinema=new Cinema(available,"开心影院");
		List sizes1=new ArrayList<Integer>();
		sizes1.add(1);
		sizes1.add(2);
		sizes1.add(3);
		sizes1.add(4);
		List sizes2=new ArrayList<Integer>();
		sizes2.add(4);
		sizes2.add(5);
		sizes2.add(6);
		
		new Thread(new Customer(cinema,sizes1)).start();
		new Thread(new Customer(cinema,sizes2)).start();
	}
}
class Customer implements Runnable{
	Cinema cinema;
	List<Integer> sizes;
	public Customer(Cinema cinema, List<Integer> sizes) {
		this.cinema = cinema;
		this.sizes = sizes;
	}
	@Override
	public void run() {
		synchronized(cinema){
			boolean flag=cinema.bookTickets(sizes);
			if(flag) {
				System.out.println(Thread.currentThread().getName()+"-->出票成功："+sizes);
			}else {
				System.out.println(Thread.currentThread().getName()+"-->出票失败");
			}
		}
	}
	
}
class Cinema{
	List<Integer> available;
	String name;
	public Cinema(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	public boolean bookTickets(List<Integer> sizes) {
		System.out.println("当前可用位置："+available);
		List<Integer> copy=new ArrayList<Integer>();
		copy.addAll(available);
		copy.removeAll(sizes);
		if(copy.size()+sizes.size()==available.size()) {
			available=copy;
			return true;
		}
		return false;
	}
}
