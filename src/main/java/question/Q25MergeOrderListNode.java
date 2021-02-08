package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q25MergeOrderListNode {

    public static void main(String[] args) {
        /**
         * 合并两个排序的链表
         *  1->3->5->8
         *  2->4->6->7
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(7);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode node = merge(node1, node5);
        while (null != node) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        //结束条件
        if (null == node1){
            return node2;
        }
        if (null == node2){
            return node1;
        }
        ListNode head;
        //判断两个链表的头节点大小
        if (node1.data > node2.data) {
            head = node2;
            head.next = merge(node1, node2.next);
        } else {
            head = node1;
            head.next = merge(node1.next, node2);
        }
        return head;
    }
}
