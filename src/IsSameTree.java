/**
 * Given two binary trees, write a function to check if they are equal or not.

 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * Created by prototype on 2016/4/8.
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (this.logicXor((null == p) , (null == q))){
            return false;
        }else if (null == p && null == q){
            return true;
        }
        if (null != p && null != q){
            if (p.val != q.val){
                return false;
            }
        }
        if (isSameTree(p.left,q.left) && isSameTree(p.right,q.right)){
            return true;
        }
        return false;
    }

    public boolean logicXor(boolean p,boolean q){
        if(p == q){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String [] args){
        TreeNode n1 = new TreeNode(1,null,null);

        System.out.println(new IsSameTree().isSameTree(n1, n1));

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x,TreeNode left,TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

