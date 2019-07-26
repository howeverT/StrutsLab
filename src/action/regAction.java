package action;
import java.util.Map;
import com.entity.Users;
import com.dao.PlaneDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class regAction extends ActionSupport{
	Users ruser;
	PlaneDao pd;
	String vpwd;
	public regAction(){
		
	}
	public PlaneDao getPd() {
		return pd;
	}
	public void setPd(PlaneDao pd) {
		this.pd = pd;
	}
	public Users getRuser() {
		return ruser;
	}
	public void setRuser(Users ruser) {
		this.ruser = ruser;
	}
	public String getVpwd() {
		return vpwd;
	}
	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}
	public String execute(){
		if(PlaneDao.uregCheck(ruser.getName())){
			//跟数据库数据重复就重新注册
			return INPUT;
		}else{
			pd.userRegister(ruser);
			return SUCCESS;
		}
	}
	public void validate(){
		if(!ruser.getPwd().equals(vpwd)){
			addFieldError("vpwd","两次输入密码不一样");
		}
	}
}
