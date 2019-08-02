package algos;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumLevel {

    public static void main(String[] args) {
        Node root = Node.createNode(1);
        Node a = Node.createNode(2);
        Node b = Node.createNode(3);
        Node c = Node.createNode(4);
        Node d = Node.createNode(5);
        Node e = Node.createNode(6);
        Node f = Node.createNode(7);
        /*Node g = Node.createNode(8);
        Node h = Node.createNode(9);*/
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        /*c.right = h;
        c.left = g;*/
        print(root);
        System.out.println();
        System.out.println("Height   " + height(root));
        printLevelOrderTreeData(root);

        printOddAndEvenLevelDifferenceOfTree(root);

    }

    public static void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.printf("%s ", node.data);
        print(node.right);
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftNodeHeight = height(node.left);
        int rightNodeHeight = height(node.right);
        if (leftNodeHeight > rightNodeHeight) {
            return leftNodeHeight + 1;
        } else {
            return rightNodeHeight + 1;
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

    public static void printOddAndEvenLevelDifferenceOfTree(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int evenSum = 0, oddSum = 0;
        while (true) {
            int nodeCount = queue.size();
            level += 1;
            if (nodeCount == 0) {
                break;
            }
            while (nodeCount>0) {
                Node node = queue.peek();
                queue.remove();
                if (level % 2 == 0)
                    evenSum += node.data;
                else
                    oddSum += node.data;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
        }
        System.out.println("Even sum" + evenSum);
        System.out.println("Odd sum " + oddSum);
        System.out.println("odd -even sum level of tree" + (evenSum - oddSum));


    }
}
