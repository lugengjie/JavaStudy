package 数据结构与容器.ArrayListTest;
/**
 * 数组扩容
 * @author jie
 *
 */
public class Test138<T> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	
	public Test138() {
		elementDate=new Object[DEFALT_CAPACITY];
	}
	
	public Test138(int capacity) {
		elementDate=new Object[capacity];
	}
	
	public void add(T element) {
		if(size==elementDate.length) {
			Object[] tmp=new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0, tmp, 0,elementDate.length);
			elementDate=tmp;
		}
		
		elementDate[size++]=element;
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
		Test138<String> list=new Test138<String>(2);
		list.add("aa");
		list.add("bb");
		list.add("aa");
		list.add("bb");
		System.out.println(list);
	}
}
