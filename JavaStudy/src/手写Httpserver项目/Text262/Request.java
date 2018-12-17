package ��дHttpserver��Ŀ.Text262;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * ��װ����Э�飺��ȡmethod url�Լ��������
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
	
	public Request(InputStream is) {
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
	}
} 
