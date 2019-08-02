package algos;

import static java.lang.Math.max;

import java.util.LinkedList;
import java.util.Queue;

public class DaimeterTree {
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
        printLevelOrderTreeData(root);
        System.out.println("Daimeter ==> " + daimater(root));
        DaimeterTree daimeterTree = new DaimeterTree();
        System.out.println("Daimeter in o(n) -> " + daimeterTree.daimeterbyN(root));
    }

    public static void printLevelOrderTreeData(Node root) {
        if (root == null) {
            return;
        }

        Queue queue = new LinkedList<Node>();
        queue.add(root);
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                break;
            }
            int sum = 0;
            while (nodeCount > 0) {
                Node node = (Node) queue.peek();
                queue.remove();
                sum = sum + node.data;
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
            System.out.println();

        }

    }

    public static int daimater(Node root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldaimater = daimater(root.left);
        int rdaimeter = daimater(root.right);
        return max((1 + lheight + rheight), max(ldaimater, rdaimeter));
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + max(height(root.left), height(root.right));
    }

    class Height {
        int h;
    }

    public int daimeterbyN(Node root) {
        return daimaterinbyOrderOfN(root, new Height());
    }

    public int daimaterinbyOrderOfN(Node root, Height height) {
        if (root == null) {
            height.h = 0;
            return 0;
        }
        Height lh = new Height(), rh = new Height();
        int ldaimater = daimaterinbyOrderOfN(root.left, lh);
        int rdaimeter = daimaterinbyOrderOfN(root.right, rh);

        height.h = max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, max(ldaimater, rdaimeter));

    }

}
