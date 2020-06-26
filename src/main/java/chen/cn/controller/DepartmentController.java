package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller //这是控制器的的注解，代码当前类为一个控制器

@RequestMapping("/department")
public class DepartmentController {
    @Resource(name="departmentServiceImpl")  //这个注解表示自动注入departmentSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.DepartmentService departmentService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        departmentService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Department record){

        Department department=new Department();
        department.setName("jiaowuchu");
        department.setdManager("lisi");
        departmentService.insert(department);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Department record){}



    @RequestMapping("/list")

    @ResponseBody

    public Department list(HttpServletRequest request, HttpServletResponse response){

        Department department=departmentService.selectByPrimaryKey(1);

        System.out.println(department.getName());

        return department;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Department> listall(HttpServletRequest request, HttpServletResponse response){

        List<Department> departmentlist=departmentService.selectAll();

        return departmentlist;

    }

    @RequestMapping("/checkdepartment")

    @ResponseBody

    public ServerResponse checkDepartment(@Param("name") String name){

        if(departmentService.checkDepartment(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Department record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Department record){

        Department department=new Department();
        department.setId(1);
        department.setName("yingyu");
        department.setdManager("lisi");
        departmentService.insert(department);

    }
}
