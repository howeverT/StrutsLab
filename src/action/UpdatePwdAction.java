package action;

import com.entity.Users;

import java.util.Map;

import com.dao.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UpdatePwdAction extends ActionSupport{
	String oldPwd;
	String newPwd;
	String newPwd2;
	Users user;
	PlaneDao pd=new PlaneDao();
	public UpdatePwdAction(){
		
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getNewPwd2() {
		return newPwd2;
	}
	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String execute(){
		//��õ�ǰ��¼�û�
		Map map=ActionContext.getContext().getSession();
		user=(Users)map.get("loginName");
		if(pd.changePassword(user, oldPwd, newPwd)){
			return SUCCESS;
		}else{
			addFieldError("oldPwd","�û������������");
			return INPUT;
		}
	}
}
