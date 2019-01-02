package 手写Httpserver项目.Test256;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import 手写Httpserver项目.Test255.Entity;
import 手写Httpserver项目.Test255.Mapping;

public class XmlParse {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//SAX瑙ｆ瀽
		//1銆佽幏鍙栬В鏋愬伐鍘�
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2銆佷粠瑙ｆ瀽宸ュ巶鑾峰彇瑙ｆ瀽鍣�
		SAXParser parse =factory.newSAXParser();
		//3銆佺紪鍐欏鐞嗗櫒
		//4銆佸姞杞芥枃妗Ｂ燚ocument聽娉ㄥ唽澶勭悊鍣�
		WebHandler handler=new WebHandler();
		//5銆佽В鏋�
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("鎵嬪啓Httpserver椤圭洰/Test255/web.xml")
		,handler);
		
		//鑾峰彇鏁版嵁
		WebContext context=new WebContext(handler.getEntitys(), handler.getMappings());
		
		//鍋囪浣犺緭鍏ヤ簡/login
		String className=context.getClz("/reg");
		Class clz=Class.forName(className);
		Servlet servlet=(Servlet)clz.getConstructor().newInstance();
		System.out.println(servlet);
	}
}
class WebHandler extends DefaultHandler{
	private List<Entity> entitys;
	private List<Mapping> mappings;
	private Entity entity;
	private Mapping mapping;
	//瀛樺偍鎿嶄綔鏍囩
	private String tag;
	private boolean isMapping=false;
	@Override
	public void startDocument() throws SAXException {
		this.entitys=new ArrayList<Entity>();
		this.mappings=new ArrayList<Mapping>();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"-->瑙ｆ瀽寮�濮�");		
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
		System.out.println(qName+"-->瑙ｆ瀽缁撴潫");
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
