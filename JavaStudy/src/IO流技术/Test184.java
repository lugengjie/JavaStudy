package IO������;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * ������
 * д�����ȡ
 * ����˳����д��˳��һ��
 * DataOutputStream()
 * DataInputStream()
 * @author jie
 *
 */
public class Test184 {
	public static void main(String[] args) {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
		try {
			dos.writeUTF("�Ұ���");
			dos.writeByte(1);
			dos.writeChar('a');
			//�ǵ�ǿ��ˢ��
			dos.flush();
			byte[] datas=baos.toByteArray();
			ByteArrayInputStream bais=new ByteArrayInputStream(datas);
			DataInputStream dis=new DataInputStream(new BufferedInputStream(bais));
			System.out.println(dis.readUTF());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
