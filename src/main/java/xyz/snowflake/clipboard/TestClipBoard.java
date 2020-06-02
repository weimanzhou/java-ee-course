package xyz.snowflake.clipboard;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @author snowflake
 * @create-date 2020-03-13 21:29
 */
public class TestClipBoard {

    public static void main(String[] args) {
        // 获取系统的粘贴板
        Clipboard clipBoard =  Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection("测试粘贴的内容");
        clipBoard.setContents(trans, null);

    }

}
