package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q23FindListNodeRing {

    public static void main(String[] args) {
        /**
         * 找出链表的环起点 2
         * 1->2->3->4
         *   ↑    ↓
         *   ↑←←↓
         * 两个指针移动，当before追上after时存在环
         * 确定环的长度
         * 回到上一个问题倒数第k个节点
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(findListNodeRing(node1).data);
    }

    public static ListNode findListNodeRing(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        //定义两个起点
        ListNode before = head;
        ListNode after = head;
        /**
         * after :  1 2 3 4   （+1）
         * before : 1 3 2 4   （+2）
         */
        //先确定链表是否有环，before必须走的比after快
        while (before.next.next != null) {
            before = before.next.next;
            after = after.next;
            //如果before重新追上了after，说明有环
            if (before == after) {
                break;
            }
        }
        //遍历结束也没追上说明没有环
        if (before != after) {
            return null;
        }
        //确定环的长度->从after继续再回到before
        int ringSize = 1;
        while (after.next != before) {
            after = after.next;
            ringSize++;
        }
        //Q22倒数第k个节点问题,但存在循环所以多走一步回到环起点
        before = head;
        after = head;
        for (int i = 2; i <= ringSize + 1; i++) {
            before = before.next;
        }
        /**
         * before = after + k  ...（1）
         * after +（size - k） ...（2）
         * before +（size - k）...（3） 用（1）替换 => after + size ...（4）
         * 所以同时走（size - k）相遇处为环的起点
         */
        while (before != after) {
            before = before.next;
            after = after.next;
        }
        return before;
    }
}
