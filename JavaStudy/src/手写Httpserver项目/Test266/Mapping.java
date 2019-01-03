package 手写Httpserver项目.Test266;

import java.util.HashSet;
import java.util.Set;
//<servlet-mapping>
//<servlet-name>login</servlet-name>
//<url-pattern>/login</url-pattern> 
//<url-pattern>/g</url-pattern> 
//</servlet-mapping>  
public class Mapping {
	String name;
	Set<String> patterns;
	
	public Mapping() {
		this.patterns=new HashSet<String>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getPatterns() {
		return patterns;
	}
	public void setPatterns(Set<String> patterns) {
		this.patterns = patterns;
	}
	public void addPattern(String pattern) {
		this.patterns.add(pattern);
	}
	@Override
	public String toString() {
		return "Mapping [name=" + name + ", patterns=" + patterns + "]";
	}
	
}
