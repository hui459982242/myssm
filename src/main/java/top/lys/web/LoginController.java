package top.lys.web;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;

@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // http://localhost:8080/ssmmaven/login/showLoginView
    @RequestMapping("/showLoginView")
    public ModelAndView getIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    /**
     * 登录逻辑
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String account,String password) {
        logger.debug(account+":::"+password);
        return "{\"status\":0}";
    }

}
