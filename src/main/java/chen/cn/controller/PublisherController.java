package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Publisher;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Resource(name="publisherServiceImpl")  //这个注解表示自动注入PublisherSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.PublisherService publisherService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        publisherService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Publisher record){

        Publisher publisher=new Publisher();
        publisher.setName("yilin");
        publisherService.insert(publisher);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Publisher record){}



    @RequestMapping("/list")

    @ResponseBody

    public Publisher list(HttpServletRequest request, HttpServletResponse response){

        Publisher publisher=publisherService.selectByPrimaryKey(1);

        System.out.println(publisher.getName());

        return publisher;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Publisher> listall(HttpServletRequest request, HttpServletResponse response){

        List<Publisher> publisherList=publisherService.selectAll();

        return publisherList;

    }

    @RequestMapping("/checkPublisher")

    @ResponseBody

    public ServerResponse checkPublisher(@Param("name") String name){

        if(publisherService.checkPublisher(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Publisher record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Publisher record){

        Publisher publisher=new Publisher();
        publisher.setId(1);
        publisher.setName("qinghua");
        publisherService.insert(publisher);

    }
}
