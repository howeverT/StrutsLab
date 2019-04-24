package action;

import java.util.List;
import java.util.Map;

import com.dao.PlaneDao;
import com.entity.Plane;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport{
	private int id;
	private List<Plane> planes;
	PlaneDao pd=new PlaneDao();
	Map m;
	public DeleteAction(){
		m=ActionContext.getContext().getSession();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Plane> getPlanes() {
		return planes;
	}
	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}
	public String execute(){
		if(pd.deletePlaneById(id)){
			//planes=pd.queryTicket(m.get("Uname").toString());
			//m.put("planes", planes);
			return "showTicket";
		}
		else
			return INPUT;
	}
}