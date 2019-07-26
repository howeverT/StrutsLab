package action;
import java.util.*;

import com.dao.PlaneDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class QuitAction extends ActionSupport{
	Map m;
	PlaneDao pd;
	public QuitAction(){
		
	}
	public PlaneDao getPd() {
		return pd;
	}
	public void setPd(PlaneDao pd) {
		this.pd = pd;
	}
	public String execute()throws Exception{
		m=ActionContext.getContext().getSession();
		m.remove("loginName");
		m.remove("Uname");
		return SUCCESS;
	}
}
