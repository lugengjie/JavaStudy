package 手写Httpserver项目.Test266;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 处理器
 * @author JIANG
 *
 */
public class WebHandler extends DefaultHandler{
	private List<Entity> entitys;
	private List<Mapping> mappings;
	private Entity entity;
	private Mapping mapping;
	//存储操作标签
	private String tag;
	private boolean isMapping=false;
	@Override
	public void startDocument() throws SAXException {
		this.entitys=new ArrayList<Entity>();
		this.mappings=new ArrayList<Mapping>();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"-->解析开始");		
		if(qName!=null) {
			tag=qName;
			if(tag!=null) {
				if(tag.equals("servlet-mapping")) {
					mapping=new Mapping();
					isMapping=true;
				}else if(tag.equals("servlet")){
					entity=new Entity();
					isMapping=false;
				}
			}
		}	
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents=new String(ch,start,length).trim();
		System.out.println(contents);
		if(tag!=null) {
			if(isMapping) {
				if(tag.equals("servlet-name")) {
					mapping.setName(contents);
				}else if(tag.equals("url-pattern")) {
					mapping.addPattern(contents);
				}
			}else{
				if(tag.equals("servlet-name")) {
					entity.setName(contents);
				}else if(tag.equals("servlet-class")) {
					entity.setClz(contents);
				}
			}
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"-->解析结束");
		if(qName!=null) {
			if(qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			}else if(qName.equals("servlet")){
				entitys.add(entity);
			}
		}
		tag=null;
	}
	public List<Mapping> getMappings() {
		return mappings;
	}
	public List<Entity> getEntitys() {
		return entitys;
	}
	
	
}

