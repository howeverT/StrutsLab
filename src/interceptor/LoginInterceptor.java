package interceptor;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class LoginInterceptor extends AbstractInterceptor{
	public String intercept (ActionInvocation ai) throws Exception{
		//���Session����
		Map session=ai.getInvocationContext().getSession();
		//��Session�л�ñ���ĵ�ǰ��¼�û���
		String userName=(String)session.get("loginName");
		if(userName!=null){//�Ѿ���¼
			return ai.invoke();//���Խ��빺Ʊ
		}else{ //��δ��¼
			//���Action�������Ļ���
			ActionContext ac=ai.getInvocationContext();
			//����Ҫ���������Ϣ
			ac.put("errorMessage","���ȵ�½�ٽ��к�������!");
			return "input"; //�����ַ���
		}
	}
}
