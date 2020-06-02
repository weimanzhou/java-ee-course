package xyz.snowflake.train1;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * @author snowflake
 * @create-date 2020-03-18 11:52
 */
public class T9 {

    static class Student {

        private String name;
        private Integer age;
        private Integer score;
        private String classNum;

        public Student(String name, Integer age, Integer score, String classNum) {
            this.name = name;
            this.age = age;
            this.score = score;
            this.classNum = classNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public String getClassNum() {
            return classNum;
        }

        public void setClassNum(String classNum) {
            this.classNum = classNum;
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Tom", 18, 100, "class05"));
        list.add(new Student("Jerry", 22, 70, "class04"));
        list.add(new Student("Owen", 25, 90, "class05"));
        list.add(new Student("Jim", 30, 8, "class05"));
        list.add(new Student("Steve", 28, 66, "class06"));
        list.add(new Student("Kevin", 24, 100, "class04"));

        OptionalDouble average = list.stream()
                .map(Student::getScore)
                .mapToInt(Integer::valueOf)
                .average();

        System.out.println("全部的平均分为：" + average.getAsDouble());

        list.stream()
                .collect(Collectors.groupingBy(Student::getClassNum))
                .forEach((key, value) -> {
                    double avgScore = value.stream()
                            .mapToInt(Student::getScore)
                            .average()
                            .getAsDouble();

                    System.out.println("班级：" + key + ", 平均分：" + avgScore);
                });

    }

}
