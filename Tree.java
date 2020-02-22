import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    @Override
    public String toString() {
        return this.value + "";
    }
}

class Tree {
    static int width = 0;
    public static void main(String[] args) {
        Node root = prepareTree();
        Node root2 = prepareTree2();
        // System.out.println("\nPre ");
        // preOreder(root);
        // System.out.println("\nin");
        // inOreder(root);
        // System.out.println("\nPost ");
        // postOreder(root);
        // System.out.println("\nPost Iterative");
        // postOrderIterative(root);
        // System.out.println("\nLevel Order");
        //levelOrderTraversal(root);
        //reverseLevelOrderTraversal(root);
        //System.out.println("Height of binary tree is  " + heightOfTree(root));
        //System.out.println("Height of binary tree is  " + heightOfTreeIterative(root));
        //System.out.println("Leaf count " +  leafCount(root));
        //System.out.println("Leaf count iterative " +  leafCountIterative(root));
        //System.out.println("max is " + findMax(root));\
        //System.out.println("ifStructureSame  " +  ifStructureSame(root, root2));
        width = 0;
        diameter(root);
        System.out.println("Diameter is " + width);
    }

    public static Node prepareTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
    
        return root;
    }
    public static Node prepareTree2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.left = new Node(9);
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

    public static void postOrderIterative(Node root) {

        if(root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // We need to keep track of prev as we need to some nodes twice.
        Node prev = null;

        while(!stack.isEmpty()) {
            Node currentNode  = stack.peek();

            // Executed when we go from parent to children node
            if(prev == null || prev.left == currentNode || prev.right == currentNode) {
                if(currentNode.left != null) {
                    stack.push(currentNode.left);
                }
                else  if(currentNode.right != null) {
                    stack.push(currentNode.right);
                }
            }
            // Executed when we go from left to parent node
            else if(currentNode.left == prev) {
                if(currentNode.right != null) 
                    stack.push(currentNode.right);
            }
            // Executed when we go from right to parent node
            else {
                System.out.println(currentNode.value);
                stack.pop();
            }

            prev = currentNode;
        }

        

    }
    public static void levelOrderTraversal(Node root) {
        if(root == null) {
            System.out.println("Tree is empty");
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static int findMax(Node root) {
       if(root != null) {
           int maxLeft = findMax(root.left);
           int maxRight = findMax(root.right);
           return Math.max(root.value, Math.max(maxLeft, maxRight));
       }
       return Integer.MIN_VALUE;
    }
    
    public static void reverseLevelOrderTraversal(Node root) {
        System.out.println("\nReverse Level Order");
        Stack<Node> stack = new Stack<>();

        if(root == null) {
            System.out.println("Tree is empty");
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        stack.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
        
            
            if(node.right != null) {
                queue.add(node.right);
                stack.add(node.right);
            }
            if(node.left != null) {
                queue.add(node.left);
                stack.add(node.left);
            }
        }
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node + " ");
           
        }
    }

    public static int heightOfTree(Node root) {
        if(root != null) {
            int heightLeft =  heightOfTree(root.left);
            int heightRight =  heightOfTree(root.right);
            return Math.max(heightLeft, heightRight) + 1;
        }
        return 0;
    }

    public static int heightOfTreeIterative(Node root) {
        //Do level order traversal
        int height = 0;
        if(root == null) {
            return height;
        }
        Queue<Node> queue  = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(node != null) {
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            else {
                if(!queue.isEmpty()) { //This will avoid infinite loop
                    queue.add(null);
                }
                height++;
            }
        }
        return height;
    }

    public static int leafCountIterative(Node root) {
        //Do level order traversal
        int leafCount = 0;
        if(root == null) {
            return leafCount;
        }
        Queue<Node> queue  = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(node.left == null && node.right == null) leafCount++;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);       
        }
        return leafCount;
    }
    public static int leafCount(Node root) {
        if(root == null) return 0;
        if(root.left == null & root.right == null) {
            return 1;
        }
        return leafCount(root.left) + leafCount(root.right);
    }

    public static boolean ifStructureSame(Node root1, Node root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 != null) {
            return ifStructureSame(root1.left, root2.left) && ifStructureSame(root1.right, root2.right);
        }
        return false;
    }
    
    public static int diameter(Node root) {
        if(root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        if(left + right + 1 > width)  {
            width = left + right + 1;
        }
        return Math.max(left, right) + 1;
    }
    

}

