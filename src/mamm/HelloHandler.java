package mamm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHandler implements Handler{

	@Override
	public String Handle(HttpServletRequest req, HttpServletResponse resp) {

		String name = req.getParameter("name");
		req.setAttribute("name", "��°�̸���?"+name);
		req.setAttribute("message", "��°������׿� ��ī��ī");
		
		return "Hello";
		
		
		
	}
	
}
