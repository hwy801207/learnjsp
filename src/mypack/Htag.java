package mypack;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Htag extends BodyTagSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6446530480916594336L;
	/**
	 *  jsp tag 内容重复执行10次
	 */
	int i = 0;  //定义tag实例的内部变量
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int doStartTag() throws JspException {
		System.out.println("call doStartTag()");
		this.i = 0;
//		return TagSupport.EVAL_BODY_INCLUDE;
//		return TagSupport.SKIP_BODY;
		return EVAL_BODY_BUFFERED;
		
	}
	public void setBodyContent(BodyContent bc){
		System.out.println("call setBodyContent()");
		super.setBodyContent(bc);
	}
	
	public void doInitBody()throws JspException{
		System.out.println("call doInitBody()");
	}
	
	public int doEndTag() throws JspException {

		System.out.println("call doEndTag()");
		System.out.println(bodyContent.getString());
		JspWriter ou = pageContext.getOut();
		try {
			ou.write(bodyContent.getString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
//		return TagSupport.SKIP_PAGE;
	}
	


	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int doAfterBody() throws JspException {
		System.out.println("call doAfterBody()");
		// TODO Auto-generated method stub
		// 执行100遍 ， 两个 不同的请求呢？
//		BodyContent bc = getBodyContent();
//		System.out.println(bc.getString());
		while(i < 3) {
			i ++;                              
			return EVAL_BODY_AGAIN;
		}
		
//		BodyContent bc = getBodyContent();
//		System.out.println(bc.getString());
//		
//		JspWriter out = bc.getEnclosingWriter();
//		try {
//			//out.write(bc.getString());
//			out.write("test haha");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return SKIP_BODY;
	} 

}
