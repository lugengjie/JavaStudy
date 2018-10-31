package ���ݽṹ������.LinkedListTest;
/**
 * ʵ��LinkedList��add()����
 * @author jie
 *
 */
public class Test142 {
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
		Test142 list=new Test142();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		System.out.println(list.toString());
	}
}
