package 数据结构与容器.Other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Collections辅助类的使用
 * Collection是接口，Collections是工具类
 * @author jie
 *
 */
public class Test163 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<9;i++) {
			list.add("test"+i);
		}
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
//		System.out.println(Collections.binarySearch(list,"test10"));
		Collections.fill(list,"hh");
		System.out.println(list);
	}
}
