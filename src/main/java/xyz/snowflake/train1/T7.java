package xyz.snowflake.train1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;
import java.util.stream.IntStream;

/**
 * @author snowflake
 * @create-date 2020-03-11 22:36
 */
public class T7 {

    public static void main(String[] args) {

        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        // 获取当前月的第一天为周几
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);

        Vector<String> head = new Vector<>();
        head.add("日");
        head.add("一");
        head.add("二");
        head.add("三");
        head.add("四");
        head.add("五");
        head.add("六");



        // 定义一个存放数据的位置
        int[] dates = new int[42];
        for (int i = 0; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dates[i + day - 1] = i + 1;
        }

        JFrame frame = new JFrame();

        Container container = frame.getContentPane();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        Integer[] years = IntStream.range(calendar.get(Calendar.YEAR) - 4, calendar.get(Calendar.YEAR) + 4)
                .boxed()
                .toArray(Integer[]::new);

        Integer[] months = IntStream.range(1, 12)
                .boxed()
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(years));

        JComboBox<Integer> yearLists = new JComboBox<>(years);
        JComboBox<Integer> monthLists = new JComboBox<>(months);
        yearLists.setSelectedIndex(years.length / 2);
        monthLists.setSelectedIndex(calendar.get(Calendar.MONTH));

        panel.add(new JLabel("年"));
        panel.add(yearLists);
        panel.add(new JLabel("月"));
        panel.add(monthLists);

        JButton confirm = new JButton("确定");
        panel.add(confirm);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setDataVector(null, head);
        tableModel.setRowCount(7);
        tableModel.setColumnCount(7);

        JTable table = new JTable(tableModel);
        // 7 111
        // 6 110

        for (int i = 0; i < head.size(); i++) {
            table.setValueAt(head.get(i), 0, i);
        }

        for (int i = 0; i < dates.length; i++) {
            table.setValueAt(dates[i], i / 7 + 1, i % 7);
        }

        confirm.addActionListener(e -> {
            int year = Integer.parseInt(String.valueOf(yearLists.getSelectedItem()));
            int month = Integer.parseInt(String.valueOf(monthLists.getSelectedItem()));
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);

            yearLists.removeAllItems();

            IntStream.range(calendar.get(Calendar.YEAR) - 4, calendar.get(Calendar.YEAR) + 4)
                    .boxed()
                    .forEach(yearLists::addItem);

            yearLists.setSelectedIndex(years.length / 2);
            monthLists.setSelectedIndex(calendar.get(Calendar.MONTH));

            // 重新设置表格数据
            // 定义一个存放数据的位置
            int newDay = calendar.get(Calendar.DAY_OF_WEEK);
            for (int i = 0; i < dates.length; i++) {
                dates[i] = 0;
            }
            for (int i = 0; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                dates[i + newDay - 1] = i + 1;
            }
            for (int i = 0; i < dates.length; i++) {
                table.setValueAt(dates[i] == 0 ? "" : dates[i], i / 7 + 1, i % 7);
            }
            System.out.println(Arrays.toString(dates));
        });

        container.setLayout(new BorderLayout());

        container.add(panel, BorderLayout.NORTH);
        container.add(table, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.validate();
    }

}
