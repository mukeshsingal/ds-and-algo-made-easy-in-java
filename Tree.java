class Node {
    Node left;
    Node right;
    int value;

    Node() {
        left = null;
        right = null;
        value = 0;
    }

    Node(int value) {
        left = null;
        right = null;
        this.value = value;
    }
}

class Tree {

    public static void main(String[] args) {
        Node root = prepareTree();
        System.out.println("\nPre ");
        preOreder(root);
        System.out.println("\nin");
        inOreder(root);
        System.out.println("\nPost ");
        postOreder(root);
    }

    public static Node prepareTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public static void preOreder(Node root) {
        if (root != null) {
            System.out.print(root.value + "-");
            preOreder(root.left);
            preOreder(root.right);
        }
        
    }

    public static void inOreder(Node root) {
        if (root != null) {
            inOreder(root.left);
            System.out.print(root.value + "-");
            inOreder(root.right);
        }
        
    }
    public static void postOreder(Node root) {
        if (root != null) {
            postOreder(root.left);
            postOreder(root.right);
            System.out.print(root.value + "-");
        }
    }
}