package Trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTest {

    // initialize objects;
    AVLTree<Double> avlNum = new AVLTree<Double>();
    AVLTree<Integer> avlInt = new AVLTree<Integer>();
    RedBlack<Integer> rb = new RedBlack<Integer>();
    Dictionary dicAvl = new Dictionary("avl");
    Dictionary dicRb = new Dictionary("red-black");

    // start avl test
    /////////////////////////////////////////
    @Test
    // insert one element and find it
    public void test1_avl_numbers() {
        assertEquals(0, avlNum.getHeight());
        assertEquals(0, avlNum.getSize());
        assertEquals("5.5 added successfully", avlNum.insert(5.5));
        assertEquals(1, avlNum.getHeight());
        assertEquals(1, avlNum.getSize());
        assertEquals("5.5 found", avlNum.search(5.5));
        assertEquals(1, avlNum.getHeight());
        assertEquals(1, avlNum.getSize());
    }

    @Test
    // insert one element and delete it
    public void test2_avl_numbers() {
        assertEquals("5.5 added successfully", avlNum.insert(5.5));
        assertEquals(1, avlNum.getHeight());
        assertEquals(1, avlNum.getSize());
        assertEquals("5.5 deleted successfully", avlNum.delete(5.5));
        assertEquals(0, avlNum.getHeight());
        assertEquals(0, avlNum.getSize());
    }

    @Test
    // search and delete in empty tree
    public void test3_avl_numbers() {
        assertEquals("5.5 not found", avlNum.search(5.5));
        assertEquals(0, avlNum.getHeight());
        assertEquals(0, avlNum.getSize());
        assertEquals("5.5 not found", avlNum.delete(5.5));
        assertEquals(0, avlNum.getHeight());
        assertEquals(0, avlNum.getSize());
    }

    @Test
    // insert an existing element
    public void test4_avl_numbers() {
        assertEquals("5.5 added successfully", avlNum.insert(5.5));
        assertEquals("5.0 added successfully", avlNum.insert(5.0));
        assertEquals("5.5 already exists", avlNum.insert(5.5));
        assertEquals(2, avlNum.getHeight());
        assertEquals(2, avlNum.getSize());
    }

    @Test
    // insert in a decreasing order to check rotate right (LL case)
    public void test5_avl_numbers() {
        assertEquals("10.5 added successfully", avlNum.insert(10.5));
        assertEquals("5.9 added successfully", avlNum.insert(5.9));
        assertEquals("3.0 added successfully", avlNum.insert(3.0));
        assertEquals(2, avlNum.getHeight());
        assertEquals(3, avlNum.getSize());
    }

    @Test
    // most of rotate cases in one tree
    // insert exits element after a time and not root
    public void test6_avl_int() {
        assertEquals("5 added successfully", avlInt.insert(5));
        assertEquals("10 added successfully", avlInt.insert(10));
        assertEquals("15 added successfully", avlInt.insert(15));
        assertEquals(3, avlInt.getSize());
        assertEquals(2, avlInt.getHeight());
        // RR case
        assertEquals("13 added successfully", avlInt.insert(13));
        assertEquals("14 added successfully", avlInt.insert(14));
        assertEquals(5, avlInt.getSize());
        assertEquals(3, avlInt.getHeight());
        // LR case
        assertEquals("12 added successfully", avlInt.insert(12));
        // RL case
        assertEquals(6, avlInt.getSize());
        assertEquals(3, avlInt.getHeight());
        // insert exits element after a time and not root
        assertEquals("10 already exists", avlInt.insert(10));
        assertEquals(6, avlInt.getSize());
        assertEquals(3, avlInt.getHeight());
    }

    @Test
    // big tree all rotation
    // delete leaf, inner with rotate and two children
    public void test7_avl_int() {
        assertEquals("5 added successfully", avlInt.insert(5));
        assertEquals("10 added successfully", avlInt.insert(10));
        assertEquals("15 added successfully", avlInt.insert(15));
        assertEquals(3, avlInt.getSize());
        assertEquals(2, avlInt.getHeight());
        // RR case for root
        assertEquals("4 added successfully", avlInt.insert(4));
        assertEquals("6 added successfully", avlInt.insert(6));
        assertEquals("2 added successfully", avlInt.insert(2));
        assertEquals(6, avlInt.getSize());
        assertEquals(3, avlInt.getHeight());
        // ll case for root
        assertEquals("3 added successfully", avlInt.insert(3));
        assertEquals(7, avlInt.getSize());
        assertEquals(3, avlInt.getHeight());
        // LR case for non root node
        assertEquals("7 added successfully", avlInt.insert(7));
        assertEquals("9 added successfully", avlInt.insert(9));
        assertEquals(9, avlInt.getSize());
        assertEquals(4, avlInt.getHeight());
        // RR case for non root node
        assertEquals("8 added successfully", avlInt.insert(8));
        // RL case for non root nde
        assertEquals(10, avlInt.getSize());
        assertEquals(4, avlInt.getHeight());
        assertEquals("10 deleted successfully", avlInt.delete(10));
        assertEquals(9, avlInt.getSize());
        assertEquals(4, avlInt.getHeight());
        // delete with one child
        assertEquals("15 deleted successfully", avlInt.delete(15));
        assertEquals(8, avlInt.getSize());
        assertEquals(4, avlInt.getHeight());
        // delete no child with rotate
        assertEquals("7 deleted successfully", avlInt.delete(7));
        assertEquals(7, avlInt.getSize());
        assertEquals(3, avlInt.getHeight());
        // delete two children and rotate
        assertEquals("5 deleted successfully", avlInt.delete(5));
        assertEquals(6, avlInt.getSize());
        assertEquals(3, avlInt.getHeight());
        // delete root has two chilren
    }

    @Test
    // insert then delete untill empty then insert again
    public void test8_avl_int() {
        assertEquals("5 added successfully", avlInt.insert(5));
        assertEquals("10 added successfully", avlInt.insert(10));
        assertEquals(2, avlInt.getSize());
        assertEquals(2, avlInt.getHeight());
        assertEquals("10 deleted successfully", avlInt.delete(10));
        assertEquals("5 deleted successfully", avlInt.delete(5));
        assertEquals(0, avlInt.getSize());
        assertEquals(0, avlInt.getHeight());
        assertEquals("7 added successfully", avlInt.insert(7));
        assertEquals("3 added successfully", avlInt.insert(3));
        assertEquals(2, avlInt.getSize());
        assertEquals(2, avlInt.getHeight());
    }
    // end avl test
    /////////////////////////////////////////

    // start red black test
    /////////////////////////////////////////
    @Test
    // insert and serch for one element
    public void test9_rb_int() {
        assertEquals(0, rb.getHeight());
        assertEquals(0, rb.getSize());
        assertEquals("5 added successfully B", rb.insert(5));
        assertEquals(1, rb.getHeight());
        assertEquals(1, rb.getSize());
        assertEquals("5 found", rb.search(5));
        assertEquals(1, rb.getHeight());
        assertEquals(1, rb.getSize());
    }

    @Test
    // add and delete one element
    public void test10_rb_int() {
        assertEquals("5 added successfully B", rb.insert(5));
        assertEquals(1, rb.getHeight());
        assertEquals(1, rb.getSize());
        assertEquals("5 deleted successfully", rb.delete(5));
        assertEquals(0, rb.getHeight());
        assertEquals(0, rb.getSize());
    }

    @Test
    // add two elements
    public void test11_rb_int() {
        assertEquals("3 added successfully B", rb.insert(3));
        assertEquals("7 added successfully R", rb.insert(7));
        assertEquals(2, rb.getHeight());
        assertEquals(2, rb.getSize());
    }

    // insert existing element
    @Test
    public void test12_rb_int() {
        assertEquals("3 added successfully B", rb.insert(3));
        assertEquals("3 already exists", rb.insert(3));
    }

    // search and delete empty tree
    @Test
    public void test13_rb_int() {
        assertEquals("15 not found", rb.search(15));
        assertEquals("15 not found", rb.delete(15));
        assertEquals(0, rb.getHeight());
        assertEquals(0, rb.getSize());
    }

    // insert case parent and uncle are red, grandparent not root
    @Test
    public void test14_rb_int() {
        assertEquals("4 added successfully B", rb.insert(4));
        assertEquals("23 added successfully R", rb.insert(23));
        assertEquals("27 added successfully R", rb.insert(27));
        assertEquals("29 added successfully R", rb.insert(29));
        assertEquals("26 added successfully R", rb.insert(26));
        assertEquals("24 added successfully R", rb.insert(24));
        assertEquals(4, rb.getHeight());
        assertEquals(6, rb.getSize());
        // rb.printInorder();
    }

    @Test
    // grandparent is black, uncle is nil, parent is red
    // child inserted right of parent
    public void test15_rb_int() {
        assertEquals("5 added successfully B", rb.insert(5));
        assertEquals("40 added successfully R", rb.insert(40));
        assertEquals("35 added successfully B", rb.insert(35));
        assertEquals("38 added successfully R", rb.insert(38));
        assertEquals("39 added successfully B", rb.insert(39));
        assertEquals(3, rb.getHeight());
    }

    @Test
    // u or v are red
    public void test16_rb_int() {
        assertEquals("5 added successfully B", rb.insert(5));
        assertEquals("10 added successfully R", rb.insert(10));
        assertEquals("15 added successfully R", rb.insert(15));
        assertEquals("20 added successfully R", rb.insert(20));
        assertEquals("20 deleted successfully", rb.delete(20));
        assertEquals(2, rb.getHeight());
    }

    @Test
    // not wrking
    public void test17_rb_int() {
        assertEquals("10 added successfully B", rb.insert(10));
        assertEquals("15 added successfully R", rb.insert(15));
        assertEquals("20 added successfully R", rb.insert(20));
        assertEquals("25 added successfully R", rb.insert(25));
        assertEquals("10 deleted successfully", rb.delete(10));
        assertEquals(2, rb.getHeight());
        assertEquals("8 added successfully R", rb.insert(8));
        assertEquals("25 deleted successfully", rb.delete(25));
        assertEquals(2, rb.getHeight());
        rb.printInorder();
    }

    @Test
    // u and v are black, uncle is black, one child of uncle is red
    // LR
    public void test18_rb_int() {
        assertEquals("10 added successfully B", rb.insert(10));
        assertEquals("12 added successfully R", rb.insert(12));
        assertEquals("14 added successfully R", rb.insert(14));
        assertEquals("11 added successfully R", rb.insert(11));
        assertEquals("14 deleted successfully", rb.delete(14));
        assertEquals(2, rb.getHeight());
        rb.printInorder();
    }

    @Test
    // u and v are black, uncle is black, one child of uncle is red
    // RL
    public void test19_rb_int() {
        assertEquals("10 added successfully B", rb.insert(10));
        assertEquals("15 added successfully R", rb.insert(15));
        assertEquals("18 added successfully R", rb.insert(18));
        assertEquals("17 added successfully R", rb.insert(17));
        assertEquals("10 deleted successfully", rb.delete(10));
        assertEquals(2, rb.getHeight());
    }

    @Test
    // u, v, uncle and its children are black
    // recursion case
    public void test20_rb_int() {
        assertEquals(1 + " added successfully B", rb.insert(1));
        for (int i = 2; i <= 10; i++) {
            assertEquals(i + " added successfully R", rb.insert(i));
        }
        assertEquals("8 deleted successfully", rb.delete(8));
        assertEquals("10 deleted successfully", rb.delete(10));
        assertEquals("7 deleted successfully", rb.delete(7));
        assertEquals("2 deleted successfully", rb.delete(2));
        assertEquals(3, rb.getHeight());
    }

    @Test
    // u and v are black, uncle is red, right case
    public void test21_rb_int() {
        assertEquals(1 + " added successfully B", rb.insert(1));
        for (int i = 2; i <= 6; i++) {
            assertEquals(i + " added successfully R", rb.insert(i));
        }
        assertEquals("1 deleted successfully", rb.delete(1));
        assertEquals(3, rb.getHeight());
    }

    @Test
    // u and v are black, uncle is red, left case
    public void test22_rb_int() {
        assertEquals(6 + " added successfully B", rb.insert(6));
        for (int i = 5; i <= 1; i--) {
            assertEquals(i + " added successfully R", rb.insert(i));
        }
        assertEquals("6 deleted successfully", rb.delete(6));
        assertEquals(0, rb.getHeight());
        rb.printInorder();
    }

    // end red black test
    /////////////////////////////////////////

    // start dictionary avl
    ////////////////////////////////////////

    // RR and RL cases in dictionary
    // insert twice
    // delte not exists
    @Test
    public void test23_dic_avl() {
        assertEquals("abdo added successfully", dicAvl.insert("abdo"));
        assertEquals("ahmed added successfully", dicAvl.insert("ahmed"));
        assertEquals("hassan added successfully", dicAvl.insert("hassan"));
        // insert twice
        assertEquals("hassan already exists", dicAvl.insert("hassan"));
        assertEquals("Dictionary size is 3", dicAvl.getSize());
        assertEquals("Dictionary height is 2", dicAvl.getHeight());
        // RR case for root
        assertEquals("raffek added successfully", dicAvl.insert("raffek"));
        assertEquals("magdy added successfully", dicAvl.insert("magdy"));
        // RL case for not root
        assertEquals("Dictionary size is 5", dicAvl.getSize());
        assertEquals("Dictionary height is 3", dicAvl.getHeight());
        // delete not exists
        assertEquals("ali not found", dicAvl.delete("ali"));
    }

    @Test
    // search and delete in empty dictionary
    public void test24_dic_avl() {
        assertEquals("aloo not found", dicAvl.search("aloo"));
        assertEquals("aloo not found", dicAvl.delete("aloo"));
    }

    @Test
    public void test25_dic_rb() {
        assertEquals("adibeuo added successfully B", dicRb.insert("adibeuo"));
        assertEquals("baiodja added successfully R", dicRb.insert("baiodja"));
        assertEquals("daondiow added successfully R", dicRb.insert("daondiow"));
        assertEquals("enioaa added successfully R", dicRb.insert("enioaa"));
        assertEquals("christa added successfully R", dicRb.insert("christa"));
        assertEquals("Dictionary height is 3", dicRb.getHeight());
    }

    @Test
    public void test26_dic_rb() {
        assertEquals("armin added successfully B", dicRb.insert("armin"));
        assertEquals("tomioka added successfully R", dicRb.insert("tomioka"));
        assertEquals("bertourltoro added successfully B", dicRb.insert("bertourltoro"));
        assertEquals("cali added successfully R", dicRb.insert("cali"));
        assertEquals("denji added successfully B", dicRb.insert("denji"));
        assertEquals("Dictionary height is 3", dicRb.getHeight());
    }

    @Test
    public void test27_rb_int() {
        assertEquals("ahmed added successfully B", dicRb.insert("ahmed"));
        assertEquals("basyouni added successfully R", dicRb.insert("basyouni"));
        assertEquals("emad added successfully R", dicRb.insert("emad"));
        assertEquals("farook added successfully R", dicRb.insert("farook"));
        assertEquals("daki added successfully R", dicRb.insert("daki"));
        assertEquals("cannons added successfully R", dicRb.insert("cannons"));
        assertEquals("Dictionary height is 4", dicRb.getHeight());
    }
    ////////////////////////////////////////
    // end dictionary avl

}
