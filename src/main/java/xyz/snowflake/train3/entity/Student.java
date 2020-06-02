package xyz.snowflake.train3.entity;

/**
 * @author snowflake
 * @create-date 2020-04-19 14:36
 */
public class Student {

    private String sNo;
    private String sName;
    private String sSex;

    private Integer sAge;

    private Double sScore;

    public Student(String sNo, String sName, String sSex, Integer sAge, Double sScore) {
        this.sNo = sNo;
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sScore = sScore;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public Double getsScore() {
        return sScore;
    }

    public void setsScore(Double sScore) {
        this.sScore = sScore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("sNo='").append(sNo).append('\'');
        sb.append(", sName='").append(sName).append('\'');
        sb.append(", sSex='").append(sSex).append('\'');
        sb.append(", sAge=").append(sAge);
        sb.append(", sScore=").append(sScore);
        sb.append('}');
        return sb.toString();
    }
}
