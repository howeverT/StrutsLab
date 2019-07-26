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
	PlaneDao pd;
	Map m;
	public BookAction(){
		
	}
	public PlaneDao getPd() {
		return pd;
	}
	public void setPd(PlaneDao pd) {
		this.pd = pd;
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
		//��ȡ�û��Ķ�Ʊ��Ϣ
		m=ActionContext.getContext().getSession();
		//System.out.println(m.get("Uname"));
		pd.insertData(plane);
		//m.put("Uname", plane.getUtage());
		//planes=pd.queryTicket(m.get("Uname").toString());
		//m.put("planes", planes);
		return "bookList";
	}
    
}
