import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Question230KthSmallestElementInABST {

    public static void main(String[] args) {

        // Example 1:
        TreeNode root1 = treeBuilder(Arrays.asList(3, 1, 4, null, 2), 0);
        System.out.println(kthSmallest(root1, 1));

        // Example 2:
        TreeNode root2 = treeBuilder(Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 0);
        System.out.println(kthSmallest(root2, 3));
    }
    
    public static int kthSmallest(TreeNode root, int k) {
        return traverseBSTOrdered(root).get(k-1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static List<Integer> traverseBSTOrdered(TreeNode node) {
        var tempOrderedList = new ArrayList<Integer>();
        if (node == null) {
            return tempOrderedList;
        }
        tempOrderedList.addAll(traverseBSTOrdered(node.left));
        tempOrderedList.add(node.val);
        tempOrderedList.addAll(traverseBSTOrdered(node.right));
        return tempOrderedList;
    }

    public static TreeNode treeBuilder(List<Integer> treeAsArray, int index) {
        if (index >= treeAsArray.size() || treeAsArray.get(index) == null) {
            return null;
        }
        return new TreeNode(treeAsArray.get(index), treeBuilder(treeAsArray, ((index+1) * 2) - 1),
                treeBuilder(treeAsArray, (index+1) * 2));
    }
    

}
