package ���߳�;
//lambda�Ƶ�+�Ӳ���
public class Test202_3 {
	public static void main(String[] args) {
		ILove love=(int a)->{
			System.out.println(a);
		};
		love.lambda(1);
		//��
		love=(a)->{
			System.out.println(a);
		};
		love.lambda(2);
		
		love=a->{
			System.out.println(a);
		};
		love.lambda(3);
		
		love=a->System.out.println(a);
		love.lambda(4);
	}
}
interface ILove{
	void lambda(int a);
}


