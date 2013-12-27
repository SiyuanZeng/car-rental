package carrental.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);

	//before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
	    throws Exception {
		System.out.println("ExecuteTimeInterceptor preHandle");
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);

		return true;
	}

	//after the handler is executed
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("ExecuteTimeInterceptor postHandle");
		long startTime = (Long)request.getAttribute("startTime");

		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;

		//modified the exisitng modelAndView
		modelAndView.addObject("executeTime",executeTime);

		//log it
		if(logger.isDebugEnabled()){
			logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
		}
	}
}