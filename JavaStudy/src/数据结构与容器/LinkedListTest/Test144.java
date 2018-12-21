package 数据结构与容器.LinkedListTest;

/**
 * 实现LinkedList的get()查询方法
 * 节点遍历
 * @author jie
 *
 */
public class Test144 {
	private Node first;
	private Node last;
	private int size;
	
	public void add(Object obj) {
		Node temp=new Node(obj);
		if(first==null) {
			first=temp;
			last=temp;	
		}else {
			temp.previous=last;
			temp.next=null;
			last.next=temp;
			last=temp;
		}
		size++;
	}
	public Object get(int index) {
		Node temp=null;
		if(index<0||index>size-1) {
			return new RuntimeException("索引越界！");
		}
		if(index<(size>>1)) {
			temp=first;
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
		}else {
			temp=last;
			for(int i=size-1;i>index;i--) {
				temp=temp.previous;
			}
		}
		return temp.element;

	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		Node temp=first;
		while(temp!=null) {
			sb.append(temp.element+",");
			temp=temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public static void main(String[] args) {
		Test144 list=new Test144();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add("ee");
		list.add("ff");
		System.out.println(list.get(5));
	}
}
