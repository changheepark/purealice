package mamm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHandler implements Handler{

	@Override
	public String Handle(HttpServletRequest req, HttpServletResponse resp) {

		String name = req.getParameter("name");
		req.setAttribute("name", "둘째이름은?"+name);
		req.setAttribute("message", "둘째가생겼네요 추카추카");
		
		return "Hello";
		
		
		
	}
	
}
