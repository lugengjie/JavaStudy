package 手写Httpserver项目.Test263;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装请求协议：封装请求参数为Map
 * @author jie
 *
 */
public class Request {
	//协议信息
	private String requestInfo;
	//请求方式
	private String method;
	//请求url
	private String url;
	//请求参数
	private String queryStr;
	private final String CRLF="\r\n";
	//存储参数
	private Map<String,List<String>> parameterMap;
	public Request(InputStream is) {
		parameterMap=new HashMap<String,List<String>>();
		byte[] datas=new byte[1024*1024];
		int len=0;
		try {
			len = is.read(datas);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.requestInfo=new String(datas,0,len);
		System.out.println(requestInfo);
		parseRequestInfo();
	}
	public Request(Socket client) throws IOException {
		this(client.getInputStream());
	}
	private void parseRequestInfo() {
		System.out.println("------分解------");
		System.out.println("1.获取请求方式：开头第一个/------");
		this.method=this.requestInfo.substring(0,requestInfo.indexOf("/")).toLowerCase();
		this.method=this.method.trim();
		System.out.println("---2、获取请求url:第一个/到HTTP/---");
		System.out.println("---可能包含请求参数？前面的位url---");
		//1)获取/的位置
		int startInx=this.requestInfo.indexOf("/")+1;
		//2)获取HTTP的位置
		int endInx=this.requestInfo.indexOf("HTTP/");
		//3)分割字符串
		this.url=this.requestInfo.substring(startInx, endInx);
		//4)获取?的位置
		int queryIdx=this.url.indexOf("?");
		if(queryIdx>=0) {//表示存在参数
			String[] urlArray=this.url.split("\\?");
			this.url=urlArray[0];
			this.queryStr=urlArray[1].trim();
		}
		System.out.println("3、获取请求参数：如果GET已经获取，如果是POST可能在请求体中");
		
		if(method.equals("post")) {
			String qStr=this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if(null==queryStr) {
				queryStr=qStr;
			}else{
				queryStr+="&"+qStr;
			}
		}
		queryStr=null==queryStr?"":queryStr;
		System.out.println(method+"-->"+url+"-->"+queryStr);
		//转成Map
	}
	//处理请求参数为Map
	private void convertMap() {
		//1.分割字符串&
		String[] keyValues=this.queryStr.split("&");
		for(String queryStr:keyValues) {
			//2.再次分割字符串=
			String[] kv=queryStr.split("=");
			kv=Arrays.copyOf(kv,2);
			//获取key和value
			String key=kv[0];
			String value=kv[1];
			//存储到map中
			if(!parameterMap.containsKey(key)) {//第一次
				parameterMap.put(key,new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
		}
	}
	getParameterValues
	
} 
