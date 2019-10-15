package netease.spring.boot.study.web;

import netease.spring.boot.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyb
 * @date 2019-10-15 11:18:03
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findUser")
    @ResponseBody
    public Object findUser(Integer userId) throws Exception{
        //调用service
        return userService.find(userId);
    }
}
