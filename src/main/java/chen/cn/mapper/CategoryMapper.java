package chen.cn.mapper;


import chen.cn.entity.Admin;
import chen.cn.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(@Param("deleteids") String[] deleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectAll();

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}