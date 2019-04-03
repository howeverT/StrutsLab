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
			//将登录用户名保存session里
			Map m;
			//获得Action的session对象
			m=ActionContext.getContext().getSession();
			//将登录用户名保存session里
			m.put("loginName", name);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	//验证
	public void validate(){
		if(name==null || name.equals("") ){
			addFieldError("name","用户名不能为空");
		}
		if(pwd==null || pwd.equals("") ){
			addFieldError("pwd","密码不能为空");
		}
	}
	
}
