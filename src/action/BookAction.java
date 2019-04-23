package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.dao.PlaneDao;
import com.entity.Plane;
public class BookAction extends ActionSupport{
	private Plane plane;
	private List<Plane> planes;
	PlaneDao pd=new PlaneDao();
	Map m;
	public BookAction(){
		m=ActionContext.getContext().getSession();
	}
	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public List<Plane> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}

	public String execute()throws Exception{
		//获取用户的订票信息
		//System.out.println(m.get("Uname"));
		pd.insertData(plane);
		m.put("Uname", plane.getUname());
		//planes=pd.queryTicket(m.get("Uname").toString());
		//m.put("planes", planes);
		return "bookList";
	}
    
}
