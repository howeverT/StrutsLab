package action;
import java.util.List;
import java.util.Map;
import com.dao.PlaneDao;
import com.entity.Plane;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class ShowAction extends ActionSupport{
	private List<Plane> planes;
	PlaneDao pd;
	Map m;
	private int id; //界面显示数据的索引
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
	private String qname="";//查询的名字
	private String qdate="";//查询的日期
	public ShowAction(){
		
	}
	public PlaneDao getPd() {
		return pd;
	}
	public void setPd(PlaneDao pd) {
		this.pd = pd;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getQdate() {
		return qdate;
	}
	public void setQdate(String qdate) {
		this.qdate = qdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public List<Plane> getPlanes() {
		return planes;
	}
	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}
	public String execute(){
		m=ActionContext.getContext().getSession();
		//获得所有数据，得到数据的总个数
		planes=pd.queryTicket(m.get("Uname").toString(),qname,qdate);
		//计算总页数
		if(planes.size()%pageSize==0){
			totalPage=planes.size()/pageSize;
		}else{
			totalPage=planes.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		planes=pd.queryByPage(pageNo,pageSize,m.get("Uname").toString(),qname,qdate);
		//设置当前页
		currentPage=pageNo;
		
		//planes=pd.queryTicket(m.get("Uname").toString());
		m.put("aaa", "111");
		m.put("planes", planes);
		return SUCCESS;
	}
}
