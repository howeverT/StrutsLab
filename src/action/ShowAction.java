package action;
import java.util.List;
import java.util.Map;
import com.dao.PlaneDao;
import com.entity.Plane;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class ShowAction extends ActionSupport{
	private List<Plane> planes;
	PlaneDao pd=new PlaneDao();
	Map m;
	private int id; //界面显示数据的索引
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
	public ShowAction(){
		m=ActionContext.getContext().getSession();
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
		//获得所有数据，得到数据的总个数
		planes=pd.queryTicket(m.get("Uname").toString());
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
		planes=pd.queryByPage(pageNo,pageSize,m.get("Uname").toString());
		//设置当前页
		currentPage=pageNo;
		//111111111
		//planes=pd.queryTicket(m.get("Uname").toString());
		m.put("planes", planes);
		return SUCCESS;
	}
}
