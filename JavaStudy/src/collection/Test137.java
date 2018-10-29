package collection;
/**
 * 手工实现ArrayList,加泛型
 * @author jie
 *
 */
public class Test137<T> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	
	public Test137() {
		elementDate=new Object[DEFALT_CAPACITY];
	}
	
	public Test137(int capacity) {
		elementDate=new Object[capacity];
	}
	
	public void add(T obj) {
		elementDate[size++]=obj;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(elementDate[i]+",");
		}
		sb.setCharAt(sb.length()-1,']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Test137<String> list=new Test137<String>(20);
		list.add("aa");
		list.add("bb");
		System.out.println(list);
	}
}
