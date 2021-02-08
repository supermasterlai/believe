package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q22FindLastNListNode {

    public static void main(String[] args) {
        /**
         * 单向链表倒数第k个节点 1-2-3-4-5-6
         * A 遍历一次统计总数n 在遍历一次找n-k+1
         * B 两个指针移动，p1遍历，当p1走到k处p2开始移动
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(findLastN(node1, 3).data);
    }

    public static ListNode findLastN(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        //两个起点初始化
        ListNode before = head;
        ListNode after = head;
        //before从1走到k（需要k-1次）
        for (int i = 2; i <= k ; i++) {
            //k大于链表长度
            if (before.next == null) {
                return null;
            }
            before = before.next;
        }
        while (before.next != null) {
            before = before.next;
            after = after.next;
        }
        return after;
    }
}
