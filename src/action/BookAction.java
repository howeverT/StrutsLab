package action;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.dao.PlaneDao;
import com.entity.Plane;
public class BookAction extends ActionSupport{
	private Plane plane;
	private List<Plane> planes;
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
		PlaneDao.insertData(plane.getUname(), plane.getSex(), plane.getScity(), plane.getDcity(),plane.getDate(),plane.getIdent());
		m.put("Uname", plane.getUname());
		planes=PlaneDao.queryTicket(m.get("Uname").toString());
		m.put("planes", planes);
		return SUCCESS;
	}
	
    
}
