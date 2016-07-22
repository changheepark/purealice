package mamm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SunServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handlerRequest(req,resp);
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handlerRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handlerRequest(req,resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handlerRequest(req,resp);
	}
	
	
	
	private void handlerRequest(HttpServletRequest req, HttpServletResponse resp) {
				try {
					Handler hadler = handlerMapping(req, resp);
					String viewName = handlerAdaper(hadler ,req , resp);
					dispatch(viewName , req , resp );
				} catch (Exception e) {
					throw new RuntimeException(e);
			}
	}


	private void dispatch(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String resultViewName = "WEB-INF/views"+viewName +".jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(resultViewName);
		dispatcher.forward(req, resp);
		
	}


	private String handlerAdaper(Handler hadler ,HttpServletRequest req, HttpServletResponse resp) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method handlerMethod = hadler.getClass().getMethod("handle",HttpServletRequest.class , HttpServletResponse.class);			
		return (String) handlerMethod.invoke(hadler, req ,resp);
	}


	private Handler handlerMapping(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			String uri = req.getRequestURI();
			String handdlerName = "mamm/"+uri.substring(uri.indexOf('/')+1)+"Handler";
			Class<?> handlerClass = Class.forName(handdlerName);
			return (Handler) handlerClass.newInstance();
	}
	
}
