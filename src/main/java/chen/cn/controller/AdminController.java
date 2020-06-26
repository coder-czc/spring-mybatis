package chen.cn.controller;

import chen.cn.common.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import chen.cn.entity.Admin;

import chen.cn.service.AdminService;



import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;



@Controller //这是控制器的的注解，代码当前类为一个控制器

@RequestMapping("/admin")  //这个注解表示控制器的映射的地址为服务器地址+admin

public class AdminController {

    @Resource(name="adminServiceImpl")  //这个注解表示自动注入adminSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private AdminService adminService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        adminService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Admin record){

        Admin admin=new Admin();
        admin.setName("zhangsan");
        admin.setPass("zhangsan");
        admin.setAtype("1");
        admin.setEmail("1@qq.com");
        admin.setPhone("110");
        admin.setQq("101");
        adminService.insert(admin);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Admin record){}



    @RequestMapping("/list")

    @ResponseBody

    public Admin list(HttpServletRequest request, HttpServletResponse response){

        Admin admin=adminService.selectByPrimaryKey(1);

        System.out.println(admin.getName());

        return admin;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Admin> listall(HttpServletRequest request, HttpServletResponse response){

        List<Admin> adminlist=adminService.selectAll();

        return adminlist;

    }

    @RequestMapping("/checkAdmin")

    @ResponseBody

    public ServerResponse  checkAdmin(@Param("name") String name){

        if(adminService.checkAdmin(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }



    @RequestMapping("/checkEmail")

    @ResponseBody

    public ServerResponse  checkEmail(@Param("email") String email){

        if(adminService.checkEmail(email)<0){

            return ServerResponse.createBySuccess("邮箱可以使用");

        }else{

            return ServerResponse.createByErrorMessage("邮箱已经存在");

        }

    }



    @RequestMapping("/checkPhone")

    @ResponseBody

    public ServerResponse  checkPhone(@Param("phone") String phone){

        if(adminService.checkPhone(phone)<0){

            return ServerResponse.createBySuccess("电话可以使用");

        }else{

            return ServerResponse.createByErrorMessage("已经存在");

        }

    }





    @RequestMapping("/checkNameAndPass")

    @ResponseBody

    public ServerResponse  checkNameAndPass(@Param("name") String name,@Param("pass") String pass){

        if(adminService.checkAdmin(name)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){

            return ServerResponse.createBySuccess();

        }else{

            return ServerResponse.createByErrorMessage("输入的管理员和密码错误");

        }

    }



    @RequestMapping("/checkEmailAndPass")

    @ResponseBody

    public ServerResponse  checkEmailAndPass(@Param("email") String email,@Param("pass") String pass){

        if(adminService.checkEmail(email)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){

            return ServerResponse.createBySuccess();

        }else{

            return ServerResponse.createByErrorMessage("输入的邮箱和密码错误");

        }

    }



    @RequestMapping("/checkPhoneAndPass")

    @ResponseBody

    public ServerResponse checkPhoneAndPass(@Param("phone") String phone, @Param("pass") String pass){

        if(adminService.checkPhone(phone)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){

            return ServerResponse.createBySuccess();

        }else{

            return ServerResponse.createByErrorMessage("输入的电话和密码错误");

        }

    }

    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Admin record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Admin record){

        Admin admin=new Admin();
        admin.setId(2);
        admin.setName("lisi");
        admin.setPass("lisi");
        admin.setAtype("1");
        admin.setEmail("1isi@qq.com");
        admin.setPhone("110");
        admin.setQq("101");
        adminService.insert(admin);

    }

}