package DS.tree

import java.util.*

/**
 * Reference -: Baeldung
 */
class BinaryTree {

    /**
     * Root Node.
     */
    private var root: Node? = null
        get() = field

    /**
     * Adds element to Tree recursively
     *
     *
     * Ref : https://www.studytonight.com/post/insertion-adding-a-new-node-in-a-binary-tree-data-structure
     *
     * @param current
     * @param value
     */
    private fun addRecursive(current: Node?, value: Int): Node {

        //If the current is null then create the node
        if (current == null) {
            return Node(value)
        }

        //If left of the node is null then add it to the left side.
        if (current.left == null) {
            val newNode = Node(value)
            current.left = newNode
        } else if (current.right == null) {
            val newNode = Node(value)
            current.right = newNode
        } else {
            addRecursive(current.left, value)
        }

        //Add a recursive call to add the number down in the left subtree.
        return current

    }

    /**
     * Adds the element to the tree.
     */
    fun add(value: Int) {
        root = addRecursive(root, value)
    }


    /** TRAVERSAL ALGORITHMS */


    /**
     * Pre-Order Traversal Recursive solution (DLR)
     *
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    private fun preOrderTraversalRecursive(root: Node?) {

        if (root != null) {
            println(root.value)
            preOrderTraversalRecursive(root.left)
            preOrderTraversalRecursive(root.right)
        }

    }

    /**
     * Recursive Solution : Post order traversal of Binary Tree (LRD)
     *
     */
    private fun postOrderTraversalRecursive(root: Node?) {

        if (root != null) {
            postOrderTraversalRecursive(root.left)
            postOrderTraversalRecursive(root.right)
            println(root.value)
        }

    }


    /**
     * Post Order Traversal Non Recursive
     */
    private fun postOrderTraversalNonRecursive(root: Node?) {

        //Set the current as the root.
        var current = root

        //Make the stack using the Linked List this time.
        val stackOfNodes: Deque<Node> = LinkedList<Node>()

        while (current != null || stackOfNodes.isNotEmpty()) {


            if (current != null) {

                stackOfNodes.addFirst(current)
                current = current.left


            } else {

                //It means that we need to check the right side of the node.
                //0. Seeing the right side of the node
                var temp: Node? = stackOfNodes.peek().right

                //1. If the right side of the node is null then it means that it is a leaf node.
                if (temp == null) {
                    //2. Pop & Print the node
                    temp = stackOfNodes.poll()

                    println((temp as Node).value)

                    //3. Check whether popped element is right of element on top of the stack
                    while (stackOfNodes.isNotEmpty() && temp == stackOfNodes.peek().right) {

                        //It means that we can visit the top of the stack also as right subtree is covered.
                        temp = stackOfNodes.poll()
                        println((temp as Node).value)

                    }

                } else {

                    //4. There is still right subtree to explore
                    current = temp
                }


            }


        }

    }


    /**
     * Recursive Solution : In order traversal of Binary Tree (LRD)
     */
    private fun inOrderTraversalRecursive(root: Node?) {

        if (root != null) {
            inOrderTraversalRecursive(root.left)
            println(root.value)
            inOrderTraversalRecursive(root.right)
        }

    }


    /**
     * Pre-Order traversal of a tree without using recursion
     * Iterative solution -  DLR
     *
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     *
     * Ref : Karumanchi
     */
    private fun preOrderNonRecursiveTraversal1(root: Node?) {

        var rootNode = root

        val stackOfNodes = Stack<Node>()

        while (true) {
            while (rootNode != null) {

                //Process the current Node.
                println(rootNode.value)

                //Push the root node to the stack
                stackOfNodes.push(rootNode)

                rootNode = rootNode.left

            }

            if (stackOfNodes.empty()) {
                break
            }

            val popedNode = stackOfNodes.pop()

            rootNode = popedNode.right

        }

        stackOfNodes.clear()

    }


    /**
     * Pre-Order traversal of a tree without using recursion
     * Iterative solution
     *
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     *
     * Ref : GFG -> {https://www.geeksforgeeks.org/iterative-preorder-traversal/}
     */
    private fun preOrderNonRecursiveTraversal2(root: Node?) {

        val rootNode = root

        val stackOfNodes = Stack<Node>()

        if (rootNode != null) {
            stackOfNodes.push(rootNode)

            //while stack is not empty
            while (stackOfNodes.isNotEmpty()) {

                //0. Pop the element and process it
                val popedNode = stackOfNodes.pop()
                println(popedNode.value)

                //1. Add the right element to the stack first
                if (popedNode.right != null) {
                    stackOfNodes.push(popedNode.right)
                }

                //2. Add the left element to the stack first
                if (popedNode.left != null) {
                    stackOfNodes.push(popedNode.left)
                }

            }

        }

        stackOfNodes.clear()
    }


    /**
     * Static inner class called Node
     */
    private class Node internal constructor(value: Int) {

        internal var value: Int? = null

        internal var left: Node? = null
        internal var right: Node? = null

        init {
            this.value = value
            left = null
            right = null
        }

    }


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val binaryTree = BinaryTree()
            binaryTree.add(6)
            binaryTree.add(4)
            binaryTree.add(8)
            binaryTree.add(3)
            binaryTree.add(5)
            binaryTree.add(7)
            binaryTree.add(9)

//            binaryTree.preOrderTraversalRecursive(binaryTree.root)

//            binaryTree.preOrderNonRecursiveTraversal1(binaryTree.root)

//            binaryTree.preOrderNonRecursiveTraversal2(binaryTree.root)

//            binaryTree.postOrderTraversalRecursive(binaryTree.root)

//            binaryTree.inOrderTraversalRecursive(binaryTree.root)

            binaryTree.postOrderTraversalNonRecursive(binaryTree.root)

        }

    }


}
