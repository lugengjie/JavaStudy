package ������.Test242;

public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkSend(8888,"localhost",9999)).start();
		new Thread(new TalkReceive(6666,"ѧ��")).start();
	}
}
