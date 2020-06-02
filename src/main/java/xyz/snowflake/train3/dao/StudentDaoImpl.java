package xyz.snowflake.train3.dao;

import xyz.snowflake.train3.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author snowflake
 * @create-date 2020-04-24 13:08
 */
public class StudentDaoImpl extends AbstractDao implements StudentDao {

    /**
     * 插入一个学生
     *
     * @param student 学生对象
     */
    public void save(Student student) {
        super.save("INSERT INTO student VALUES(?, ?, ?, ?, ?)",
                student.getsNo(), student.getsName(), student.getsSex(), student.getsAge(), student.getsScore());
    }

    /**
     * 查找全部的学生
     *
     * @return 全部的学生对象
     */
    @Override
    public List<Student> findAll() {

        return (List<Student>) super.find("SELECT * FROM student",
                (CollumMapping<ResultSet, List<Student>>) resultSet -> {
                    List<Student> students = new ArrayList<>();
                    try {
                        return mapping(resultSet, students);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, new Object[]{});


    }

    private List<Student> mapping(ResultSet resultSet, List<Student> students) throws SQLException {
        while (resultSet.next()) {
            String sNo = resultSet.getString("s_no");
            String sName = resultSet.getString("s_name");
            String sSex = resultSet.getString("s_sex");
            Integer sAge = resultSet.getInt("s_age");
            Double sScore = resultSet.getDouble("s_score");
            Student student = new Student(sNo, sName, sSex, sAge, sScore);
            students.add(student);
        }
        return students;
    }


    /**
     * 查找全部的学生，并按照分数进行排序
     *
     * @return 全部的学生对象
     */
    @Override
    public List<Student> findAllOrderBySScore() {
        return (List<Student>) super.find("SELECT * FROM student ORDER BY s_score DESC",
                (CollumMapping<ResultSet, List<Student>>) resultSet -> {
                    List<Student> students = new ArrayList<>();
                    try {
                        return mapping(resultSet, students);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, new Object[]{});
    }

    /**
     * 查找名称包含 name 的学生
     *
     * @param name 学生名称
     * @return 学生对象集合
     */
    @Override
    public List<Student> findBySNameLike(String name) {
        return (List<Student>) super.find("SELECT * FROM student WHERE s_name LIKE ?",
                (CollumMapping<ResultSet, List<Student>>) resultSet -> {
                    List<Student> students = new ArrayList<>();
                    try {
                        return mapping(resultSet, students);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, "%" + name + "%");

    }

    /**
     * 删除分数小于 score 的学生
     *
     * @param score 限制分数线
     */
    @Override
    public void deleteStudentBySScoreLessThan(Double score) {
        super.delete("DELETE FROM student WHERE s_score < ", score);
    }
}
