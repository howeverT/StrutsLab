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
	private int id; //������ʾ���ݵ�����
	private final int pageSize=5; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
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
		//����������ݣ��õ����ݵ��ܸ���
		planes=pd.queryTicket(m.get("Uname").toString());
		//������ҳ��
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
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		planes=pd.queryByPage(pageNo,pageSize,m.get("Uname").toString());
		//���õ�ǰҳ
		currentPage=pageNo;
		//111111111
		//planes=pd.queryTicket(m.get("Uname").toString());
		m.put("planes", planes);
		return SUCCESS;
	}
}
