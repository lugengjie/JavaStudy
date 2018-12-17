package ��дHttpserver��Ŀ.Test256;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ��дHttpserver��Ŀ.Test255.Entity;
import ��дHttpserver��Ŀ.Test255.Mapping;

public class WebContext {
	private List<Entity> entitys=null;
	private List<Mapping> mappings=null;
	
	private Map<String,String> entityMap=new HashMap<String,String>();
	private Map<String,String> mappingMap=new HashMap<String,String>();
	
	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		this.entitys = entitys;
		this.mappings = mappings;
		//��entity��ListתΪ��Ӧ��map
		for(Entity entity:entitys) {
			entityMap.put(entity.getName(),entity.getClz());
		}
		//��mapping��ListתΪ��Ӧ��map
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
	 * ͨ��url·���ҵ���Ӧ��class
	 * @param pattern
	 * @return 
	 */
	public String getClz(String pattern) {
		String name=mappingMap.get(pattern);
		return entityMap.get(name);
	}
	
	
	
}
