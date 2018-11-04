package IO������;
/**
 * װ�������ģʽ
 * ģ�⿧��
 * 1���������:��Ҫװ�εĳ������(�ӿڻ������)
 * 2���������:��Ҫװ�εĶ���
 * 3������װ����:�����˶Գ�������������Լ�װ���Ź��еķ���
 * 4������װ����:��װ�εĶ���
 * @author jie
 */
public class Test180 {
	public static void main(String[] args) {
		Coffee coffee=new Coffee();
		System.out.println(coffee.info()+"-->"+coffee.cost());
		Milk milk=new Milk(coffee);//װ��
		System.out.println(milk.info()+"-->"+milk.cost());
		Suger suger=new Suger(coffee);//װ��
		System.out.println(suger.info()+"-->"+suger.cost());
		milk=new Milk(suger);//װ��
		System.out.println(milk.info()+"-->"+milk.cost());
		
	}
	
}
interface Drink{
	double cost();  //�۸�
	String info();	//��Ϣ
}
class Coffee implements Drink{
	private String name="ԭζ����";
	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}
}
abstract class Decorate implements Drink{ 
	Drink drink;

	public Decorate(Drink drink) {
		this.drink=drink;
	}
	
	@Override
	public double cost() {
		return drink.cost();
	}

	@Override
	public String info() {
		return drink.info();
	}		
}

class Milk extends Decorate{
	public Milk(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		return drink.cost()*2;
	}
	@Override
	public String info() {
		return drink.info()+"��ţ��";
	}	
}
class Suger extends Decorate{

	public Suger(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		return drink.cost()*4;
	}
	@Override
	public String info() {
		return drink.info()+"����";
	}
	
}
