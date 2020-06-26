package chen.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import chen.cn.entity.Admin;

import chen.cn.mapper.AdminMapper;

import chen.cn.service.AdminService;

import java.util.List;

@Service("adminServiceImpl")  //注解为业务类，并且方便在控制器中注入我们这个业务类

public class AdminServiceImpl implements AdminService {

    @Autowired  //注解表示后面的定义的变量spring自动为我们进行封装

    private AdminMapper adminMapper;  //这里声明了数据表的接口类，主要是因为我们业务要调用持久层接口来操作数据表（增删改查操作等）



    @Override

    public int deleteByPrimaryKey(Integer id) {

        return adminMapper.deleteByPrimaryKey(id);

    }



    @Override

    public int insert(Admin record) {

        return adminMapper.insert(record);

    }



    @Override

    public int insertSelective(Admin record) {

        return adminMapper.insertSelective(record);

    }



    @Override

    public Admin selectByPrimaryKey(Integer id) {

        return adminMapper.selectByPrimaryKey(id);

    }

    @Override

    public List<Admin> selectAll() {

        return adminMapper.selectAll();

    }

    @Override

    public int checkAdmin(String name) {

        return adminMapper.checkAdmin(name);

    }



    @Override

    public int checkEmail(String email) {

        return adminMapper.checkEmail(email);

    }



    @Override

    public int checkPhone(String phone) {

        return adminMapper.checkPhone(phone);

    }



    @Override

    public int checkPass(String pass) {

        return adminMapper.checkPass(pass);

    }



    @Override

    public boolean checkNameAndPass(String name, String pass) {

        if((checkAdmin(name)>0) && (checkPass(pass)>0)){

            return true;

        }else{

            return false;

        }

    }



    @Override

    public boolean checkEmailAndPass(String email, String pass) {

        if((checkAdmin(email)>0) && (checkPass(pass)>0)){

            return true;

        }else{

            return false;

        }

    }



    @Override

    public boolean checkPhoneAndPass(String phone, String pass) {

        if((checkAdmin(phone)>0) && (checkPass(pass)>0)){

            return true;

        }else{

            return false;

        }

    }

    @Override

    public int updateByPrimaryKeySelective(Admin record) {

        return adminMapper.updateByPrimaryKeySelective(record);

    }



    @Override

    public int updateByPrimaryKey(Admin record) {

        return adminMapper.updateByPrimaryKey(record);

    }

}
