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
		planes=PlaneDao.queryTicket(m.get("Uname").toString());
		m.put("planes", planes);
		return SUCCESS;
	}
	public String BookTicket(){
		if(!check())
			return INPUT;
		else{
			PlaneDao.insertData(plane.getUname(), plane.getSex(), plane.getScity(), plane.getDcity(),plane.getDate(),plane.getIdent());
			m.put("Uname", plane.getUname());
		}
		return "bookList";
	}
    public boolean isDate(String date)  
    {  
        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";  
        Pattern pat = Pattern.compile(rexp);     
        Matcher mat = pat.matcher(date);    
        boolean dateType = mat.matches();
        return dateType;  
    }  
	public boolean check(){
		boolean s1=true,s2=true,s3=true,s4=true,s5=true,s6=true,e1=true,e2=true;
		if(plane.getUname()==null||plane.getUname().equals("")){
			addFieldError("plane.uname","信息不能为空");
			s1=false;
		}
		if(plane.getSex()==null){
			addFieldError("plane.sex","信息不能为空");
			s2=false;
		}
		if(plane.getScity()==null||plane.getScity().equals("")){
			addFieldError("plane.scity","信息不能为空");
			s3=false;
		}
		if(plane.getDcity()==null||plane.getDcity().equals("")){
			addFieldError("plane.dcity","信息不能为空");
			s4=false;
		}
		if(plane.getDate()==null||plane.getDate().equals("")){
			addFieldError("plane.date","信息不能为空");
			s5=false;
		}
		if(!isDate(plane.getDate())){
			addFieldError("plane.date","输入正确日期");
			e1=false;
		}
		if(plane.getIdent()==null||plane.getIdent().equals("")){
			addFieldError("plane.ident","信息不能为空");
			s6=false;
		}
		if(plane.getIdent().length()!=18){
			addFieldError("plane.ident","身份证要18位");
			e2=false;
		}
		
		return s1&&s2&&s3&&s4&&s5&&s6&&e1&&e2;
	}
}
