package interceptor;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class LoginInterceptor extends AbstractInterceptor{
	public String intercept (ActionInvocation ai) throws Exception{
		//获得Session对象
		Map session=ai.getInvocationContext().getSession();
		//从Session中获得保存的当前登录用户名
		String userName=(String)session.get("loginName");
		if(userName!=null){//已经登录
			return ai.invoke();//可以进入购票
		}else{ //还未登录
			//获得Action的上下文环境
			ActionContext ac=ai.getInvocationContext();
			//定义要输出错误信息
			ac.put("errorMessage","请先登陆再进行后续操作!");
			return "input"; //返回字符串
		}
	}
}
