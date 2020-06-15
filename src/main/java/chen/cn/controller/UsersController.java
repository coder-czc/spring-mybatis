package chen.cn.controller;

import chen.cn.entity.Users;
import chen.cn.service.UsersService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller

@RequestMapping("/users")

public class UsersController {

    @Resource(name = "usersServiceImpl") //这里引用了在业务实现类中创建的业务

    private UsersService usersService; //业务接口

    public UsersService getUsersService() {

        return usersService;

    }

    public void setUsersService(UsersService usersService) {

        this.usersService = usersService;

    }


    @RequestMapping("/ulist")  //映射地址

    public String ulist() {

        return "userList";

    }

    @RequestMapping(value = "/getUserInfo")

    @ResponseBody

    public Object suser(HttpServletResponse response) throws IOException {

        List<Users> users = usersService.selectAll();
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("rows", users);
        jsonMap.put("total", users.size());
        Object jsonObject = JSONObject.toJSONString(jsonMap);
        System.out.println(jsonObject);
        return jsonObject;
    }

    @PostMapping("/adduser")

    @ResponseBody

    public void adduser(HttpServletResponse response, HttpServletRequest request ,@RequestBody Users users) throws IOException {
        /*System.out.println("au:" + map);
        Users users = new Users();
        users.setName(map.get("name").toString());
        users.setPass(map.get("pass").toString());*/
        //解析json数据
        Users user = new Users();
        user.setName(users.getName());
        user.setPass(users.getPass());
        System.out.println(users);
        this.usersService.insert(users);
    }

    @RequestMapping("/updateuser")

    @ResponseBody

    public void updateuser(HttpServletResponse response, HttpServletRequest request,@RequestBody Users users) throws IOException {
        Users user = new Users();
        user.setId(users.getId());
        user.setName(users.getName());
        user.setPass(users.getPass());
        System.out.println(user);
        this.usersService.updateByPrimaryKey(user);

    }

    @RequestMapping("/deluser")

    @ResponseBody

    public void deluser(HttpServletResponse response, HttpServletRequest request,int[] ids) throws IOException {

//        this.usersService.deleteByPrimaryKey();
    }
}


