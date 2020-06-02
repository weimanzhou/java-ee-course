//package xyz.snowflake.train3.dao;
//
//import xyz.snowflake.train3.entity.Student;
//
//import java.sql.SQLException;
//
///**
// * @author snowflake
// * @create-date 2020-04-24 13:47
// */
//public class StudentDaoImplTest {
//
//    StudentDao studentDao = new StudentDaoImpl();
//
//    @org.junit.Test
//    public void save() throws SQLException {
//        System.out.println("StudentDaoImplTest.save");
//        Student student = new Student("20171426", "snowflake", "男", 20, 99.0);
//        studentDao.save(student);
//    }
//
//    @org.junit.Test
//    public void findAll() throws SQLException {
//        System.out.println("StudentDaoImplTest.findAll");
//        studentDao.findAll()
//                .forEach(System.out::println);
//
//    }
//
//    @org.junit.Test
//    public void findAllOrderBySScore() throws SQLException {
//        System.out.println("StudentDaoImplTest.findAllOrderBySScore");
//        studentDao.findAllOrderBySScore()
//                .forEach(System.out::println);
//
//    }
//
//    @org.junit.Test
//    public void findBySNameLike() throws SQLException {
//        System.out.println("StudentDaoImplTest.findBySNameLike");
//        studentDao.findBySNameLike("snow")
//                .forEach(System.out::println);
//
//    }
//
//    @org.junit.Test
//    public void deleteStudentBySScoreLessThan() {
//        System.out.println("StudentDaoImplTest.deleteStudentBySScoreLessThan");
//        studentDao.deleteStudentBySScoreLessThan(100D);
//
//    }
//}