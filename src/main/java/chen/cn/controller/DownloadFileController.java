package chen.cn.controller;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpServletRequest;

import java.io.*;



@Controller

public class DownloadFileController {

    //把dfile()方法映射到downloadfile.jsp页面

    @RequestMapping("/dfile")

    public String dfile(){

        return "downloadfile";

    }



    @RequestMapping("/downfile")

    //从前端获取要下载的文件名存放在filename中

    public ResponseEntity<byte[]> downfile(String filename, HttpServletRequest request) throws IOException {

        //从前端获取文件名

        System.out.println(filename);

        //获取服务器的真实物理路径

        String path=request.getSession().getServletContext().getRealPath("/upload/");

        //拼接文件路径

        String pathAndFilename=path+filename;

        System.out.println(pathAndFilename);

        //创建文件对象以供后面流传输

        File file=new File(pathAndFilename);

        //创建字节数组用于存放读取出来的文件内容

        byte body[]=null;

        //创建spring mvc的ResponseEntity类的对象

        ResponseEntity<byte[]> entity=null;

        try {

            //创建java流

            InputStream input=new FileInputStream(file);

            //创建数组，数组长度是由下载文件大小决定，其中input.available()是获取文件的长度

            body=new byte[input.available()];

            //把文件的内容读取到数据中

            input.read(body);

            //定义http头 ，状态

            HttpHeaders header=new HttpHeaders();

            header.add("Content-Disposition", "attchement;filename=" + file.getName());

            HttpStatus statusCode = HttpStatus.OK;

            //定义ResponseEntity封装返回信息

            entity = new ResponseEntity<byte[]>(body, header, statusCode);

        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        return entity;

    }

}
