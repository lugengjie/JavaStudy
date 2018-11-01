package 数据结构与容器.Other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 表格数据存储 map List
 * @author jie
 *
 */
public class Test164 {
	public static void main(String[] args) {
		Map<String,Object> row1=new HashMap<String,Object>();
		row1.put("id",1000);
		row1.put("salary",20000);
		row1.put("name","张三");
		
		Map<String,Object> row2=new HashMap<String,Object>();
		row2.put("id",2000);
		row2.put("salary",60000);
		row2.put("name","李四");
		
		Map<String,Object> row3=new HashMap<String,Object>();
		row3.put("id",3000);
		row3.put("salary",20000);
		row3.put("name","王五");
		
		List<Map<String,Object>> table=new ArrayList<>();
		table.add(row1);
		table.add(row2);
		table.add(row3);
		
		for(Map<String, Object> row:table) {
			for(String column:row.keySet()) {
				System.out.print(column+":"+row.get(column)+"\t \t");
			}
			System.out.println();
		}
		
		
	}
}
