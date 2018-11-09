package ���߳�;
/**
 * Э��ģ�ͣ������������� ʵ�ַ��������źŵ�
 * @author jie
 *
 */
public class Test213 {
	public static void main(String[] args) {
		Tv tv=new Tv();
		Player player=new Player(tv);
		Watcher watcher=new Watcher(tv);
		player.start();
		watcher.start();
	}
}
//������ ��Ա
class Player extends Thread{
	Tv tv;
	public Player(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++)
			this.tv.play("����˵");
	}
}
class Watcher extends Thread{
	Tv tv;

	public Watcher(Tv tv) {
		this.tv = tv;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			tv.watch();
		}
	}
	
}
class Tv{
	String voice;
	//�źŵ�
	//true��ʾ��Ա���ݣ����ڵȴ�
	//false��ʾ���ڵȴ� ��Ա����
	boolean flag=true;
	
	//����
	public synchronized void play(String voice) {
		//��Ա�ȴ�
		if(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//����
		System.out.println("������"+voice);
		this.voice=voice;
		//����
		this.notifyAll();
		//�л���־
		this.flag=!this.flag;
	}
	//�ۿ�
	public synchronized void watch() {
		//���ڵȴ�
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//�ۿ�
		System.out.println("�ۿ���"+voice);
		//����
		this.notifyAll();
		//�л���־
		this.flag=!this.flag;
	}
	
}

