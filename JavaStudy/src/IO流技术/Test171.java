package IO������;

import java.io.UnsupportedEncodingException;

public class Test171 {
	public static void main(String[] args) {
		String msg="��������ʹ��";
		//Ĭ��ʹ�ù��̵��ַ���
		//�ֽ�����
		byte[] datas=msg.getBytes();
		System.out.println(datas.length);
		//����
		try {
			datas=msg.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(datas.length);
		//����
		try {
			msg=new String(datas,0,datas.length,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(msg);
	}

}
