package graphtheory;

public class BinaryTree {
    Node3 root;

    public BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.left = new Node3(4);
        tree.root.left.right = new Node3(5);

        System.out.println(
                "Preorder traversal of binary tree is ");
        tree.printPreOrderWrapper();

        System.out.println(
                "\nInorder traversal of binary tree is ");
        tree.printInOrder();

        System.out.println(
                "\nPostorder traversal of binary tree is ");
        tree.printPostOrder();
    }

    void printPostOrder(Node3 node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.key);
    }

    void printPreOrder(Node3 node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key);
        printPostOrder(node.left);
        printPostOrder(node.right);
    }

    void printInOrder(Node3 node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        System.out.println(node.key);
        printPostOrder(node.right);
    }
    /*Wrapping above methods making sure starting by its root*/
    void printPreOrderWrapper() {
        printPreOrder(root);
    }

    void printPostOrder() {
        printPostOrder(root);
    }

    void printInOrder() {
        printInOrder(root);
    }



    // Method to calculate the diameter and return it to
    // main
    int diameter(Node3 root)
    {
        // base case if tree is empty
        if (root == null)
            return 0;

        // get the height of left and right sub-trees
        int lheight = height(root.left);
        int rheight = height(root.right);

        // get the diameter of left and right sub-trees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right subtree + 1
         */
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));
    }

    // A wrapper over diameter(Node root)
    int diameter() { return diameter(root); }

    // The function Compute the "height" of a tree. Height
    // is the number of nodes along the longest path from the
    // root node down to the farthest leaf node.
    static int height(Node3 node)
    {
        // base case tree is empty
        if (node == null)
            return 0;

        // If tree is not empty then height = 1 + max of
        //  left height and right heights
        return (1
                + Math.max(height(node.left),
                height(node.right)));
    }

}

class Node3 {
    int key;
    Node3 left, right;

    public Node3(int item) {
        key = item;
        left = right = null;
    }
}
