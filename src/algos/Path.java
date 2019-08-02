package algos;

import java.util.ArrayList;

public class Path {

    public static void main(String[] args) {

        Node root = Node.createNode(1);
        Node a = Node.createNode(2);
        Node b = Node.createNode(3);
        Node c = Node.createNode(4);
        Node d = Node.createNode(5);
        Node e = Node.createNode(6);
        Node f = Node.createNode(7);
        Node g = Node.createNode(8);
        Node h = Node.createNode(9);
        Node i = Node.createNode(10);
        Node j = Node.createNode(11);
        Node k = Node.createNode(12);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = e;
        d.right = f;
        b.right = g;
        g.right = h;
        h.left = i;
        h.right = j;
        i.right = k;

        printPathByGivenNode(root, 7);
    }

    private static void printPathByGivenNode(Node root, int i) {

        ArrayList<Integer> strings = new ArrayList<>();

        if (hasPath(root, strings, i)) {

            for (Integer value : strings) {
                System.out.println(value);
            }
        } else {
            System.out.println("no Path");
        }
    }

    private static boolean hasPath(Node root, ArrayList<Integer> arrayList, int node) {

        if (root == null) {
            return false;
        }

        arrayList.add(root.data);

        if (root.data == node)
            return true;

        //if the
        if (hasPath(root.left, arrayList, node)
                || hasPath(root.right, arrayList, node)) {
            return true;
        }

        //remove the added value
        arrayList.remove(arrayList.size() - 1);
        return false;
    }
}
