package collection;
/**
 * remove()·½·¨
 * @author jie
 *
 */
public class Test141<T> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	
	public Test141() {
		elementDate=new Object[DEFALT_CAPACITY];
	}
	
	public Test141(int capacity) {
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
	public void remove(int index) {
		System.arraycopy(elementDate,index+1,elementDate,index,elementDate.length-1-index);
		elementDate[--size]=null;
	}
	
	public void remove(Object obj) {
		for(int i=0;i<size;i++) {
			if(obj.equals(elementDate[i])) {
				remove(i);
			}
		}
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
		Test141<String> list=new Test141<String>(2);
		list.add("aa");
		list.add("bb");
		list.add("aa");
		list.add("bb");
//		list.remove(0);
		list.remove("bb");
		System.out.println(list);
	}
}
