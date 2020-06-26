package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Levels;
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

@RequestMapping("/levels")
public class LevelsController {
    @Resource(name="levelsServiceImpl")  //这个注解表示自动注入LevelsSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.LevelsService levelsService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        levelsService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Levels record){

        Levels levels=new Levels();
        levels.setName("yuwen");
        levelsService.insert(levels);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Levels record){}



    @RequestMapping("/list")

    @ResponseBody

    public Levels list(HttpServletRequest request, HttpServletResponse response){

        Levels levels=levelsService.selectByPrimaryKey(1);

        System.out.println(levels.getName());

        return levels;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Levels> listall(HttpServletRequest request, HttpServletResponse response){

        List<Levels> levelsList=levelsService.selectAll();

        return levelsList;

    }

    @RequestMapping("/checkLevels")

    @ResponseBody

    public ServerResponse checkLevels(@Param("name") String name){

        if(levelsService.checkLevels(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Levels record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Levels record){

        Levels levels=new Levels();
        levels.setId(1);
        levels.setName("yingyu");
        levelsService.insert(levels);

    }
}
