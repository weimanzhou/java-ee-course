package xyz.snowflake.train1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

/**
 * @author snowflake
 * @create-date 2020-03-10 23:44
 */
public class T4 {

    static class Student {

        private String name;
        private String studentNumber;
        private LocalDate birthday;
        private String gender;
        private String department;

        public Student(String name, String studentNumber, LocalDate birthday, String gender, String department) {
            this.name = name;
            this.studentNumber = studentNumber;
            this.birthday = birthday;
            this.gender = gender;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Student{" + "name='" + name + '\'' +
                    ", studentNumber='" + studentNumber + '\'' +
                    ", birthday=" + birthday +
                    ", gender='" + gender + '\'' +
                    ", department='" + department + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        Student student1 = new Student("魏满舟",
                "20171426",
                LocalDate.of(1999, 12, 6),
                "男",
                "计算机与科学技术");

        Student student2 = new Student("张三",
                "20171422",
                LocalDate.of(1999, 12, 6),
                "男",
                "计算机与科学技术");

        Student student3 = new Student("李四",
                "20171401",
                LocalDate.of(1999, 12, 6),
                "男",
                "计算机与科学技术");

        System.out.println("---------未排序---------");
        List.of(student1, student2, student3)
                .forEach(System.out::println);

        System.out.println("---------已排序---------");
        List.of(student1, student2, student3)
                .stream()
                .sorted(Comparator.comparing(e -> e.name))
                .forEach(System.out::println);
    }

}
