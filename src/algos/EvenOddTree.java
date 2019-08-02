package algos;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
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
        printLevelOrderTreeData(root);
        diffEvenOddNodesInBinaryTree(root);
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

    public static void diffEvenOddNodesInBinaryTree(Node root) {
        if (root == null)
            return;
        Queue queue = new LinkedList<Node>();
        queue.add(root);
        boolean oddPosition = true;
        int oddPositionSum = 0;
        int evenPositionSum = 0;

        while (!queue.isEmpty()) {
            Node node = (Node) queue.peek();
            queue.remove();
            if (oddPosition) {
                System.out.println("odd" + node.data + " ");
                oddPositionSum += node.data;
            } else {
                System.out.print("Even" + node.data + " ");
                evenPositionSum += node.data;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            oddPosition = !oddPosition;
        }

        System.out.println("OddPositionSum ==> " + oddPositionSum);
        System.out.println("EvenPoistionSum ==>" + evenPositionSum);
        System.out.println("Diff of odd and even potion sum ==>" + (oddPositionSum - evenPositionSum));
    }

}
