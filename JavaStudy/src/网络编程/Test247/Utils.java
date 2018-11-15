package ������.Test247;

import java.io.Closeable;
import java.io.IOException;
/**
 * ������
 * @author jie
 *
 */
public class Utils {
	/**
	 * �ͷ���Դ
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
