package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.dao.PlaneDao;
import com.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private Users user;
	PlaneDao pd;
	public LoginAction(){
		
	}
	public PlaneDao getPd() {
		return pd;
	}
	public void setPd(PlaneDao pd) {
		this.pd = pd;
	}
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String execute(){
		if(pd.userLogin(user)){
			//����¼�û�������session��
			Map m;
			//���Action��session����
			m=ActionContext.getContext().getSession();
			//����¼�û�������session��
			m.put("loginName", user);
			m.put("Uname", user.getName());
			return SUCCESS;
		}else{
			addFieldError("user.name","�û������������");
			return INPUT;
		}
	}
	
	
}
