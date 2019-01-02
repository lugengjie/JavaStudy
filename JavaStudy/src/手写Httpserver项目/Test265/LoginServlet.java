package 手写Httpserver项目.Test265;

import 手写Httpserver项目.Test261.Response;

public class LoginServlet implements Servlet {

	@Override
	public void service(Request request,Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<meta charset=\"UTF-8\">");
		response.print("<title>");
		response.print("第一个servlet");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("shsxt server终于回来了。。。。"+request.getParameterValue("uname"));
		response.print("</body>");
		response.print("</html>");

	}

}
