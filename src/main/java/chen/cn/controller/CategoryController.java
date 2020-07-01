package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Category;
import chen.cn.entity.Category;
import chen.cn.service.CategoryService;
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

@RequestMapping("/category")  //这个注解表示控制器的映射的地址为服务器地址+admin

public class CategoryController {
    @Resource(name="categoryServiceImpl")  //这个注解表示自动注入CategorySeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private CategoryService categoryService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/index")
    public String index(){
        return "adminindex";
    }

    @RequestMapping("/list")
    public String list(){
        return "categorylist";
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response,@RequestBody JSONObject object) throws IOException {
        int i=0;
        String id = object.get("id").toString();
        String[] str = id.split(",");
        for (String s : str) {
            i=  categoryService.deleteByPrimaryKey(Integer.parseInt(s));

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
        Category Category=new Category();
        categoryService.insert(Category);
        if(categoryService.insert(Category)>0){
            return ServerResponse.createBySuccessMessage("添加用户成功");
        }else{
            return ServerResponse.createByErrorMessage("添加用户失败");
        }
    }


    @RequestMapping(value = "/insertSelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  insertSelective(Category record, HttpServletRequest request, HttpServletResponse response){
        System.out.println(record.getName());
        if(categoryService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }else{
            return ServerResponse.createByErrorMessage("添加数据失败");
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   selectByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response){
        Category Category=categoryService.selectByPrimaryKey(id);
        if(Category != null){
            return ServerResponse.createBySuccess(1,Category);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Category record, HttpServletRequest request, HttpServletResponse response){
        System.out.println("d:"+record.getId()+','+record.getName());
        if(categoryService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccessMessage("更新数据成功");
        }else{
            return ServerResponse.createByErrorMessage("更新数据失败");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  updateByPrimaryKey(Category record, HttpServletRequest request, HttpServletResponse response){}


    @RequestMapping(value = "/listAll",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   listAll( HttpServletRequest request, HttpServletResponse response){

        List<Category> Categorys=categoryService.selectAll();
        if(Categorys.size()>0){
            return ServerResponse.createBySuccess(Categorys.size(),Categorys);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }
}
