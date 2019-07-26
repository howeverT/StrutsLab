package action;
import com.entity.Plane;
import com.dao.*;
import com.opensymphony.xwork2.ActionSupport;
public class QueryAction extends ActionSupport{
	int id;
	Plane plane;
	PlaneDao pd;
	public QueryAction(){
		
	}
	public PlaneDao getPd() {
		return pd;
	}
	public void setPd(PlaneDao pd) {
		this.pd = pd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public String execute(){
		plane=pd.queryTicketById(id);
		if(plane!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
