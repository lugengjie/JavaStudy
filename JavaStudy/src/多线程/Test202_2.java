package ���߳�;

public class Test202_2 {
	//��̬�ڲ���
	static class Test2 implements ITest{
		@Override
		public void test() {
			System.out.println("�����˱����������ʲô�о�2");
		}
	}
	public static void main(String[] args) {
		ITest test=new Test1();
		test.test();
		
		test=new Test2();
		test.test();
		//�ֲ��ڲ���
		class Test3 implements ITest{
			@Override
			public void test() {
				System.out.println("�����˱����������ʲô�о�3");
			}
		}
		test=new Test3();
		test.test();
		//�����ڲ���
		test=new ITest() {
			public void test() {
				System.out.println("�����˱����������ʲô�о�4");
			}
		};
		
		test.test();
		//lambda
		test=()->{
				System.out.println("�����˱����������ʲô�о�5");
		};
		test.test();
	}
}
interface ITest{
    void test();
}
//�ⲿ��
class Test1 implements ITest{
	@Override
	public void test() {
		System.out.println("�����˱����������ʲô�о�1");
	}
}
