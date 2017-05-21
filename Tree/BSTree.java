import com.sun.org.apache.bcel.internal.generic.IFNULL;

/**
 * Created by Gen on 5/20/17.
 */
public class BSTree<AnyType extends Comparable<? super AnyType>> {
    private static class BinaryNode<AnyType> {
        //constructor
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }
        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }

    private BinaryNode<AnyType> root;

    public BSTree() {
        root = null;
    }
    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * Find an item in a subtree
     * @param x the item to search for
     * @param t the root node of subtree
     * @return true if found; false otherwise
     */
    public boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        }
        else if (compareResult > 0) {
            return contains(x, t.right);
        }
        else {
            return true;
        }
    }



    public AnyType findMin() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return findMin(root).element;
    }

    /**
     * find the minimum item
     * @param t root of subtree
     * @return node containing smallest item
     */

    public BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        }
        else if (t.left == null){
            return t;
        }
        else return findMin(t.left);

    }
    public AnyType findMax() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return findMax(root).element;
    }

    public BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        }
        else if (t.right == null){
            return t;
        }
        else return findMin(t.right);
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<AnyType>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return insert(x, t.left);
        }
        else if (compareResult > 0) {
            return insert(x, t.right);
        }
        else {
            return t;
        }


    }
    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        return null;
        //TODO
    }

    public static void main(String[] args) {

        System.out.println("hello world");
    }


}
