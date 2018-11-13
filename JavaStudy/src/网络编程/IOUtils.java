package 网络编程;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *1銆� 鍥剧墖璇诲彇鍒板瓧鑺傛暟缁�
 *2銆� 瀛楄妭鏁扮粍鍐欏嚭鍒版枃浠�
 *  @author 瑁存柊
 *
 */
public class IOUtils {
	/**
	 * 1銆佸浘鐗囪鍙栧埌瀛楄妭鏁扮粍
	 * 1)銆佸浘鐗囧埌绋嬪簭  FileInputStream
	 * 2)銆佺▼搴忓埌瀛楄妭鏁扮粍	ByteArrayOutputStream
	 */
	public static byte[] fileToByteArray(String filePath) {
		//1銆佸垱寤烘簮涓庣洰鐨勫湴
		File src = new File(filePath);
		byte[] dest =null;
		//2銆侀�夋嫨娴�
		InputStream  is =null;
		ByteArrayOutputStream baos =null;
		try {
			is =new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			//3銆佹搷浣� (鍒嗘璇诲彇)
			byte[] flush = new byte[1024*10]; //缂撳啿瀹瑰櫒
			int len = -1; //鎺ユ敹闀垮害
			while((len=is.read(flush))!=-1) {
				baos.write(flush,0,len);		 //鍐欏嚭鍒板瓧鑺傛暟缁勪腑			
			}		
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4銆侀噴鏀捐祫婧�
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;		
	}
	/**
	 * 2銆佸瓧鑺傛暟缁勫啓鍑哄埌鍥剧墖
	 * 1)銆佸瓧鑺傛暟缁勫埌绋嬪簭 ByteArrayInputStream
	 * 2)銆佺▼搴忓埌鏂囦欢 FileOutputStream
	 */
	public static void byteArrayToFile(byte[] src,String filePath) {
		//1銆佸垱寤烘簮
		File dest = new File(filePath);
		//2銆侀�夋嫨娴�
		InputStream  is =null;
		OutputStream os =null;
		try {
			is =new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);
			//3銆佹搷浣� (鍒嗘璇诲彇)
			byte[] flush = new byte[5]; //缂撳啿瀹瑰櫒
			int len = -1; //鎺ユ敹闀垮害
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len);			//鍐欏嚭鍒版枃浠�	
			}		
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4銆侀噴鏀捐祫婧�
			try {
				if (null != os) {
					os.close();
				} 
			} catch (Exception e) {
			}
		}
	}
}
