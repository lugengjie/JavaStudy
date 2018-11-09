package ���߳�;

import java.awt.Container;

/**
 * Э��ģ�ͣ�������������ʵ�ַ���1���̷ܳ�
 * ����������
 * @author jie
 */
public class Test222 {
	public static void main(String[] args) {
		SynContainer container=new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}
//������
class Productor extends Thread{
	SynContainer container;

	public Productor(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		//����
		for(int i=0;i<100;i++) {
			System.out.println("������"+i+"����ͷ");
			container.push(new Streambun(i));
		}
	}
}
//������
class Consumer extends Thread{
	SynContainer container;

	public Consumer(SynContainer container) {
		this.container = container;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("���ѵ�"+container.pop().id+"����ͷ");	
		}
	}
}
//��ͷ
class Streambun{
	int id;

	public Streambun(int id) {
		super();
		this.id = id;
	}
}
//������
class SynContainer{
	//�洢����
	Streambun[] buns=new Streambun[10];
	//������
	int count=0;
	//�洢 ����
	public synchronized void push(Streambun bun) {
		//��ʱ������ �������ڿռ�
		//�������� ֻ�еȴ�
		if(count==buns.length) {
			try {
				this.wait();  //�߳�������������֪ͨ�������
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
		}
		//���ڿռ� ��������
		buns[count]=bun;
		count++;
		//�������ݿ���֪ͨ����
		this.notifyAll();
	}
	public synchronized Streambun pop() {
		//��ʱ���� �������Ƿ��������
		//������ ֻ�ܵȴ�
		if(count==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
		}
		//�������� ��������
		count--;
		Streambun bun=buns[count];
		//���ڿռ䣬���Ի��ѶԷ�����
		this.notifyAll();
		return bun;
	}
}



