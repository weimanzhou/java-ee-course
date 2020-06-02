package xyz.snowflake.train1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snowflake
 * @create-date 2020-03-18 12:08
 */
public class T10 {


    static class IStack<T> {

        private List<T> stack;

        public IStack() {
            stack = new ArrayList<>();
        }

        public void push(T t) {
            stack.add(t);
        }

        public T pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            return stack.remove(stack.size() - 1);
        }

        public T peek() {
            if (stack.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            return stack.get(stack.size() - 1);
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public int size() {
            return stack.size();
        }

    }

    public static void main(String[] args) {
        IStack<Integer> stack = new IStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("目前栈的大小：" + stack.size());

        int val1 = stack.peek();
        stack.pop();
        System.out.println("查看栈顶元素：" + val1);

        System.out.println("目前栈的大小：" + stack.size());

        System.out.println("栈是否为空：" + stack.isEmpty());

    }

}
