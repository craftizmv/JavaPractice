package DS.tree

import java.util.*

// non-recursive java program for inorder traversal


/* Class containing left and right child of
current node and key value*/
internal class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null

    init {
        left = right
    }
}

/* Class to print the inorder traversal */
internal class BinaryTreeGFG {
    var root: Node? = null

    fun inorder() {
        if (root == null) return
        val s = Stack<Node>()
        var curr = root

        // traverse the tree
        while (curr != null || s.size > 0) {

            /* Reach the left most Node of the
            curr Node */
            while (curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr)
                curr = curr.left
            }

            /* Current must be NULL at this point */curr = s.pop()
            print(curr.data.toString() + " ")

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */curr = curr.right
            println(curr)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            /* creating a binary tree and entering
        the nodes */
            val tree = BinaryTreeGFG()
            tree.root = Node(1)
            tree.root!!.left = Node(2)
            tree.root!!.right = Node(3)
            tree.root!!.left?.left = Node(4)
            tree.root!!.left?.right = Node(5)
            tree.inorder()
        }
    }
}