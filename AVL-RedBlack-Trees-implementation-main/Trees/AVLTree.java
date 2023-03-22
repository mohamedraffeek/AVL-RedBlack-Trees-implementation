package Trees;

public class AVLTree<K extends Comparable<K>> implements ITree<K> {

    // attributes
    private int size = 0;
    private AVLNode<K> root;
    private AVLNode<K> lastDeletedNode = new AVLNode<K>(null, null, null, null);
    private boolean deletionDone = false;

    // constructor
    public AVLTree(K value) {
        root = new AVLNode<K>(value, null, null, null);
        size = 1;
        System.out.println("Tree created and value " + value + " is added");
    }

    public AVLTree() {
        root = null;
    }

    // getters and setters
    public AVLNode<K> getRoot() {
        return root;
    }

    public AVLNode<K> getLastDeletedNode() {
        return lastDeletedNode;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getHeight() {
        if (root != null)
            return root.getHeight();
        else
            return 0;
    }

    // start insert
    // increment hights after insert
    private void incHeights(AVLNode<K> node) {
        boolean test = false;
        if (node.getKey().equals(12))
            test = true;
        AVLNode<K> p = node.getParent();
        while (p != null) {
            int h1 = heightUtil(p.getLeft());
            int h2 = heightUtil(p.getRight());
            if (test) {
            }
            p.setHeight(Math.max(h1, h2) + 1);

            p = p.getParent();
        }
    }

    // determine the first node having the problem
    private AVLNode<K> getFirstUnBalance(AVLNode<K> node) {
        while (node != null) {
            if (Math.abs(heightUtil(node.getLeft()) - heightUtil(node.getRight())) > 1) {
                break;
            } else
                node = node.getParent();
        }
        return node;
    }

    // determine ll, rr, rl, lr
    private int getPath(AVLNode<K> node) {
        int ans = 0;
        AVLNode<K> temp;
        if (heightUtil(node.getLeft()) > heightUtil(node.getRight())) {
            temp = node.getLeft();
            ans = 10;
        } else
            temp = node.getRight();
        if (heightUtil(temp.getLeft()) > heightUtil(temp.getRight()))
            ans += 1;
        return ans;
    }

    // rotate for 4 cases
    private void rotates(int n, AVLNode<K> node) {
        switch (n) {
            // ll
            case 11:
                rightRotate(node);
                break;
            // rr
            case 0:
                leftRotate(node);
                break;
            // lr
            case 10:
                leftRotate(node.getLeft());
                rightRotate(node);
                break;
            // rl
            case 1:
                rightRotate(node.getRight());
                leftRotate(node);
            default:
                break;
        }
    }

    @Override
    public String insert(K key) {
        AVLNode<K> currentNode = searchRecursion(root, key);
        if (size == 0) {
            this.root = new AVLNode<K>(key, null, null, null);
            size++;
            return key + " added successfully";
        }
        if (currentNode.getKey().compareTo(key) == 0)
            return key + " already exists";
        else {
            size++;
            AVLNode<K> newNode = new AVLNode<K>(key, null, null, currentNode);
            if (currentNode.getKey().compareTo(key) < 0) {
                currentNode.setRight(newNode);
            } else {
                currentNode.setLeft(newNode);
            }
            incHeights(newNode);
            AVLNode<K> first = getFirstUnBalance(newNode);

            if (first != null)
                rotates(getPath(first), first);
            incHeights(newNode);
            return key + " added successfully";
        }
    }

    // end insert

    // start delete
    // override the implemented method and call the recursive one
    @Override
    public String delete(K value) {
        AVLNode<K> temp = root;
        int sizeChecker = size;
        deleteRecursion(temp, value, deletionDone);
        if (sizeChecker > size)
            return value + " deleted successfully";
        else
            return value + " not found";
    }

    private AVLNode<K> deleteRecursion(AVLNode<K> root, K value, boolean deletionDone) {

        // first: we perform normal BST deletion

        if (root == null)
            return root; // nothing to delete
        int found = root.getKey().compareTo(value); // found: -ve if key < value, +ve if key > value, 0 if key = value
        if (found < 0) {
            root.setRight(deleteRecursion(root.getRight(), value, deletionDone));
            if (root.getRight() != null)
                root.getRight().setParent(root);
        } else if (found > 0) {
            root.setLeft(deleteRecursion(root.getLeft(), value, deletionDone));
            if (root.getLeft() != null)
                root.getLeft().setParent(root);
        } else if (found == 0 && size == 1) { // tree has only one node
            size = 0;
            lastDeletedNode = root;
            this.root = null;
            return null;
        } else {
            if (root.getLeft() == null && root.getRight() == null) { // no children
                if (!deletionDone)
                    lastDeletedNode = root;
                else
                    deletionDone = false;
                root = null;
                size--;
            } else if (root.getLeft() == null || root.getRight() == null) { // only one child
                if (!deletionDone)
                    lastDeletedNode = root;
                else
                    deletionDone = false;
                AVLNode<K> temp = root.getParent();
                if (root.getLeft() != null) {
                    root = root.getLeft();
                } else {
                    root = root.getRight();
                }
                root.setParent(temp);
                if (temp == null) {
                    this.root = root;
                }
                size--;
            } else { // two children
                AVLNode<K> temp = root.getRight();
                while (temp.getLeft() != null)
                    temp = temp.getLeft(); // get the inorder successor
                lastDeletedNode.setKey(value);
                lastDeletedNode.setLeft(root.getLeft());
                lastDeletedNode.setRight(root.getRight());
                lastDeletedNode.setParent(root.getParent());
                deletionDone = true;
                root.setKey(temp.getKey()); // swap the deleted key with the successor's key
                root.setRight(deleteRecursion(root.getRight(), temp.getKey(), deletionDone)); // delete the successor
                if (root.getRight() != null)
                    root.getRight().setParent(root);
            }
        }
        // after finishing the recursive calls,
        // return a null node if the deleted node was the root of its own recursive call
        if (root == null)
            return root;

        // second: update heights and check for balance

        root.setHeight(1 + max(heightUtil(root.getLeft()), heightUtil(root.getRight())));
        int balance = getBalance(root);
        if (balance > 1) { // case 1 (left)
            int subBalance1 = getBalance(root.getLeft());
            if (subBalance1 >= 0) { // case 1.1 (left left)
                root = rightRotate(root);
            } else if (subBalance1 < 0) { // case 1.2 (left right)
                root.setLeft(leftRotate(root.getLeft()));
                root = rightRotate(root);
            }
        } else if (balance < -1) { // case 2 (right)
            int subBalance2 = getBalance(root.getRight());
            if (subBalance2 >= 0) { // case 2.1 (right left)
                root.setRight(rightRotate(root.getRight()));
                root = leftRotate(root);
            } else if (subBalance2 < 0) { // case 2.2 (right right)
                root = leftRotate(root);
            }
        }
        return root;
    }
    // end delete

    // start search
    private AVLNode<K> searchRecursion(AVLNode<K> currentNode, K value) {
        if (currentNode == null) {
            return null;
        }
        int found = currentNode.getKey().compareTo(value);
        if (found < 0) {
            if (currentNode.getRight() != null)
                return searchRecursion(currentNode.getRight(), value);
            else
                return currentNode;
        } else if (found > 0) {
            if (currentNode.getLeft() != null)
                return searchRecursion(currentNode.getLeft(), value);
            else
                return currentNode;
        } else
            return currentNode;
    }

    public String search(K value) {
        AVLNode<K> temp = root;
        if (temp != null && searchRecursion(temp, value).getKey().equals(value)) {
            return value + " found";
        } else
            return value + " not found";
    }
    // end search

    /* --------Utils-------- */

    private int max(int leftHeight, int rightHeight) {
        if (leftHeight >= rightHeight)
            return leftHeight;
        else
            return rightHeight;
    }

    private int heightUtil(AVLNode<K> node) {
        if (node == null)
            return 0;
        else
            return node.getHeight();
    }

    private int getBalance(AVLNode<K> node) {
        if (node == null)
            return 0;
        else
            return heightUtil(node.getLeft()) - heightUtil(node.getRight());
    }

    private AVLNode<K> rightRotate(AVLNode<K> currentNode) {
        AVLNode<K> temp1 = currentNode.getLeft();
        AVLNode<K> temp2 = temp1.getRight();
        AVLNode<K> temp3 = currentNode.getParent();
        // rotate around currentNode
        temp1.setRight(currentNode);
        if (temp3 == null) {
            this.root = temp1;
            temp1.setParent(null);
        } else {
            temp1.setParent(temp3);
            if (temp3.getLeft() == currentNode) {
                temp3.setLeft(temp1);
            } else {
                temp3.setRight(temp1);
            }
        }
        currentNode.setParent(temp1);
        if (temp2 == null)
            currentNode.setLeft(null);
        else {
            currentNode.setLeft(temp2);
            temp2.setParent(currentNode);
        }
        // update heights for currentNode and temp1
        currentNode.setHeight(1 + max(heightUtil(currentNode.getLeft()), heightUtil(currentNode.getRight())));
        temp1.setHeight(1 + max(heightUtil(temp1.getLeft()), heightUtil(temp1.getRight())));
        return temp1;
    }

    private AVLNode<K> leftRotate(AVLNode<K> currentNode) {
        AVLNode<K> temp1 = currentNode.getRight();
        AVLNode<K> temp2 = temp1.getLeft();
        AVLNode<K> temp3 = currentNode.getParent();
        // rotate around currentNode
        temp1.setLeft(currentNode);
        if (temp3 == null) {
            this.root = temp1;
            temp1.setParent(null);
        } else {
            temp1.setParent(temp3);
            if (temp3.getLeft() == currentNode) {
                temp3.setLeft(temp1);
            } else {
                temp3.setRight(temp1);
            }
        }
        currentNode.setParent(temp1);
        if (temp2 == null)
            currentNode.setRight(null);
        else {
            currentNode.setRight(temp2);
            temp2.setParent(currentNode);
        }
        // update heights for currentNode and temp1
        currentNode.setHeight(1 + max(heightUtil(currentNode.getLeft()), heightUtil(currentNode.getRight())));
        temp1.setHeight(1 + max(heightUtil(temp1.getLeft()), heightUtil(temp1.getRight())));
        return temp1;
    }

    public void printInorder(AVLNode<K> node) {
        if (node == null)
            return;
        printInorder(node.getLeft());
        if (node == root)
            System.out.print("*");
        System.out.print(node.getKey() + " ");
        printInorder(node.getRight());
    }

    // overload
    public void printInorder() {
        if (size == 0) {
            System.out.println("Empty tree");
        }
        printInorder(root);
        System.out.println();
    }
}
