package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Category;
import chen.cn.service.CategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller //这是控制器的的注解，代码当前类为一个控制器

@RequestMapping("/category")  //这个注解表示控制器的映射的地址为服务器地址+admin

public class CategoryController {
    @Resource(name="categoryServiceImpl")  //这个注解表示自动注入CategorySeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private CategoryService categoryService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        categoryService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Category record){

        Category Category=new Category();
        Category.setName("yuwen");
        categoryService.insert(Category);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Category record){}



    @RequestMapping("/list")

    @ResponseBody

    public Category list(HttpServletRequest request, HttpServletResponse response){

        Category Category=categoryService.selectByPrimaryKey(1);

        System.out.println(Category.getName());

        return Category;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Category> listall(HttpServletRequest request, HttpServletResponse response){

        List<Category> categoryList=categoryService.selectAll();

        return categoryList;

    }

    @RequestMapping("/checkCategory")

    @ResponseBody

    public ServerResponse checkCategory(@Param("name") String name){

        if(categoryService.checkCategory(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Category record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Category record){

        Category Category=new Category();
        Category.setId(2);
        Category.setName("shuxue");
        categoryService.insert(Category);

    }
}
