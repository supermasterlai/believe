package question;

import java.util.Stack;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q6ReverseScanListNode {

    public static void main(String[] args) {
        /**
         * 从尾到头打印链表
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverse2(node1);
        while (null != node) {
            System.out.println(node.data);
            node = node.next;
        }
        //     printReverse(node1);
    }

    public static ListNode reverse1(ListNode head) {
        /**
         * 递归反转，改变了原链表结构
         */
        if (null == head.next) {
            return head;
        }
        ListNode reverseNode = reverse1(head.next);
        //反转链表
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }

    public static ListNode reverse2(ListNode head) {
        /**
         * 循环
         */
        ListNode pre = head;
        ListNode current = head.next;
        ListNode tempNode;
        while (current != null) {
            tempNode = current.next;
            current.next = pre;
            pre = current;
            current = tempNode;
        }
        //首节点处理
        head.next = null;
        return pre;
    }

    public static void printReverse(ListNode head) {
        /**
         * 不改变原结构
         */
//        if (head.next !=null) {
//            printReverse(head.next);
//        }
//        System.out.println(head.data);
        Stack<Integer> stack = new Stack<>();
        while (null != head) {
            stack.push(head.data);
            head = head.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}

class ListNode {
    Integer data;
    ListNode next;

    public ListNode(Integer data) {
        this.data = data;
    }
}