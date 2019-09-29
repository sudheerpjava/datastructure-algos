package trees;

public class BinaryTree {

    public  static Node getBinaryTree(){
        Node root = new Node(1);
        Node l1 = new Node(2);
        Node r1 = new Node(3);
        Node l12 = new Node(4);
        Node  r12 = new Node(5);
        Node l22 = new Node(6);
        Node r22 = new Node(7);
        Node l13 = new Node(8);
        Node  r13= new Node(9);
        root.left = l1;
        root.right = r1;
        l1.left=l12;
        l1.right=r12;
        r1.left =l22;
        r1.right = r22;
        l12.left = l13;
        l12.right = r13;
        return  root;
    }

    public  static void printNormal(Node root){
        if(root == null){
            return;
        }
        print(root.left);
        System.out.print(root.value + " ");
        print(root.right);
    }

    public  static void print(Node root){
        if(root == null){
            return;
        }
        print(root.left);
        System.out.print(root.value + " ");
        print(root.right);
    }

}
