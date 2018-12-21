package 数据结构与容器.MapTest;
/**
 * put(key,value)
 * 解决键重复问题
 * @author jie
 *
 */
public class Test153 {
	Node[] table;
	int size;
	public Test153() {
		table=new Node[16];
	}
	public void put(Object key,Object value) {
		Node newNode=new Node();
		newNode.key=key;
		newNode.value=value;
		newNode.hash=hash(key.hashCode(),table.length);
		newNode.next=null;
		Node temp=table[newNode.hash];
		
		if(temp==null) {
			table[newNode.hash]=newNode;
		}else {
			Node preNode=null;
			while(temp!=null) {
				if(temp.key.equals(key)) {
					temp.value=value;
					break;
				}else {
					preNode=temp;
					temp=temp.next;
				}
			}
			if(temp==null) {
				preNode.next=newNode;
			}
		}
		
	}
	private int hash(int v,int length) {
		//取模运算
//		System.out.println("hash:"+(v%length));
		//位运算，效率高
		//System.out.println("hash:"+(v&(length-1)));
		return v&(length-1);
	}
	
	public static void main(String[] args) {
		Test153 map=new Test153();
//		map.put("10","aa");
//		map.put("20","bb");
//		map.put("30","cc");
//		for(int i=0;i<100;i++) {
//			System.out.print(i+"的hash:");
//			map.put(i+"","test");
//		}
//		4 15 26
		map.put("12", "test");
		map.put("4","first");
		map.put("15","second");
		map.put("26","third");
		map.put("15", "test");
		System.out.println("Test153.main()");
	}
}
