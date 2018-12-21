package 多线程;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：Timer类和TimerTask类
 * @author jie
 *
 */
public class Test224 {
	public static void main(String[] args) {
		Timer timer=new Timer();
//		timer.schedule(new MyTask(),5000,2000);
//		timer.schedule(new MyTask(),5000,2000);
		Calendar cal=new GregorianCalendar(2018,10,9,23,30,15);
		timer.schedule(new MyTask(),cal.getTime(),200);
	}
	
}
//任务类
class MyTask extends TimerTask{
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hello World");
		}
	}
}
