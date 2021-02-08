package question;

import java.util.Stack;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q27BinaryTreeImage {

    public static void main(String[] args) {
        /**
         * 二叉树的镜像
         *    8             8
         *  6   10    => 10   6
         * 5 7    9     9    7 5
         */
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(6);
        BinaryTreeNode node2 = new BinaryTreeNode(10);
        root.left = node1;
        root.right = node2;
        BinaryTreeNode node3 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        node1.left = node3;
        node1.right = node4;
        BinaryTreeNode node5 = new BinaryTreeNode(9);
        node2.right = node5;
        //递归
        // BinaryTreeNode image = getTreeImage1(root);
        // Q7RebuildBinaryTree.preTraverse(image);
        //非递归
        getTreeImage2(root);
        Q7RebuildBinaryTree.preTraverse(root);
    }

    public static BinaryTreeNode getTreeImage1(BinaryTreeNode tree) {
        //最后的null节点无所谓镜像
        if (null == tree) {
            return null;
        }
        //没有子树则直接返回
        if (null == tree.left && null == tree.right) {
            return tree;
        }
        //左子树或者右子树不为空则交换
        BinaryTreeNode temp = tree.left;
        tree.left = getTreeImage1(tree.right);
        tree.right = getTreeImage1(temp);
        return tree;
    }

    public static void getTreeImage2(BinaryTreeNode tree) {
        if (null == tree) {
            return;
        }
        //root没有子树则直接返回
        if (null == tree.left && null == tree.right) {
            return;
        }
        //栈实现
        Stack<BinaryTreeNode> stack = new Stack<>();
        //处理根节点
        stack.push(tree);
        BinaryTreeNode temp;
        while (!stack.isEmpty()) {
            tree = stack.pop();
            temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
            if (tree.left != null) {
                stack.push(tree.left);
            }
            if (tree.right != null) {
                stack.push(tree.right);
            }
        }
    }
}
