package question;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q9RealiseQueueWithStack<T> {

    /**
     * 定义两个栈实现一个队列的增删操作
     */
    private final Stack<T> eden = new Stack<>();
    private final Stack<T> survivor = new Stack<>();

    /**
     * 两个队列实现栈
     */
    private final Queue<T> in = new LinkedBlockingDeque<>();
    private final Queue<T> out = new LinkedBlockingDeque<>();

    public static void main(String[] args) throws Exception {
        Q9RealiseQueueWithStack<String> queueWithStack = new Q9RealiseQueueWithStack<>();
        queueWithStack.appendTail("a");
        queueWithStack.appendTail("b");
        queueWithStack.appendTail("c");
        queueWithStack.deleteHead();
        queueWithStack.deleteHead();
        queueWithStack.appendTail("d");
        queueWithStack.appendTail("e");
        queueWithStack.deleteHead();
        queueWithStack.deleteHead();
        queueWithStack.deleteHead();
    }

    public void appendTail(T data) {
        eden.push(data);
    }

    public void deleteHead() throws Exception {
        if (eden.isEmpty() && survivor.isEmpty()) {
            throw new Exception("empty queue!");
        }
        //如果survivor不为空，则不必操作eden
        if (survivor.isEmpty()) {
            while (!eden.isEmpty()) {
                survivor.push(eden.pop());
            }
        }
        System.out.println(survivor.peek());
        survivor.pop();
    }

    public void myStackPush(T data) {
        in.offer(data);
    }

    public void myStackDelete() throws Exception {
        if (in.isEmpty()) {
            throw new Exception("empty stack!");
        }
        //只留最后一个在in
        for (int i = in.size() - 1; i > 0; i--) {
            out.offer(in.poll());
        }
        System.out.println(in.peek());
        in.poll();
        //再把out复制回in
        for (int i = out.size() - 1; i >= 0; i--) {
            in.offer(out.poll());
        }
    }
}
