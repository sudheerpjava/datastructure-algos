package algos;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalTrees {
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
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        c.right = h;
        c.left = g;

        Node root1 = Node.createNode(1);
        root1.left = a;
        root1.right = c;

        printLevelOrderTreeData(root);
        System.out.println("==========================================");
        System.out.println(checkIdenticalTrees(root, root1));
    }

    private static boolean checkIdenticalTrees(Node root, Node root1) {
        if (root == null && root1 == null) {
            return true;
        } else if (root != null && root1 != null) {
            return root.data == root1.data
                    && checkIdenticalTrees(root.left, root1.left)
                    && checkIdenticalTrees(root.right, root1.right);
        } else {
            return false;
        }
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
            System.out.print("===> " + sum);
            System.out.println();

        }

    }

}
