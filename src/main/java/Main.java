import javax.swing.tree.TreeNode;

/**
 * Created by NicolasLopez on 20/10/2017.
 */

/*
* Java Program to print all leaf nodes of binary tree
* using recursion
* input :   a
*          / \
*         b   f
*        / \  / \
*       c   e g  h
*      /          \
*     d            k
*
* output: d e g k
*/

public class Main {

    public static void main(String[] args) throws Exception {

        // let's create a binary tree
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode g = new TreeNode("g");
        TreeNode k = new TreeNode("k");
        TreeNode c = new TreeNode("c", d, null);
        TreeNode h = new TreeNode("h", k, null);
        TreeNode b = new TreeNode("b", c, e);
        TreeNode f = new TreeNode("f", g, h);
        TreeNode root = new TreeNode("a", b, f);

        // print all leaf nodes of binary tree using recursion
        System.out.println("Printing all leaf nodes of binary tree in Java (recursively)");
        printLeaves(root);
    }

    /**
     * A class to represent a node in binary tree
     */

    private static class TreeNode {
        String value;
        TreeNode left;
        TreeNode right;

        TreeNode(String value) {
            this.value = value;
        }

        TreeNode(String data, TreeNode left, TreeNode right) {
            this.value = data;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null ? right == null : false;
        }
    }

    /**
     * Java method to print leaf nodes using recursion * * @param root *
     *
     * You can see that this method accept a TreeNode, which is nothing but our class to represent a binary tree node.
     * It contains a value and reference to two other nodes, left and right. In order to start processing, you pass
     * root node to this method. It then checks if its null or not, if not then it further checks if it's a leaf node or not,
     * if yes, then its print the value of the node and repeat the process with left and right subtree.
     *
     * This is where recursion is useful because you call the printLeaves() method again with left and right node.
     * The logic to check if a node is a leaf or not is simple, if both left and right children of that node are null
     * then it's a leaf node. This logic is encapsulated in the isLeaf() method of TreeNode class.
     *
     */

    public static void printLeaves(TreeNode node) {
        // base case
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            System.out.printf("%s ", node.value);
        }
        printLeaves(node.left);
        printLeaves(node.right);
    }
}

