package ���ݽṹ������.MapTest;
/**
 * put(key,value)
 * �洢��ֵ��
 * @author jie
 *
 */
public class Test152 {
	Node[] table;
	int size;
	public Test152() {
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
		}
		
	}
	private int hash(int v,int length) {
		//ȡģ����
		System.out.println("hash:"+(v%length));
		//λ���㣬Ч�ʸ�
		System.out.println("hash:"+(v&(length-1)));
		return v&(length-1);
	}
	
	public static void main(String[] args) {
		Test152 map=new Test152();
		map.put("10","aa");
		map.put("20","bb");
		map.put("30","cc");
	}
}
