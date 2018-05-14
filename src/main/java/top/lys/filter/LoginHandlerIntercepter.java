package top.lys.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:zhaohui
 * @Time: 2018/5/7 11:14
 * @Description:
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /*
    * 在拦截器中中有三个方法 ：
    * preHandler ：在进入Handler方法之前执行了，使用于身份认证，身份授权，登陆校验等，
    *   比如身份认证，用户没有登陆，拦截不再向下执行，返回值为 false ，即可实现拦截；否则，返回true时，拦截不进行执行；
    * postHandler : 进入Handler方法之后，返回ModelAndView之前执行，使用场景从ModelAndView参数出发，
    *   比如，将公用的模型数据在这里传入到视图，也可以统一指定显示的视图等；
    * afterHandler : 在执行Handler完成后执行此方法，使用于统一的异常处理，统一的日志处理等；
    * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
