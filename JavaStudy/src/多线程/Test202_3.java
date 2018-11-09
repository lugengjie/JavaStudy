package 多线程;
//lambda推导+加参数
public class Test202_3 {
	public static void main(String[] args) {
		ILove love=(int a)->{
			System.out.println(a);
		};
		love.lambda(1);
		//简化
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


