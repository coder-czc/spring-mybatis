package chen.cn.service;

import chen.cn.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryService {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectAll();

    int checkCategory(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
