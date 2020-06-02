package xyz.snowflake.train3.dao;

import xyz.snowflake.train3.annotation.Dao;
import xyz.snowflake.train3.annotation.Delete;
import xyz.snowflake.train3.annotation.Select;
import xyz.snowflake.train3.entity.Student;

import java.util.List;

/**
 * @author snowflake
 * @create-date 2020-04-19 14:37
 */
@Dao
public interface StudentDao extends xyz.snowflake.train3.dao.Dao {

    /**
     *
     * 查找全部的学生
     *
     * @return  学生集合
     */
    @Select("SELECT * FROM student")
    List<Student> findAll();

    /**
     * 编写方法将每条记录按成绩由大到小的顺序显示到 界面
     *
     * @return  按照分数线从高到低的排序的学生对象集合
     */
    @Select("SELECT * FROM student ORDER BY score")
    List<Student> findAllOrderBySScore();

    /**
     *
     * 根据名称模糊查找
     *
     * @param name  学生名称
     * @return      学生集合
     */
    @Select("SELECT * FROM student WHERE s_name LIKE %?%")
    List<Student> findBySNameLike(String name);

    /**
     * 删除成绩小于 score 的学生
     *
     * @param score 限制分数线
     */
    @Delete("DELETE FROM student WHERE s_score < ?")
    void deleteStudentBySScoreLessThan(Double score);

}
