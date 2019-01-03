package 手写Httpserver项目.Test266;

import 手写Httpserver项目.Test261.Response;

public class OthersServlet implements Servlet {

	@Override
	public void service(Request request,Response response) {
		response.print("其他测试页面");
	}

}
