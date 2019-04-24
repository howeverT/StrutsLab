package action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
public class QueryxAction extends ActionSupport{
	private String name;
	private String date;
	Map m;
	public QueryxAction(){
		m=ActionContext.getContext().getSession();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String execute(){
		if(name.equals("")&&date.equals(""));
		return SUCCESS;
	}
}
