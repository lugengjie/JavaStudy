package 网络编程.Test242;

public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999,"老师")).start();
		new Thread(new TalkSend(7777,"localhost",6666)).start();
	}
}
