package 缃戠粶缂栫▼;


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
 *1閵嗭拷 閸ュ墽澧栫拠璇插絿閸掓澘鐡ч懞鍌涙殶缂侊拷
 *2閵嗭拷 鐎涙濡弫鎵矋閸愭瑥鍤崚鐗堟瀮娴狅拷
 *  @author 鐟佸瓨鏌�
 *
 */
public class IOUtils {
	/**
	 * 1閵嗕礁娴橀悧鍥嚢閸欐牕鍩岀�涙濡弫鎵矋
	 * 1)閵嗕礁娴橀悧鍥у煂缁嬪绨�  FileInputStream
	 * 2)閵嗕胶鈻兼惔蹇撳煂鐎涙濡弫鎵矋	ByteArrayOutputStream
	 */
	public static byte[] fileToByteArray(String filePath) {
		//1閵嗕礁鍨卞鐑樼爱娑撳海娲伴惃鍕勾
		File src = new File(filePath);
		byte[] dest =null;
		//2閵嗕線锟藉瀚ㄥù锟�
		InputStream  is =null;
		ByteArrayOutputStream baos =null;
		try {
			is =new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			//3閵嗕焦鎼锋担锟� (閸掑棙顔岀拠璇插絿)
			byte[] flush = new byte[1024*10]; //缂傛挸鍟跨�圭懓娅�
			int len = -1; //閹恒儲鏁归梹鍨
			while((len=is.read(flush))!=-1) {
				baos.write(flush,0,len);		 //閸愭瑥鍤崚鏉跨摟閼哄倹鏆熺紒鍕厬			
			}		
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4閵嗕線鍣撮弨鎹愮カ濠э拷
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
	 * 2閵嗕礁鐡ч懞鍌涙殶缂佸嫬鍟撻崙鍝勫煂閸ュ墽澧�
	 * 1)閵嗕礁鐡ч懞鍌涙殶缂佸嫬鍩岀粙瀣碍 ByteArrayInputStream
	 * 2)閵嗕胶鈻兼惔蹇撳煂閺傚洣娆� FileOutputStream
	 */
	public static void byteArrayToFile(byte[] src,String filePath) {
		//1閵嗕礁鍨卞鐑樼爱
		File dest = new File(filePath);
		//2閵嗕線锟藉瀚ㄥù锟�
		InputStream  is =null;
		OutputStream os =null;
		try {
			is =new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);
			//3閵嗕焦鎼锋担锟� (閸掑棙顔岀拠璇插絿)
			byte[] flush = new byte[5]; //缂傛挸鍟跨�圭懓娅�
			int len = -1; //閹恒儲鏁归梹鍨
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len);			//閸愭瑥鍤崚鐗堟瀮娴狅拷	
			}		
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4閵嗕線鍣撮弨鎹愮カ濠э拷
			try {
				if (null != os) {
					os.close();
				} 
			} catch (Exception e) {
			}
		}
	}
}
