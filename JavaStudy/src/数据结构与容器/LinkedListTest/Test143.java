package 数据结构与容器.LinkedListTest;

/**
 * 实现LinkedList的remove()方法
 * 移除节点
 * @author jie
 *
 */
public class Test143 {
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
	public void remove(int index) {
		Node temp=getNode(index);
		if(temp!=null) {
			Node up=temp.previous;
			Node down=temp.next;
			if(up!=null) {
				up.next=down;
			}
			if(down!=null) {
				down.previous=up;
			}
			if(0==index) {
				first=down;
			}
			if(size-1==index) {
				last=up;
			}
		}
		size--;
		
	}
	public Object get(int index) {
		Node temp=getNode(index);
		return temp==null?null:temp.element;
	}
	
	public Node getNode(int index) {
		Node temp=null;
		if(index<0||index>size-1) {
			throw new RuntimeException("索引越界！");
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
		return temp;
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
		Test143 list=new Test143();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");		list.add("ee");
		list.add("ff");
//		list.remove(0);
//		list.remove(5);
		list.remove(3);
		System.out.println(list);
	}
}
