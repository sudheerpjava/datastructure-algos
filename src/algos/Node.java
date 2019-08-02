package algos;

public class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public Node() {
        left = null;
        right = null;
    }

    public static Node createNode(int number) {
        return new Node(number);
    }
}
