package algos;

import java.util.LinkedList;
import java.util.Queue;

public class SwapTreeNodes {

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
        /*c.right = h;
        c.left = g;*/
        printLevelOrderTreeData(root);
        swapNodes(root,1);
        System.out.println("=======================================");
        printLevelOrderTreeData(root);
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
            // System.out.print("===> " + sum);
            System.out.println();
        }
    }

    public static int swapNodes(Node node, int level) {

        if (node == null) {
            return 0;
        }
        int leftNodeHeight = swapNodes(node.left, level);
        int rightNodeHeight = swapNodes(node.right, level);
        if (level == leftNodeHeight) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        if (leftNodeHeight > rightNodeHeight) {
            return leftNodeHeight + 1;
        } else {
            return rightNodeHeight + 1;
        }

    }
}
