package trees;

import java.util.*;

public class TreeTest {
    public static int horizontalCount = 0;
    public static int count = 0;
    public static Map<Integer, Queue> countMap = new HashMap<>();

    public static void main(String[] args) {
        //BinaryTree.print(BinaryTree.getBinaryTree());
        printHorizontalNodes(BinaryTree.getBinaryTree(), new Node(6));
        System.out.println(countMap.get(count));

    }


    public static void printHorizontalNodes(Node root, Node node) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); //added first element

        while (true) {
            int levelCount = queue.size();
            LinkedList list = createHorizontalMap();
            if (levelCount == 0)
                break;
            while (levelCount > 0) { //level count now 1 and remove the first element add left and right which is equal to 1+1 = 2 next all other left +right
                Node temp = queue.remove();
                addAllValuesInHorizontalLevel(list, temp);
                updateMatchedLevelCount(node, temp);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                levelCount--;
            }
            if (breakOnceFoundMatchedLevel()) break;
        }
    }

    private static boolean breakOnceFoundMatchedLevel() {
        if (count > 0 && count == horizontalCount) {
            return true;
        }
        return false;
    }

    private static void updateMatchedLevelCount(Node node, Node temp) {
        if (temp != null) {
            if (temp.value == node.value) {
                count = horizontalCount;
            }
        }
    }

    private static void addAllValuesInHorizontalLevel(LinkedList list, Node temp) {
        list.add(temp.value);
    }

    private static LinkedList createHorizontalMap() {
        LinkedList list = new LinkedList<>();
        countMap.put(++horizontalCount, list);
        return list;
    }
}
