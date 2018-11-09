package 多线程;

import java.awt.Container;

/**
 * 协作模型：生产者消费者实现方法1：管程法
 * 借助缓冲区
 * @author jie
 */
public class Test222 {
	public static void main(String[] args) {
		SynContainer container=new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}
//生产者
class Productor extends Thread{
	SynContainer container;

	public Productor(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		//生产
		for(int i=0;i<100;i++) {
			System.out.println("生产第"+i+"个馒头");
			container.push(new Streambun(i));
		}
	}
}
//消费者
class Consumer extends Thread{
	SynContainer container;

	public Consumer(SynContainer container) {
		this.container = container;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("消费第"+container.pop().id+"个馒头");	
		}
	}
}
//馒头
class Streambun{
	int id;

	public Streambun(int id) {
		super();
		this.id = id;
	}
}
//缓冲区
class SynContainer{
	//存储容器
	Streambun[] buns=new Streambun[10];
	//计数器
	int count=0;
	//存储 生产
	public synchronized void push(Streambun bun) {
		//何时能生产 容器存在空间
		//不能生产 只有等待
		if(count==buns.length) {
			try {
				this.wait();  //线程阻塞，消费者通知生产解除
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
		}
		//存在空间 可以生产
		buns[count]=bun;
		count++;
		//存在数据可以通知消费
		this.notifyAll();
	}
	public synchronized Streambun pop() {
		//何时消费 容器中是否存在数据
		//不存在 只能等待
		if(count==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
		}
		//存在数据 可以消费
		count--;
		Streambun bun=buns[count];
		//存在空间，可以唤醒对方生产
		this.notifyAll();
		return bun;
	}
}



