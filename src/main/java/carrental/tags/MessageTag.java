package carrental.tags;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Banu Prakash
 *
 * �2011 MindTree Limited
 */
public class MessageTag extends TagSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String key = "";

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		/*
		 * get the locale settings of the browser.
		 * This information comes in the form of request header
		 */
		Locale locale = pageContext.getRequest().getLocale();
		/*
		 * get the appropriate property file for that locale, if not found
		 * use the default property file.
		 */
		ResourceBundle res = ResourceBundle.getBundle("carrental.property.app",locale);
		/*
		 * pageContext encapsulates all  the implict objects of JSP.
		 * get out object from pageContext.
		 */
		JspWriter out = pageContext.getOut();
		try {
			/*
			 *  write the key to the response of JSP page.
			 */
			out.print(res.getString(key));
		} catch (IOException e) {
	 		e.printStackTrace();
		}
		/*
		 * give control to doEndTag()
		 */
		return SKIP_BODY;
	}

}
