package 手写Httpserver项目.Test265;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
	private BufferedWriter bw;
	//正文
	private StringBuilder content;
	//协议头信息（状态行与请求头 回车）
	private StringBuilder headInfo;
	private final String BLANK="";
	private final String CRLF="\r\n";
	private int len;
	public Response() {
		content=new StringBuilder();
		headInfo=new StringBuilder();
	}
	public Response(Socket client) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Response(OutputStream os) {
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	//动态添加内容
	public  Response print(String info) {
		content.append(info);
		len+=info.getBytes().length;
		return this;
 
	}
	public  Response println(String info) {
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;

	}
	//推送响应信息
	public void pushToBrowser(int code) throws IOException {
		if(headInfo==null) {
			code=505;
		}
		createHeadInfo(code);
		bw.append(headInfo);
		bw.append(content);
		bw.flush();
		
	}
	//构建头信息
	private void createHeadInfo(int code) {
		//响应状态行
		headInfo.append("HTTP/1.1").append(BLANK);
		headInfo.append(code).append(BLANK);
		switch(code) {
		   case 200:
			   headInfo.append("OK").append(CRLF);
			   break;
		   case 404:
			   headInfo.append("NOT Found").append(CRLF);
			   break;
		   case 505:
			   headInfo.append("SERVER Error").append(CRLF);
			   break;
		}
		//响应行最后一行有空格
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Server:").append("shsxt Server/0.0.1;charset=UTF-8").append(CRLF);
		headInfo.append("Content-type:text/html").append(CRLF);
		headInfo.append("Content-length:").append(len).append(CRLF);
		headInfo.append(CRLF);

	}
}
