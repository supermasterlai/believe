package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q24ReverseListNode {

    public static void main(String[] args) {
        /**
         * 反转链表
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = reverseListNode2(node1);
        while (null!=node){
            System.out.println(node.data);
            node = node.next;
        }
    }


    public static ListNode reverseListNode(ListNode head){
        /**
         * 循环
         * next会失去next的后一个节点，所以需要缓存第三个
         */
        if (null == head){
            return null;
        }
        if (null == head.next){
            return head;
        }
        ListNode before = null;
        ListNode current = head;
        ListNode after;
        while(current != null ){
            after = current.next;
            //反转
            current.next = before;
            //前进
            before = current;
            current = after;
        }
        return before;
    }

    public static ListNode reverseListNode2(ListNode head){
        //结束条件
        if (null == head.next){
            return head;
        }
        /**
         * 1->2->3->4
         *       null
         *       ↑
         * 1->2->3<-4
         *    null
         *    ↑
         * 1->2<-3<-4
         *
         * null<-1<-2<-3<-4
         */
        ListNode reverseNode = reverseListNode(head.next);
        //反转
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }
}
