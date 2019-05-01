package action;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class QuitAction extends ActionSupport{
	Map m;
	public QuitAction(){
		m=ActionContext.getContext().getSession();
	}
	public String execute()throws Exception{
		m.remove("loginName");
		m.remove("Uname");
		return SUCCESS;
	}
}
