package mypack;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class GreetTag extends BodyTagSupport{
	private int count;
	private String username;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		System.out.println("call setCount() " + count);
		this.count = count;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public int doStartTag() throws JspException {
		System.out.println("call doStartTag()");
		
		if (count > 0){
			return EVAL_BODY_BUFFERED;
		} 
		else {
			return SKIP_BODY;
		}
	}
	
	public void setBodyContent(BodyContent bc){
		System.out.println("call setBodyContent()");
		super.setBodyContent(bc);
	}
	
	public void doInitBody()throws JspException{
		System.out.println("call doInitBody()");
		username = pageContext.getRequest().getParameter("username");
		System.out.println("username is: " + username);
	}
	
	public int doAfterBody() throws JspException{
		System.out.println("call doAfterBody()");
		if (count > 1){
			count--;
			return EVAL_BODY_AGAIN;
		}
		else {
			return SKIP_BODY;
		}
	}
	
	public  int doEndTag() {
		System.out.println("call doEndTag()");
//		JspWriter out = pageContext.getOut();
//		Tag ptag = getParent();
		JspWriter out = bodyContent.getEnclosingWriter();
		try{
			String content = bodyContent.getString();
			System.out.println(content);
			
			if (username != null && username.equals("Monster")) {
				content = "Go away , Monster";
			}
			
			out.println(content);
		}catch(IOException e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
