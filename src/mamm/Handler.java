package mamm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	
	String Handle(HttpServletRequest req, HttpServletResponse resp);

}
