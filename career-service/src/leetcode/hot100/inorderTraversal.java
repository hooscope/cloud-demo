package leetcode.hot100;

import leetcode.base.TreeNode;

import java.util.*;

public class inorderTraversal {


    public static void main(String[] args) {

        List<Integer> inputList = new ArrayList<>(Arrays.asList(1,null,2,3));
        TreeNode root = getTreeNode(inputList);

        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;

    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    static TreeNode getTreeNode(List<Integer> list) {


        int len = list.size();

        if (len == 0){
            return null;
        }

        if (len%2==0){
            list.add(null);
        }

        if (list.get(0)==null){
            return null;
        }

        TreeNode root;
        Queue<TreeNode> queue = new LinkedList<>();
        root = new TreeNode(list.get(0));
        queue.add(root);

        for (int i = 1; i < list.size(); i += 2) {

            TreeNode node = queue.poll();

            Integer left = list.get(i);
            Integer right = list.get(i + 1);

            if (left == null) {
                node.left = null;
            } else {
                node.left = new TreeNode(left);
                queue.add(node.left);
            }
            if (right == null) {
                node.right = null;
            } else {
                node.right = new TreeNode(right);
                queue.add(node.right);
            }
        }
        return root;
    }
}
