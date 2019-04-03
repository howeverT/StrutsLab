package action;
import java.util.Map;

import com.dao.PlaneDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class regAction extends ActionSupport{
	String lname;
	String lpwd;
	String vpwd;
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLpwd() {
		return lpwd;
	}
	public void setLpwd(String lpwd) {
		this.lpwd = lpwd;
	}
	public String getVpwd() {
		return vpwd;
	}
	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}
	public String execute(){
		if(PlaneDao.uregCheck(lname)){
			//�����ݿ������ظ�������ע��
			return INPUT;
		}else{
			PlaneDao.userRegister(lname, lpwd);
			return SUCCESS;
		}
	}
	public void validate(){
		if(lname==null || lname.equals("") ){
			addFieldError("lname","�û�������Ϊ��");
		}
		if(lpwd==null || lpwd.equals("") || vpwd.equals("")){
			addFieldError("lpwd","���벻��Ϊ��");
		}
		else if(!lpwd.equals(vpwd)){
			addFieldError("vpwd","�����������벻һ��");
		}
	}
}
