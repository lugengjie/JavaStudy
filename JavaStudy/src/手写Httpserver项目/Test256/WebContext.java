package 手写Httpserver项目.Test256;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import 手写Httpserver项目.Test255.Entity;
import 手写Httpserver项目.Test255.Mapping;

public class WebContext {
	private List<Entity> entitys=null;
	private List<Mapping> mappings=null;
	
	private Map<String,String> entityMap=new HashMap<String,String>();
	private Map<String,String> mappingMap=new HashMap<String,String>();
	
	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		this.entitys = entitys;
		this.mappings = mappings;
		//将entity的List转为对应的map
		for(Entity entity:entitys) {
			entityMap.put(entity.getName(),entity.getClz());
		}
		//将mapping的List转为对应的map
		for(Mapping mapping:mappings) {
			for(String pattern:mapping.getPatterns())
				mappingMap.put(pattern,mapping.getName());
		}
	}
	
	public Map<String, String> getEntityMap() {
		return entityMap;
	}

	public void setEntityMap(Map<String, String> entityMap) {
		this.entityMap = entityMap;
	}

	public Map<String, String> getMappingMap() {
		return mappingMap;
	}

	public void setMappingMap(Map<String, String> mappingMap) {
		this.mappingMap = mappingMap;
	}

	/**
	 * 通过url路径找到对应的class
	 * @param pattern
	 * @return 
	 */
	public String getClz(String pattern) {
		String name=mappingMap.get(pattern);
		return entityMap.get(name);
	}
	
	
	
}
