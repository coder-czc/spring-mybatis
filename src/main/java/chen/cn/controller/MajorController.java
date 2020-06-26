package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Major;
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

@RequestMapping("/major")
public class MajorController {
    @Resource(name="majorServiceImpl")  //这个注解表示自动注入MajorSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.MajorService majorService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        majorService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Major record){

        Major major=new Major();
        major.setName("yuwen");
        majorService.insert(major);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Major record){}



    @RequestMapping("/list")

    @ResponseBody

    public Major list(HttpServletRequest request, HttpServletResponse response){

        Major major=majorService.selectByPrimaryKey(1);

        System.out.println(major.getName());

        return major;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Major> listall(HttpServletRequest request, HttpServletResponse response){

        List<Major> majorList=majorService.selectAll();

        return majorList;

    }

    @RequestMapping("/checkMajor")

    @ResponseBody

    public ServerResponse checkMajor(@Param("name") String name){

        if(majorService.checkMajor(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Major record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Major record){

        Major Major=new Major();
        Major.setId(1);
        Major.setName("jisuanji");
        majorService.insert(Major);

    }
}
