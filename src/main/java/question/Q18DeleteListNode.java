package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q18DeleteListNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        /**
         * 在O(1)时间内删除链表中的节点
         * 用待删除节点的后一个节点覆盖当前节点
         * 尾节点只能用顺序查找 ->平均时间 [（n-1）*1 + 1*n] /n
         */
        deleteNode(node1, node1);
        ListNode head = node1;

        /**
         * 删除链表中的重复元素
         * 头节点需要删除的情况
         */
        //   ListNode head = deleteDuplicateNode(node1);
        while (null != head) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void deleteNode(ListNode head, ListNode target) {
        if (null == head || null == target) {
            return;
        }
        //删除的是尾节点,顺序查找
        if (null == target.next) {
            while (head.next != target) {
                head = head.next;
            }
            head.next = null;
        } else {
            target.data = target.next.data;
            target.next = target.next.next;
        }
    }

    public static ListNode deleteDuplicateNode(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        /**
         * 1->2->2->3->3->4
         */
        //设置新头节点，防止第一个元素需要删除
        ListNode newNode = new ListNode(null);
        newNode.next = head;
        //没有重复的最后一个节点
        ListNode preTempNode = newNode;
        //当前节点
        ListNode currentTempNode = head;
        //下一节点
        ListNode nextTempNode;
        while (currentTempNode != null && currentTempNode.next != null) {
            nextTempNode = currentTempNode.next;
            if (currentTempNode.data.equals(nextTempNode.data)) {
                //下一节点重复
                while (nextTempNode != null && currentTempNode.data.equals(nextTempNode.data)) {
                    nextTempNode = nextTempNode.next;
                }
                //删除重复的节点
                preTempNode.next = nextTempNode;
            } else {
                //下一节点不重复
                preTempNode = currentTempNode;
            }
            currentTempNode = nextTempNode;
        }
        return newNode.next;
    }
}
