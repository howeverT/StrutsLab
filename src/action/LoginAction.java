package action;

import java.util.Map;

import com.dao.PlaneDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	String name;
	String pwd;
	public LoginAction(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String execute(){
		if(PlaneDao.userLogin(name, pwd)){
			//����¼�û�������session��
			Map m;
			//���Action��session����
			m=ActionContext.getContext().getSession();
			//����¼�û�������session��
			m.put("loginName", name);
			return SUCCESS;
		}else{
			addFieldError("name","�û������������");
			return INPUT;
		}
	}
	
	
}
