package 多线程;

import java.util.Date;

/**
 * 线程安全：并发时保证数据的正确性，效率尽可能高
 * @author jie
 *synchronized
 *1.同步方法
 *2.同步块:目标更明确
 */
public class Test214_2 {
	public static void main(String[] args) {
		Account account=new Account("结婚礼金", 1000);
		Drawing you=new Drawing(account,80, "ME");
		Drawing wife=new Drawing(account,90, "WIFE");
		you.start();
		wife.start();
	}
}
class Account{
	String name;
	int money;
	public Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	
}

class Drawing extends Thread{
	private Account account;
	private int drawingMoney;
	private int pocketTotal;
	
	
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
		this.pocketTotal = pocketTotal;
	}


	@Override
	public void run() {
		test();
		
	}
	private  void  test() {
		synchronized (account) {
			if(account.getMoney()-drawingMoney<0) {
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.money-=drawingMoney;
			pocketTotal+=drawingMoney;
			System.out.println(this.getName()+"-->账户余额："+account.money);
			System.out.println(this.getName()+"-->口袋的钱："+pocketTotal);
		}
	}
	
}
	
	

