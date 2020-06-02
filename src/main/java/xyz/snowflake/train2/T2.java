package xyz.snowflake.train2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author snowflake
 * @create-date 2020-04-01 13:24
 */
public class T2 {

//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
    static class Student {
        private String sNum;
        private String sName;
        private String specialty;
        private Integer gsScore;
        private Integer enScore;
        private Integer javaScore;

        public Student(String sNum, String sName, String specialty, Integer gsScore, Integer enScore, Integer javaScore) {
            this.sNum = sNum;
            this.sName = sName;
            this.specialty = specialty;
            this.gsScore = gsScore;
            this.enScore = enScore;
            this.javaScore = javaScore;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (sNum != null ? !sNum.equals(student.sNum) : student.sNum != null) return false;
        if (sName != null ? !sName.equals(student.sName) : student.sName != null) return false;
        if (specialty != null ? !specialty.equals(student.specialty) : student.specialty != null) return false;
        if (gsScore != null ? !gsScore.equals(student.gsScore) : student.gsScore != null) return false;
        if (enScore != null ? !enScore.equals(student.enScore) : student.enScore != null) return false;
        return javaScore != null ? javaScore.equals(student.javaScore) : student.javaScore == null;
    }

    @Override
    public int hashCode() {
        int result = sNum != null ? sNum.hashCode() : 0;
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (gsScore != null ? gsScore.hashCode() : 0);
        result = 31 * result + (enScore != null ? enScore.hashCode() : 0);
        result = 31 * result + (javaScore != null ? javaScore.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("sNum='").append(sNum).append('\'');
        sb.append(", sName='").append(sName).append('\'');
        sb.append(", specialty='").append(specialty).append('\'');
        sb.append(", gsScore=").append(gsScore);
        sb.append(", enScore=").append(enScore);
        sb.append(", javaScore=").append(javaScore);
        sb.append('}');
        return sb.toString();
    }
}

    public static void main(String[] args) {
        Student student1 = new Student("20171426", "tako", "软件工程",
                80, 80, 80);
        Student student2 = new Student("20171427", "tako", "软件工程",
                83, 89, 90);
        Student student3 = new Student("20171428", "tako", "软件工程",
                70, 85, 70);
        Student student4 = new Student("20171429", "tako", "软件工程",
                70, 90, 65);
        Student student5 = new Student("20171430", "tako", "软件工程",
                60, 60, 80);

        Comparator<Student> cmp = (e1, e2) -> {
            int sumScore1 = e1.enScore + e1.gsScore + e1.javaScore;
            int sumScore2 = e2.enScore + e2.gsScore + e2.javaScore;
            if (sumScore1 == sumScore2) {
                return e1.sNum.compareTo(e2.sNum);
            } else {
                return sumScore2 - sumScore1;
            }
        };

        Set<Student> students = new TreeSet<>(cmp);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        students.forEach(System.out::println);
    }

}
