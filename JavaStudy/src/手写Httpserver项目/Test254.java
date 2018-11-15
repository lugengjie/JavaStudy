package 手写Httpserver项目;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Test254 {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//SAX解析
		//1、获取解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器
		SAXParser parse =factory.newSAXParser();
		//3、编写处理器
		//4、加载文档 Document 注册处理器
		PersonHandler handler=new PersonHandler();
		//5、解析
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("手写Httpserver项目/person.xml")
		,handler);
		
		List<Person> persons=handler.getPersons();
		for(Person person:persons) {
			System.out.println(person);
		}
	}
}
class PersonHandler extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	//存储操作标签
	private String tag;
	@Override
	public void startDocument() throws SAXException {
		persons=new ArrayList<Person>();
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents=new String(ch,start,length).trim();
		if(tag!=null) {
			if(tag.equals("name")) {
				if(contents.length()>0) {
					person.setName(contents);
				}
			}else if(tag.equals("age")){
				if(contents.length()>0) {
					person.setAge(Integer.valueOf(contents));
				}
			}
		}
		System.out.println(contents);
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"-->解析开始");		
		if(qName!=null) {
			tag=qName;
			if(qName.equals("persons")) {
				person=new Person();
			}
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"-->解析结束");
		if(qName.equals("person")) {
			persons.add(person);
		}
		tag=null;
	}
	@Override
	public void endDocument() throws SAXException {
		
	}
	public List<Person> getPersons() {
		return persons;
	}

}
