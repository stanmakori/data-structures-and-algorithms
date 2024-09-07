package Codility.src.com.trees.traversals;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int value){
        this.data = value;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

//    Pre -> before children
//
//    In -> in the middle of children
//
//    Post -> after children
}
