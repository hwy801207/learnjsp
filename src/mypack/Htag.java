package mypack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Htag implements IterationTag{
	
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
		this.i = 1;
		return TagSupport.EVAL_BODY_INCLUDE;
//		return TagSupport.SKIP_BODY;
//		return BodyTag.EVAL_BODY_BUFFERED;
		
	}
	
	public int doEndTag() throws JspException {
		return TagSupport.EVAL_PAGE;
//		return TagSupport.SKIP_PAGE;
	}
	

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		// 执行100遍
		while(i < 100) {
			i ++;
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}

}
