import java.util.Iterator;
import java.util.Stack;
import java.util.Random;
import java.util.Vector;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinarySearchTree<Integer>();
        Random rand;
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 1;
        long start, stop;

        rand = new Random(1);
        System.out.print("insert: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            tree.insert(rand.nextInt(num));
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);

        rand = new Random(1);
        System.out.print("search: ");
        for (int i = 0; i < num; ++i) {
            if (!tree.search(rand.nextInt(num))) {
                System.out.println("Fail");
                break;
            }
        }
        for (Integer i : tree) {
            if (!tree.search(i)) {
                System.out.println("Fail");
                break;
            }
        }
        System.out.println("Pass");

        tree.remove(num + 1);

        rand = new Random(1);
        System.out.print("remove: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            tree.remove(rand.nextInt(num));
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);

        rand = new Random(1);
        System.out.print("search: ");
        for (int i = 0; i < num; ++i) {
            if (tree.search(rand.nextInt(num))) {
                System.out.println("Fail");
                break;
            }
        }
        System.out.println("Pass");

        System.out.println(tree.root == null);
    }


    public void insert(E data) {
        insert(root, data);
    }

    public Node insert(Node<E> curr, E key) {
        Node<E> temp = new Node<E>(key);
        if (curr == null) {
            curr = temp;
        } else if (key.compareTo(curr.data) < 0) {
            curr.left = insert(curr.left, key);
        } else if (key.compareTo(curr.data) > 0) {
            curr.right = insert(curr.right, key);
        }
        return curr;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Stack<Node<E>> stack = new Stack<>();

            public void pushLeft(Node<E> curr) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }

            public boolean hasNext() {
                return !stack.isEmpty();
            }

            public E next() {
                Node<E> p = stack.pop();
                Node<E> q = p.right;

                while (q != null) {
                    stack.push(q);
                    q = q.left;
                }
                return p.data;
            }
        };
    }

    public void remove(E data) {
        remove(root, data);
    }

    public Node remove(Node<E> curr, E key) {
        if (curr == null) {
            return null;
        }
        if (key.compareTo(curr.data) < 0) {
            curr.left = remove(curr.left, key);
        } else if (key.compareTo(curr.data) > 0) {
            curr.right = remove(curr.right, key);
        } else {
            if (curr.right == null && curr.left == null) {
                curr = null;
            }
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            }
            curr.data = newMin(curr.right);
            curr.right = remove(curr.right, curr.data);
        }
        return curr;
    }

    public E newMin(Node<E> curr) {
        E newMin = curr.data;
        while (curr.left != null) {
            newMin = curr.left.data;
            curr = curr.left;
        }
        return newMin;
    }

    public boolean search(E data) {
        return search(root, data);
    }

    public boolean search(Node<E> curr, E data) {
        if (curr != null) {
            if (data.compareTo(curr.data) == 0) {
                return true;
            }

            if (data.compareTo(curr.data) < 0) {
                return search(curr.left, data);
            }
            if (data.compareTo(curr.data) > 0) {
                return search(curr.right, data);
            }

        }
        return false;
    }


}







