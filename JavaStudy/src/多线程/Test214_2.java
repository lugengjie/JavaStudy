package ���߳�;

import java.util.Date;

/**
 * �̰߳�ȫ������ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * @author jie
 *synchronized
 *1.ͬ������
 *2.ͬ����:Ŀ�����ȷ
 */
public class Test214_2 {
	public static void main(String[] args) {
		Account account=new Account("������", 1000);
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
			System.out.println(this.getName()+"-->�˻���"+account.money);
			System.out.println(this.getName()+"-->�ڴ���Ǯ��"+pocketTotal);
		}
	}
	
}
	
	

