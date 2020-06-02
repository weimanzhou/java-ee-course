package xyz.snowflake.train2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @author snowflake
 * @create-date 2020-04-01 15:15
 */
public class T3 {

    static class Person {
        private int pid;  //编号
        private String name;        // 姓名
        private String sex;        // 性别
        private String tel;        // 电话
        private String address;    // 地址
        private String email;        //email

        public Person(int pid, String name, String sex, String tel, String address, String email) {
            this.pid = pid;
            this.name = name;
            this.sex = sex;
            this.tel = tel;
            this.address = address;
            this.email = email;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (pid != person.pid) return false;
            if (name != null ? !name.equals(person.name) : person.name != null) return false;
            if (sex != null ? !sex.equals(person.sex) : person.sex != null) return false;
            if (tel != null ? !tel.equals(person.tel) : person.tel != null) return false;
            if (address != null ? !address.equals(person.address) : person.address != null) return false;
            return email != null ? email.equals(person.email) : person.email == null;
        }

        @Override
        public int hashCode() {
            int result = pid;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (sex != null ? sex.hashCode() : 0);
            result = 31 * result + (tel != null ? tel.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            result = 31 * result + (email != null ? email.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("pid=").append(pid);
            sb.append(", name='").append(name).append('\'');
            sb.append(", sex='").append(sex).append('\'');
            sb.append(", tel='").append(tel).append('\'');
            sb.append(", address='").append(address).append('\'');
            sb.append(", email='").append(email).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    static class PersonDao {
        private List<Person> persons = new ArrayList<>();

        // 添加 联系人
        public void add(Person p) {
            persons.remove(p);
            persons.add(p);
        }

        // 通过人的编号删除 联系人
        public void deleteById(int pid) {
            persons.removeIf(e -> e.pid == pid);
        }

        public List<Person> findAll() {
            return persons;
        }

        //通过人的姓名查找联系人，返回一个集合
        public List<Person> findByName(String name) {
            return persons.stream()
                    .filter(e -> e.name.equals(name))
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(2, 1));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        JTextField pidTextField = new JTextField();
        JTextField nameTextField = new JTextField();
        JTextField sexTextField = new JTextField();
        JTextField addressTextField = new JTextField();
        JTextField phoneTextField = new JTextField();
        JTextField emailTextField = new JTextField();

        panel.add(new JLabel("编号"));
        panel.add(pidTextField);
        panel.add(new JLabel("姓名"));
        panel.add(nameTextField);
        panel.add(new JLabel("性别"));
        panel.add(sexTextField);
        panel.add(new JLabel("电话"));
        panel.add(phoneTextField);
        panel.add(new JLabel("地址"));
        panel.add(addressTextField);
        panel.add(new JLabel("email"));
        panel.add(emailTextField);


        Vector<String> columns = new Vector<>();
        columns.add("编号");
        columns.add("姓名");
        columns.add("性别");
        columns.add("电话");
        columns.add("地址");
        columns.add("Email");

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setDataVector(null, columns);

        JTable contentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contentTable);

        container.add(scrollPane);

        PersonDao personDao = new PersonDao();

        JButton showAllButton = new JButton("显示所有");
        showAllButton.addActionListener(e -> {
            List<Person> person = personDao.findAll();
            Vector<Vector<String>> vector = new Vector<>();
            person.forEach(ee -> {
                Vector<String> tmp = new Vector<>();
                tmp.add(String.valueOf(ee.pid));
                tmp.add(ee.name);
                tmp.add(ee.sex);
                tmp.add(ee.tel);
                tmp.add(ee.address);
                tmp.add(ee.email);
                vector.add(tmp);
            });
            tableModel.setDataVector(vector, columns);
        });

        JButton searchButton = new JButton("查询");

        searchButton.addActionListener(e -> {
            // 获取用户姓名
            String name = nameTextField.getText();
            List<Person> person = personDao.findByName(name);
            Vector<Vector<String>> vector = new Vector<>();
            person.forEach(ee -> {
                Vector<String> tmp = new Vector<>();
                tmp.add(String.valueOf(ee.pid));
                tmp.add(ee.name);
                tmp.add(ee.sex);
                tmp.add(ee.tel);
                tmp.add(ee.address);
                tmp.add(ee.email);
                vector.add(tmp);
            });
            tableModel.setDataVector(vector, columns);
        });

        JButton addButton = new JButton("添加");

        addButton.addActionListener(e -> {
            // 获取到全部信息
            int id = Integer.parseInt(pidTextField.getText());
            String name = nameTextField.getText();
            String sex = sexTextField.getText();
            String tel = phoneTextField.getText();
            String address = addressTextField.getText();
            String email = emailTextField.getText();

            Person person = new Person(id, name, sex, tel, address, email);
            personDao.add(person);
            showAllButton.doClick();
        });


        JButton deleteButton = new JButton("删除");
        deleteButton.addActionListener(e -> {
            int selectIndex = contentTable.getSelectedRow();
            int id = Integer.parseInt(String.valueOf(contentTable.getModel().getValueAt(selectIndex, 0)));
            personDao.deleteById(id);
            showAllButton.doClick();
        });

        panel.add(searchButton);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(showAllButton);
        container.add(panel);
        showAllButton.doClick();


        frame.setSize(500, 300);
        frame.setVisible(true);
    }

}
