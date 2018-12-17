package ��дHttpserver��Ŀ.Test263;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��װ����Э�飺��װ�������ΪMap
 * @author jie
 *
 */
public class Request {
	//Э����Ϣ
	private String requestInfo;
	//����ʽ
	private String method;
	//����url
	private String url;
	//�������
	private String queryStr;
	private final String CRLF="\r\n";
	//�洢����
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
		System.out.println("------�ֽ�------");
		System.out.println("1.��ȡ����ʽ����ͷ��һ��/------");
		this.method=this.requestInfo.substring(0,requestInfo.indexOf("/")).toLowerCase();
		this.method=this.method.trim();
		System.out.println("---2����ȡ����url:��һ��/��HTTP/---");
		System.out.println("---���ܰ������������ǰ���λurl---");
		//1)��ȡ/��λ��
		int startInx=this.requestInfo.indexOf("/")+1;
		//2)��ȡHTTP��λ��
		int endInx=this.requestInfo.indexOf("HTTP/");
		//3)�ָ��ַ���
		this.url=this.requestInfo.substring(startInx, endInx);
		//4)��ȡ?��λ��
		int queryIdx=this.url.indexOf("?");
		if(queryIdx>=0) {//��ʾ���ڲ���
			String[] urlArray=this.url.split("\\?");
			this.url=urlArray[0];
			this.queryStr=urlArray[1].trim();
		}
		System.out.println("3����ȡ������������GET�Ѿ���ȡ�������POST��������������");
		
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
		//ת��Map
	}
	//�����������ΪMap
	private void convertMap() {
		//1.�ָ��ַ���&
		String[] keyValues=this.queryStr.split("&");
		for(String queryStr:keyValues) {
			//2.�ٴηָ��ַ���=
			String[] kv=queryStr.split("=");
			kv=Arrays.copyOf(kv,2);
			//��ȡkey��value
			String key=kv[0];
			String value=kv[1];
			//�洢��map��
			if(!parameterMap.containsKey(key)) {//��һ��
				parameterMap.put(key,new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
		}
	}
	getParameterValues
	
} 
