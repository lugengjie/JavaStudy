package IO流技术;
/**
 * 装饰器设计模式
 * 模拟咖啡
 * 1、抽象组件:需要装饰的抽象对象(接口或抽象父类)
 * 2、具体组件:需要装饰的对象
 * 3、抽象装饰类:包含了对抽象组件的引用以及装饰着共有的方法
 * 4、具体装饰类:被装饰的对象
 * @author jie
 */
public class Test180 {
	public static void main(String[] args) {
		Coffee coffee=new Coffee();
		System.out.println(coffee.info()+"-->"+coffee.cost());
		Milk milk=new Milk(coffee);//装饰
		System.out.println(milk.info()+"-->"+milk.cost());
		Suger suger=new Suger(coffee);//装饰
		System.out.println(suger.info()+"-->"+suger.cost());
		milk=new Milk(suger);//装饰
		System.out.println(milk.info()+"-->"+milk.cost());
		
	}
	
}
interface Drink{
	double cost();  //价格
	String info();	//信息
}
class Coffee implements Drink{
	private String name="原味咖啡";
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
		return drink.info()+"加牛奶";
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
		return drink.info()+"加糖";
	}
	
}
