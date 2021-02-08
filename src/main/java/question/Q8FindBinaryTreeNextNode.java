package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q8FindBinaryTreeNextNode {

    public static void main(String[] args) {
        /**
         * 查找二叉树中序遍历的下一节点
         */
        BinaryTreeNodeWithParent a = new BinaryTreeNodeWithParent("a");
        BinaryTreeNodeWithParent b = new BinaryTreeNodeWithParent("b");
        b.parent = a;
        BinaryTreeNodeWithParent c = new BinaryTreeNodeWithParent("c");
        c.parent = a;
        a.left = b;
        a.right = c;
        BinaryTreeNodeWithParent d = new BinaryTreeNodeWithParent("d");
        d.parent = b;
        BinaryTreeNodeWithParent e = new BinaryTreeNodeWithParent("e");
        e.parent = b;
        b.left = d;
        b.right = e;
        BinaryTreeNodeWithParent h = new BinaryTreeNodeWithParent("h");
        h.parent = e;
        BinaryTreeNodeWithParent i = new BinaryTreeNodeWithParent("i");
        i.parent = e;
        e.left = h;
        e.right = i;
        BinaryTreeNodeWithParent f = new BinaryTreeNodeWithParent("f");
        f.parent = c;
        BinaryTreeNodeWithParent g = new BinaryTreeNodeWithParent("g");
        g.parent = c;
        c.left = f;
        c.right = g;
        /**
         * planA 中序遍历缓存list取下一个 空间O(n) 时间O(n)
         * planB 分情况讨论 空间O(1) 时间O(n) √
         */
        BinaryTreeNodeWithParent next = findBinaryTreeNextNode(a, g);
        if (next == null) {
            System.out.println("不存在下一节点！");
        } else {
            System.out.println(next.data);
        }
    }

    public static BinaryTreeNodeWithParent findBinaryTreeNextNode(BinaryTreeNodeWithParent root, BinaryTreeNodeWithParent target) {
        BinaryTreeNodeWithParent next = null;
        if (null == root || null == root.right) {
            return null;
        }
        //根据target有无右子树分类
        if (target.right != null) {
            //右子树的最左节点
            BinaryTreeNodeWithParent temp = target.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            next = temp;
        } else {
            //target为父节点的左节点,则下一节点就是父节点
            if (target.parent.left == target) {
                next = target.parent;
            }
            //target为父节点的右节点,则下一节点就是根节点或者没有
            if (target.parent.right == target) {
                BinaryTreeNodeWithParent temp = target.parent;
                while (temp.parent.parent != null) {
                    temp = temp.parent;
                }
                if (temp.parent.left == temp) {
                    next = temp.parent;
                }
                if (temp.parent.right == temp) {
                    next = null;
                }
            }
        }
        return next;
    }

}

class BinaryTreeNodeWithParent {

    String data;
    BinaryTreeNodeWithParent left;
    BinaryTreeNodeWithParent right;
    BinaryTreeNodeWithParent parent;

    public BinaryTreeNodeWithParent(String data) {
        this.data = data;
    }
}
