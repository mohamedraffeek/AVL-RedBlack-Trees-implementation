package Trees;

public class RedBlack<K extends Comparable<K>> implements ITree<K> {

    RBNode<K> root;

    /*
     * root is black by default
     */
    public RedBlack() {
        this.root = new RBNode<>(null, 'B', null, null, null);
    }

    int size = 0;

    @Override
    public String insert(K key) {

        RBNode<K> node = new RBNode<>(key, 'R', null, null, null);

        if (key == null) {
            throw new RuntimeException("No key");
        }

        /* Insert to empty tree */
        if (size == 0) {
            node.setColor('B');
            node.setRight(new RBNode<>(null, 'B', null, null, null));
            node.setLeft(new RBNode<>(null, 'B', null, null, null));
            this.root = node;
            size++;
            return "Inserted to empty tree";
        }

        // n to find right place in the tree
        // node has the key value
        RBNode<K> parent = null;
        RBNode<K> current = this.root;
        while (current != null && !current.isNull()) {
            parent = current;
            if (current.getKey().compareTo(key) < 0) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        assert parent != null;

        node.setParent(parent);

        if (parent.getKey().compareTo(key) > 0) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }

        // set nil children to new node
        node.setLeft(new RBNode<K>(null, 'B', null, null, node));
        node.setRight(new RBNode<K>(null, 'B', null, null, node));
        fixThisTree(node);

        /*
         * increment size by one after each SUCCESSFUL insertion
         * getting size is O(1)
         */
        size++;
        return "Inserted Successfully " + node.color;

    }

    void fixThisTree(RBNode<K> node) {

        if (node.getParent().getColor() == 'B') {
            return;
        }
        /*
         * recursion from node to root
         */
        while (!node.getParent().isNull() && node.getParent().getColor() == 'R') {

            RBNode<K> gp = node.getParent().getParent();
            RBNode<K> u;

            // CASE 1 : parent is left child of grandparent
            if (node.getParent().equals(gp.getLeft())) {
                u = gp.getRight();
                if (u != null && !u.isNull() && u.getColor() == 'R') {
                    node.getParent().setColor('B');
                    u.setColor('B');
                    if (!gp.equals(root)) {
                        gp.setColor('R');
                        // recursive
                        node = gp;
                    }
                } else {
                    if (node.equals(node.getParent().getRight())) {
                        leftRotate(node.getParent());
                        node = node.getLeft();
                    }
                    node.getParent().setColor('B');
                    gp.setColor('R');
                    rightRotate(node.getParent().getParent());
                }
            }

            // CASE 2: parent is right child of grandparent (MIRROR CASE)
            else {
                u = gp.getLeft();
                if (u.getColor() == 'R') {
                    node.getParent().setColor('B');
                    u.setColor('B');
                    if (!gp.equals(root)) {
                        gp.setColor('R');
                        // recursive
                        node = gp;
                    }
                } else {
                    if (node.equals(node.getParent().getLeft())) {
                        rightRotate(node.getParent());
                        node = node.getRight();
                    }
                    node.getParent().setColor('B');
                    node.getParent().getParent().setColor('R');
                    leftRotate(node.getParent().getParent());
                }

            }

        }
        root.setColor('B');
    }

    void leftRotate(RBNode<K> node) {
        RBNode<K> temp = node.getRight();
        node.setRight(temp.getLeft());

        if (!temp.getLeft().isNull()) {
            temp.getLeft().setParent(node);
        }

        temp.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = temp;
        } else if (node.equals(node.getParent().getLeft())) {
            node.getParent().setLeft(temp);
        } else {
            node.getParent().setRight(temp);
        }
        temp.setLeft(node);
        node.setParent(temp);
    }

    void rightRotate(RBNode<K> node) {

        RBNode<K> temp = node.getLeft();

        node.setLeft(temp.getRight());

        // if (!temp.getRight().isNull()) {
        if (temp.getRight() != null) {
            temp.getRight().setParent(node);
        }

        temp.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = temp;
        } else if (node.equals(node.getParent().getLeft())) {
            node.getParent().setLeft(temp);
        } else {
            node.getParent().setRight(temp);
        }

        temp.setRight(node);
        node.setParent(temp);
    }

    @Override
    public String delete(K key) {

        if (key == null) {
            throw new RuntimeException("No key");
        }

        RBNode<K> node = this.search2(this.root, key);
        if(node == null){
            return "item not found";
        }
        deleteThis(node);
        size--;
        return "Deleted Successfully";
    }
    private void changePosition(RBNode<K> u, RBNode<K> v) {
        if(u.parent == null){
            root = v;
        }else if(u == u.parent.left){
            u.parent.left = v;
        }else{
            u.parent.right = v;
        }
        v.parent = u.parent;
    }
    public RBNode<K> findSucc(RBNode<K> node){
        while(node.left!= null && node.getLeft().key != null){
            node = node.left;
        }
        return node;
    }
    void deleteThis(RBNode<K> node) {
        RBNode<K> x,y;// = findSucc(v.left);
        y = node;
        char deletedNodeColor = node.color;
        if(node.left.key == null){//node has 1 right child
            x = node.right;
            changePosition(node,x);
        }else if(node.right.key == null){//node has 1 left child
            x = node.left;
            changePosition(node,x);
        }else{//node has 2 children
            y = findSucc(node.right);
            deletedNodeColor = y.color;
            x = y.right;
            if(node == y.parent){
                x.parent = y;
            }else{
                changePosition(y,x);
                y.right = node.right;
                y.right.parent = y;
            }
            changePosition(node, y);
            y.left = node.left;
            y.left.parent = y;
            y.color = node.color;
        }
        if (deletedNodeColor == 'B') {
            fixDelete(x);
        }
    }
    private void fixDelete(RBNode<K> x) {
        RBNode<K> s;
        while (x != root && x.color == 'B') {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 'R') {
                    s.color = 'B';
                    x.parent.color = 'R';
                    leftRotate(x.parent);
                    s = x.parent.right;
                }
                if (s.left.color == 'B' && s.right.color == 'B') {
                    s.color = 'R';
                    x = x.parent;
                } else {
                    if (s.right.color == 'B') {
                        s.left.color = 'B';
                        s.color = 'R';
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 'B';
                    s.right.color = 'B';
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 'R') {
                    s.color = 'B';
                    x.parent.color = 'R';
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 'B' && s.right.color == 'B') {
                    s.color = 'R';
                    x = x.parent;
                } else {
                    if (s.left.color == 'B') {
                        s.right.color = 'B';
                        s.color = 'R';
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    s.color = x.parent.color;
                    x.parent.color = 'B';
                    s.left.color = 'B';
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 'B';
    }
    // @Override
    public String search(K key) {
        if (search2(root, key) != null)
            return "Item Found";
        else
            return "Not found";
    }

    private RBNode<K> search2(RBNode<K> root, K key) {
        if (root == null || root.isNull()) {
            return null;
        }
        if (root.getKey().compareTo(key) == 0)
            return root;
        if (root.getKey().compareTo(key) > 0) {
            return search2(root.getLeft(), key);

        }
        if (root.getKey().compareTo(key) < 0) {
            return search2(root.getRight(), key);
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getHeight() {
        return height(root);
    }

    // O(n)
    private int height(RBNode<K> node) {
        // base case
        if (node == null || node.isNull()) {
            return 0;
        } else {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
<<<<<<< Updated upstream

    public void printInorder(RBNode<K> node) {
        if (node == null || node.isNull())
=======
    public void printInorder(RBNode<K> node) {
        if (node == null || node.getKey() == null)
>>>>>>> Stashed changes
            return;
        printInorder(node.getLeft());
        if (node == root)
            System.out.print("*");
<<<<<<< Updated upstream
        System.out.print(node.getKey() + " " + node.getColor() + " ");
        printInorder(node.getRight());
    }

    // overload
=======
        System.out.print(node.getKey() +" " + node.getColor() + " ");
        printInorder(node.getRight());
    }
>>>>>>> Stashed changes
    public void printInorder() {
        if (size == 0) {
            System.out.println("Empty tree");
        }
        printInorder(root);
        System.out.println();
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
