package mypack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.TagSupport;

public class Htag extends TagSupport{
	
	/**
	 * 
	 */
	private int i = 0;
	
	@Override
	public int doStartTag() throws JspException {
//		return TagSupport.EVAL_BODY_INCLUDE;
//		return TagSupport.SKIP_BODY;
		return BodyTag.EVAL_BODY_BUFFERED;
		
	}
	
	public int doEndTag() throws JspException {
		return TagSupport.EVAL_PAGE;
//		return TagSupport.SKIP_PAGE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if (i < 100) {
			i ++;
			return TagSupport.EVAL_BODY_AGAIN;
		}
		else {
		return TagSupport.SKIP_BODY;
		}
		
	}

}
