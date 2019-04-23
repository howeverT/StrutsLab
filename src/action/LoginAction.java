package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.dao.PlaneDao;
import com.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private Users user;
	PlaneDao pd=new PlaneDao();
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String execute(){
		if(pd.userLogin(user)){
			//将登录用户名保存session里
			Map m;
			//获得Action的session对象
			m=ActionContext.getContext().getSession();
			//将登录用户名保存session里
			m.put("loginName", user);
			return SUCCESS;
		}else{
			addFieldError("user.name","用户名或密码错误");
			return INPUT;
		}
	}
	
	
}
