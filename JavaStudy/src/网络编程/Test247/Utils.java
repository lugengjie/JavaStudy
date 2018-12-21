package 网络编程.Test247;

import java.io.Closeable;
import java.io.IOException;
/**
 * 工具类
 * @author jie
 *
 */
public class Utils {
	/**
	 * 释放资源
	 * @param targets
	 */
	public static void close(Closeable... targets) {
		for(Closeable target:targets) {
			try {
				if(target!=null) {
					target.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
