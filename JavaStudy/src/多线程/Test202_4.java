package 多线程;
//lambda推导+加参数+加返值
public class Test202_4 {
	public static void main(String[] args) {
		IInterest love=(int a,int b)->{
			System.out.println(a);
			return a+b;
		};
		System.out.println(love.lambda(1,2));
		
		love=(a,b)->{
			System.out.println(a);
			return a+b;
		};
		System.out.println(love.lambda(3,4));
		
	}
}
interface IInterest{
	int  lambda(int a,int b);
}


