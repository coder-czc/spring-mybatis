package chen.cn.controller;

import chen.cn.common.ResponseCode;
import chen.cn.common.ServerResponse;
import chen.cn.entity.JcWithBLOBs;
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

@RequestMapping("/jc")
public class JcController {
    @Resource(name="jcServiceImpl")  //这个注解表示自动注入jcSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.JcService jcService;  //这是与上面注入的业务实现类的接口


    @RequestMapping("/index")
    public String index(){
        return "adminindex";
    }

    @RequestMapping("/list")
    public String list(){
        return "jclist";
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response,@RequestBody JSONObject object) throws IOException {
        int i=0;
        String id = object.get("id").toString();
        String[] str = id.split(",");
        for (String s : str) {
            i=  jcService.deleteByPrimaryKey(Integer.parseInt(s));

        }
        if (i> 0) {
            // response.getWriter().println("{\"status\":0,\"msg\":\"删除用户成功\"");
            return ServerResponse.createBySuccessMessage("删除用户成功");
        } else {
            //response.getWriter().println("{\"status\":1,\"msg\":\"删除用户失败\"");
            return ServerResponse.createByErrorMessage("删除用户失败");
        }

    }

    @RequestMapping("/deleteall")

    @ResponseBody

    public ServerResponse deleteall(String id){

        String[] deleteids=id.split(",");//把客户端传送过来的字符串（一般为“1，2，3，4”）转换成数组

        if(deleteids !=null && deleteids.length>0){

            if(jcService.deleteByList(deleteids)>0){

                return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除管理员成功");

            }else{

                return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");

            }

        }else{

            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");

        }

    }

    @RequestMapping(value = "/insert",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   insert(/*Admin record,*/ HttpServletRequest request, HttpServletResponse response) throws IOException {
        JcWithBLOBs jc=new JcWithBLOBs();
        jcService.insert(jc);
        if(jcService.insert(jc)>0){
            return ServerResponse.createBySuccessMessage("添加用户成功");
        }else{
            return ServerResponse.createByErrorMessage("添加用户失败");
        }
    }


    @RequestMapping(value = "/insertSelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  insertSelective(JcWithBLOBs record, HttpServletRequest request, HttpServletResponse response){
        System.out.println(record.getName());
        if(jcService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }else{
            return ServerResponse.createByErrorMessage("添加数据失败");
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   selectByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response){
        JcWithBLOBs jc=jcService.selectByPrimaryKey(id);
        if(jc != null){
            return ServerResponse.createBySuccess(1,jc);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(JcWithBLOBs record, HttpServletRequest request, HttpServletResponse response){
        System.out.println("d:"+record.getId()+','+record.getName());
        if(jcService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccessMessage("更新数据成功");
        }else{
            return ServerResponse.createByErrorMessage("更新数据失败");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  updateByPrimaryKey(JcWithBLOBs record, HttpServletRequest request, HttpServletResponse response){}


    @RequestMapping(value = "/listAll",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   listAll( HttpServletRequest request, HttpServletResponse response){

        List<JcWithBLOBs> jcs=jcService.selectAll();
        if(jcs.size()>0){
            return ServerResponse.createBySuccess(jcs.size(),jcs);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }
}
