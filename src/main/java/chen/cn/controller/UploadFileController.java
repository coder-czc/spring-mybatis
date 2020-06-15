package chen.cn.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.File;

import java.io.IOException;
import java.util.List;


@Controller

public class UploadFileController {

    //把ufile()方法映射到页面suploadfile.jsp

    @RequestMapping("/sufile")

    public String sufile(){

        return "suploadfile";

    }
    @RequestMapping("/mufile")

    public String mufile(){

        return "muploadfile";

    }


    /*接收上传单个文件*/

    @RequestMapping("/sfile")

    public void suploadfile(@RequestParam("up1oadfile") MultipartFile up1oadfile, HttpServletRequest request, HttpServletResponse response) throws IOException {

        /*获取上传文件的文件名*/

        String fileName=up1oadfile.getOriginalFilename();

        System.out.println(fileName);

        /*设置上传文件的保存地址目录*/

        String path=request.getServletContext().getRealPath("/upload/");

        File filePath=new File(path);

        /*判断保存上传文件的目录是否存在，若没有存在则进行创建*/

        if(!filePath.exists()){

            filePath.mkdirs();

        }

        try {

            /*把上传的文件保存在指的目录中（即网站根目录下的upload目录中）*/

            up1oadfile.transferTo(new File(path + fileName));

            response.getWriter().println("{\"success\":true}");

        }catch (Exception e){

            /*若没有能上传则提示错误*/

            System.out.println("error");

            response.getWriter().println("{\"success\":false}");

        }

    }


    @RequestMapping("/mfile")

    public void muploadfile(@RequestParam("up1oadfile") List<MultipartFile> up1oadfile, HttpServletRequest request, HttpServletResponse response) throws IOException {

        /*设置上传文件的保存地址目录*/

        String path=request.getServletContext().getRealPath("/upload/");

        File filePath=new File(path);

        /*判断保存上传文件的目录是否存在，若没有存在则进行创建*/

        if(!filePath.exists()){

            filePath.mkdirs();

        }

        /*通过循环遍历上传文件*/

        boolean flag=false;

        for (MultipartFile file:up1oadfile) {

            //获取上传文件的原始名称

            String fi1ename =file.getOriginalFilename();

            try {

                /*把上传的文件保存在指的目录中（即网站根目录下的upload目录中）*/

                file.transferTo(new File(path + fi1ename));

                flag=true;



            }catch (Exception e){

                /*若没有能上传则提示错误*/

                System.out.println("error");

                flag=false;



            }

        }



        if(flag){

            response.getWriter().println("{\"success\":true}");

        }else{

            response.getWriter().println("{\"success\":false}");

        }

    }

}
