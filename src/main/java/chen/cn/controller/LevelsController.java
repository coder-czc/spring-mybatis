package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Levels;
import chen.cn.service.LevelsService;
import net.minidev.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller //这是控制器的的注解，代码当前类为一个控制器

@RequestMapping("/levels")  //这个注解表示控制器的映射的地址为服务器地址+admin

public class LevelsController {
    @Resource(name="levelsServiceImpl")  //这个注解表示自动注入levelsSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private LevelsService levelsService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/index")
    public String index(){
        return "adminindex";
    }

    @RequestMapping("/list")
    public String list(){
        return "levelslist";
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response,@RequestBody JSONObject object) throws IOException {
        int i=0;
        String id = object.get("id").toString();
        String[] str = id.split(",");
        for (String s : str) {
            i=  levelsService.deleteByPrimaryKey(Integer.parseInt(s));

        }
        if (i> 0) {
            // response.getWriter().println("{\"status\":0,\"msg\":\"删除用户成功\"");
            return ServerResponse.createBySuccessMessage("删除用户成功");
        } else {
            //response.getWriter().println("{\"status\":1,\"msg\":\"删除用户失败\"");
            return ServerResponse.createByErrorMessage("删除用户失败");
        }

    }


    @RequestMapping(value = "/insert",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   insert(/*Admin record,*/ HttpServletRequest request, HttpServletResponse response) throws IOException {
        Levels levels=new Levels();
        levelsService.insert(levels);
        if(levelsService.insert(levels)>0){
            return ServerResponse.createBySuccessMessage("添加用户成功");
        }else{
            return ServerResponse.createByErrorMessage("添加用户失败");
        }
    }


    @RequestMapping(value = "/insertSelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  insertSelective(Levels record, HttpServletRequest request, HttpServletResponse response){
        System.out.println(record.getName());
        if(levelsService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }else{
            return ServerResponse.createByErrorMessage("添加数据失败");
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   selectByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response){
        Levels levels=levelsService.selectByPrimaryKey(id);
        if(levels != null){
            return ServerResponse.createBySuccess(1,levels);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Levels record, HttpServletRequest request, HttpServletResponse response){
        System.out.println("d:"+record.getId()+','+record.getName());
        if(levelsService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccessMessage("更新数据成功");
        }else{
            return ServerResponse.createByErrorMessage("更新数据失败");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  updateByPrimaryKey(Levels record, HttpServletRequest request, HttpServletResponse response){}


    @RequestMapping(value = "/listAll",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   listAll( HttpServletRequest request, HttpServletResponse response){

        List<Levels> levelss=levelsService.selectAll();
        if(levelss.size()>0){
            return ServerResponse.createBySuccess(levelss.size(),levelss);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }
}
