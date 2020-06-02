package xyz.snowflake.train3;

import xyz.snowflake.train3.dao.StudentDaoImpl;
import xyz.snowflake.train3.entity.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * @author snowflake
 * @create-date 2020-04-24 13:59
 */
public class Application {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(2, 1));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        JTextField noTextField = new JTextField();
        JTextField nameTextField = new JTextField();
        JTextField sexTextField = new JTextField();
        JTextField ageTextField = new JTextField();
        JTextField scoreTextField = new JTextField();

        panel.add(new JLabel("编号"));
        panel.add(noTextField);
        panel.add(new JLabel("姓名"));
        panel.add(nameTextField);
        panel.add(new JLabel("性别"));
        panel.add(sexTextField);
        panel.add(new JLabel("年龄"));
        panel.add(ageTextField);
        panel.add(new JLabel("分数"));
        panel.add(scoreTextField);
        panel.add(new JLabel(""));


        Vector<String> columns = new Vector<>();
        columns.add("编号");
        columns.add("姓名");
        columns.add("性别");
        columns.add("年龄");
        columns.add("分数");

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setDataVector(null, columns);

        JTable contentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contentTable);

        container.add(scrollPane);

        StudentDaoImpl studentDao = new StudentDaoImpl();

        JButton showAllButton = new JButton("显示所有");
        showAllButton.addActionListener(e -> {
            List<Student> person = studentDao.findAll();
            Vector<Vector<String>> vector = new Vector<>();
            person.forEach(ee -> {
                Vector<String> tmp = new Vector<>();
                tmp.add(ee.getsNo());
                tmp.add(ee.getsName());
                tmp.add(ee.getsSex());
                tmp.add(String.valueOf(ee.getsAge()));
                tmp.add(String.valueOf(ee.getsScore()));
                vector.add(tmp);
            });
            tableModel.setDataVector(vector, columns);
        });

        JButton searchButton = new JButton("根据名字查询");

        searchButton.addActionListener(e -> {
            // 获取用户姓名
            String name = nameTextField.getText();
            List<Student> person = studentDao.findBySNameLike(name);
            Vector<Vector<String>> vector = new Vector<>();
            person.forEach(ee -> {
                Vector<String> tmp = new Vector<>();
                tmp.add(ee.getsNo());
                tmp.add(ee.getsName());
                tmp.add(ee.getsSex());
                tmp.add(String.valueOf(ee.getsAge()));
                tmp.add(String.valueOf(ee.getsScore()));
                vector.add(tmp);
            });
            tableModel.setDataVector(vector, columns);
        });

        JButton orderByScoreButton = new JButton("查询(根据分数排序)");
        orderByScoreButton.addActionListener(e -> {
            List<Student> studentList = studentDao.findAllOrderBySScore();
            Vector<Vector<String>> vector = new Vector<>();
            studentList.forEach(ee -> {
                Vector<String> tmp = new Vector<>();
                tmp.add(ee.getsNo());
                tmp.add(ee.getsName());
                tmp.add(ee.getsSex());
                tmp.add(String.valueOf(ee.getsAge()));
                tmp.add(String.valueOf(ee.getsScore()));
                vector.add(tmp);
            });
            tableModel.setDataVector(vector, columns);
        });

        JButton addButton = new JButton("添加");

        addButton.addActionListener(e -> {
            // 获取到全部信息
            String id = noTextField.getText();
            String name = nameTextField.getText();
            String sex = sexTextField.getText();
            Integer age = Integer.parseInt(ageTextField.getText());
            Double score = Double.parseDouble(scoreTextField.getText());

            Student person = new Student(id, name, sex, age, score);
            studentDao.save(person);
            showAllButton.doClick();
        });


        JButton deleteButton = new JButton("删除分数不满足学生");
        deleteButton.addActionListener(e -> {
            Double score = Double.parseDouble(scoreTextField.getText());
            studentDao.deleteStudentBySScoreLessThan(score);
            showAllButton.doClick();
        });

        panel.add(searchButton);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(showAllButton);
        panel.add(orderByScoreButton);
        container.add(panel);
        showAllButton.doClick();


        frame.setSize(500, 300);
        frame.setVisible(true);
    }

}
