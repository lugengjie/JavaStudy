package 数据结构与容器.MapTest;
/**
 * 重写toString方法打印Map内容
 * @author jie
 *
 */
public class Test155 {
	Node[] table;
	int size;
	public Test155() {
		table=new Node[16];
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		for(int i=0;i<table.length;i++) {
			Node temp=table[i];
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+",");
				temp=temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
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
		size++;
	}
	private int hash(int v,int length) {
		//取模运算
//		System.out.println("hash:"+(v%length));
		//位运算，效率高
		//System.out.println("hash:"+(v&(length-1)));
		return v&(length-1);
	}
	
	public static void main(String[] args) {
		Test155 map=new Test155();
		map.put("10","aa");
		map.put("20","bb");
		map.put("30","cc");
		System.out.println(map);
//		for(int i=0;i<100;i++) {
//			System.out.print(i+"的hash:");
//			map.put(i+"","test");
//		}
//		4 15 26
//		map.put("12", "test");
//		map.put("4","first");
//		map.put("15","second");
//		map.put("26","third");
//		map.put("15", "test");
	}
}
