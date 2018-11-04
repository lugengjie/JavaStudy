package IO������;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * IO�ֽ�������
 * ����Դ
 * ѡ����
 * ����
 * �ͷ���Դ
 * @author jie
 *
 */
public class Test177 {
	public static void main(String[] args) {
//		input();
		output();
	}
	/**
	 * �ֽ�������������ByteArrayInputStream
	 * ����Դ���ֽ����鲻Ҫ̫��
	 * ѡ����
	 * ����
	 * �ͷ���Դ������JVM,���ô���
	 */
	private static void input() {
		byte[] datas="talk is cheap show me the code".getBytes();
		InputStream input=null;
		try {
			input=new ByteArrayInputStream(datas);
			byte[] car=new byte[1024]; //��������
			int len=-1;
			while(-1!=(len=input.read(car))) {
				//�ֽ�����->�ַ��������룩
				System.out.print(new String(car,0,len));
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=input) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * �ֽ�������������ByteArrayOutputStream
	 * ����Դ��JVMά��
	 * ѡ������������Դ
	 * ������
	 * �ͷ���Դ������JVM,���ô���
	 * ��ȡ���ݣ�toByteArray()  
	 */
	private static void output() {
		//����Դ
		byte[] dest=null;
		//ѡ����
		ByteArrayOutputStream output=null;
		try {
			output=new ByteArrayOutputStream();
			//������д����
			output.write("talk is cheap show me the code".getBytes());
			output.flush();
			//��ȡ����
			dest=output.toByteArray();
			System.out.println(dest.length+"-->"+new String(dest,0,dest.length));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=output) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


