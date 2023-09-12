/**
 * From CSE017 lecture 9 slide deck; 
 * 2023-06-21
 */

 public class BST<E extends Comparable<E>> {
    private TreeNode root;
    private int size;

    private class TreeNode {
        E value;
        TreeNode left;
        TreeNode right;

        TreeNode(E val) {
            value = val;
            left = right = null;
        }
    }

    BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void clear() {
        root = null;
    }

    // Search method
    public boolean contains(E value) {
        TreeNode node = root;
        while (node != null) {
            if (value.compareTo(node.value) < 0)
                node = node.left;
            else if (value.compareTo(node.value) > 0)
                node = node.right;
            else
                return true;
        }
        return false;
    }

    // Method add()
    public boolean add(E value) {
        if (root == null) // first node to be inserted
            root = new TreeNode(value);
        else {
            TreeNode parent, node;
            parent = null;
            node = root;
            while (node != null) {// Looking for a leaf node
                parent = node;
                if (value.compareTo(node.value) < 0) {
                    node = node.left;
                } else if (value.compareTo(node.value) > 0) {
                    node = node.right;
                } else
                    return false; // duplicates are not allowed
            }
            if (value.compareTo(parent.value) < 0)
                parent.left = new TreeNode(value);
            else
                parent.right = new TreeNode(value);
        }
        size++;
        return true;
    }

    // Method remove()
    public boolean remove(E value) {
        TreeNode parent, node;
        parent = null;
        node = root;
        // Find value first
        while (node != null) {
            if (value.compareTo(node.value) < 0) {
                parent = node;
                node = node.left;
            } else if (value.compareTo(node.value) > 0) {
                parent = node;
                node = node.right;
            } else
                break; // value found
        }

        if (node == null) // value not in the tree
            return false;

        // Case 1: node has no children
        if (node.left == null && node.right == null) {
            if (parent == null) { // delete root
                root = null;
            } else {
                changeChild(parent, node, null);
            }
        }

        // case 2: node has one right child
        else if (node.left == null) {
            if (parent == null) { // delete root
                root = node.right;
            } else {
                changeChild(parent, node, node.right);
            }
        }
        // case 2: node has one left child
        else if (node.right == null) {
            if (parent == null) { // delete root
                root = node.left;
            } else {
                changeChild(parent, node, node.left);
            }
        }

        // case 3: node has two children
        else {
            TreeNode rightMostParent = node;
            TreeNode rightMost = node.left;
            // go right on the left subtree
            while (rightMost.right != null) {
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
            // copy the value of rigthMost to node
            node.value = rightMost.value;
            // delete rigthMost
            changeChild(rightMostParent, rightMost,
                    rightMost.left);
        }
        size--;
        return true;
    }

    private void changeChild(TreeNode parent,
            TreeNode node, TreeNode newChild) {
        if (parent.left == node)
            parent.left = newChild;
        else
            parent.right = newChild;
    }

    // Recursive method inorder()
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    // Recursive method preorder()
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Recursive method postorder()
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Testing the class BST
    public static void main1(String[] args) {
        BST<String> bst = new BST<>();
        // insert elements in an arbitrary order
        bst.add("Kiwi");
        bst.add("Strawberry");
        bst.add("Apple");
        bst.add("Banana");
        bst.add("Orange");
        bst.add("Lemon");
        bst.add("Watermelon");
        bst.inorder(); // L, V, R
        bst.remove("Banana");
        System.out.println(bst.contains("Banana"));
        bst.inorder();
        bst.remove("Orange");
        bst.inorder();
        bst.remove("Kiwi");
        bst.inorder();
    }

    // Testing the class BST
    public static void main2(String[] args) {
        BST<String> bst = new BST<>();
        // insert elements in an totally ordered fashion (alphabetically)
        bst.add("Apple");
        bst.add("Banana");
        bst.add("Kiwi");
        bst.add("Lemon");
        bst.add("Orange");
        bst.add("Strawberry");
        bst.add("Watermelon");
        bst.inorder();
    }

    public static void main(String[] args){
        // main1(args);
        main2(args);
    }
}
