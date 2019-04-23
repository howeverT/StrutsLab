package action;
import com.opensymphony.xwork2.ActionSupport;
import com.dao.*;
import com.entity.Plane;
public class UpdatePlaneAction extends ActionSupport{
	private Plane plane;
	PlaneDao pd=new PlaneDao();
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public String execute(){
		if(pd.updatePlane(plane))
			return "showTicket";
		else
			return INPUT;
	}
}
