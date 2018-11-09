package 多线程;

public class Test202_2 {
	//静态内部类
	static class Test2 implements ITest{
		@Override
		public void test() {
			System.out.println("被别人抱抱，哄哄是什么感觉2");
		}
	}
	public static void main(String[] args) {
		ITest test=new Test1();
		test.test();
		
		test=new Test2();
		test.test();
		//局部内部类
		class Test3 implements ITest{
			@Override
			public void test() {
				System.out.println("被别人抱抱，哄哄是什么感觉3");
			}
		}
		test=new Test3();
		test.test();
		//匿名内部类
		test=new ITest() {
			public void test() {
				System.out.println("被别人抱抱，哄哄是什么感觉4");
			}
		};
		
		test.test();
		//lambda
		test=()->{
				System.out.println("被别人抱抱，哄哄是什么感觉5");
		};
		test.test();
	}
}
interface ITest{
    void test();
}
//外部类
class Test1 implements ITest{
	@Override
	public void test() {
		System.out.println("被别人抱抱，哄哄是什么感觉1");
	}
}
