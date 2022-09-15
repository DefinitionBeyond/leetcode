package stack;

import java.util.Stack;

/**
 * @description:
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @create: 2022-06-01 15:03
 **/
public class MinStack {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> originStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        int temp = minStack.isEmpty() ? x : minStack.peek();
        int newTop = Math.min(temp,x);
        minStack.push(newTop);
        originStack.push(x);
    }

    public void pop() {
        originStack.pop();
        minStack.pop();
    }

    public int top() {
        if(originStack.isEmpty()){
            return -10000;
        }
        return originStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(1);
        obj.push(3);
        System.out.println(obj.min());
        System.out.println(obj.min());
    }

}
