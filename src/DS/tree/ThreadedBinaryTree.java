package DS.tree;


public class ThreadedBinaryTree {

    static class Node
    {
        // Constuctor
        public Node(int val) {
            data = val;
        }
        int data;
        Node left, right;
        boolean rightThread;
    }

    // Utility function to find leftmost node in a tree rooted
// with n
    static Node leftMost(Node n)
    {
        if (n == null)
            return null;

        while (n.left != null)
            n = n.left;

        return n;
    }

    // Java code to do inorder traversal in a threaded binary tree
    static void inOrder(Node root)
    {
        Node cur = leftMost(root);
        while (cur != null) {
            System.out.printf("%d ", cur.data);

            // If this node is a thread node, then go to
            // inorder successor
            if (cur.rightThread)
                cur = cur.right;
            else // Else go to the leftmost child in right
                // subtree
                cur = leftMost(cur.right);
        }
    }

    public static void main(String[] args) {
        Node root = buildNode(1,2,3,true);
        root.left.left = buildNode(4,5,6,true);
        root.left.right = buildNode(6,7,8,true);
        root.right.left = buildNode(9,10,11,true);
        root.right.right = buildNode(12,13,14,true);

        inOrder(root);
    }

    private static Node buildNode(int dataRoot, int dataLeft, int dataRight, boolean rightThread) {
        Node root = new Node(dataRoot);
        root.left = new Node(dataLeft);
        root.right = new Node(dataRight);
        root.rightThread = rightThread;

        return root;
    }
}