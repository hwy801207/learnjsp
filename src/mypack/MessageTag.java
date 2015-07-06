package mypack;

import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MessageTag extends TagSupport{

	private String key = null;
	
	public String getKey(){
		return key;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	public int doEndTag() throws JspException{
		try {
			
			Properties ps = (Properties) pageContext.getAttribute("ps", pageContext.APPLICATION_SCOPE);
			Properties ps_ch = (Properties) pageContext.getAttribute("ps_ch", pageContext.APPLICATION_SCOPE);
			HttpSession session = pageContext.getSession();
			String language = (String) session.getAttribute("language");
			
			String message = null;
			if (language != null && language.equals("Chinese")){
				message = (String)ps_ch.get(key);
			}else {
				message = (String)ps.get(key);
			}
		pageContext.getOut().print(message);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
