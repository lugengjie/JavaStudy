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
		//SAX解析
		//1、获取解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器
		SAXParser parse =factory.newSAXParser();
		//3、编写处理器
		//4、加载文档 Document 注册处理器
		WebHandler handler=new WebHandler();
		//5、解析
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("手写Httpserver项目/Test255/web.xml")
		,handler);
		
		//获取数据
		WebContext context=new WebContext(handler.getEntitys(), handler.getMappings());
		
		//假设你输入了/login
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
