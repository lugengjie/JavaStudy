package IO流技术;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流
 * 写出后读取
 * 读出顺序与写出顺序一致
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
			dos.writeUTF("我爱你");
			dos.writeByte(1);
			dos.writeChar('a');
			//记得强制刷新
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
