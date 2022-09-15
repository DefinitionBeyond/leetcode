import java.util.Stack;

/**
 * @description:
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @create: 2022-06-01 14:48
 **/
public class CQueue {

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {

        while (!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }

        outStack.push(value);

        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }

    }

    public int deleteHead() {

        if(outStack.isEmpty()){
            return 0;
        }
        return outStack.pop();
    }


    public static void main(String[] args) {

    }

}
