package codingTest.tree;

public class Tree {

    public static void main(String[]args){
        // 이진 트리 생성
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 전위 순회 출력
        System.out.print("Pre-order Traversal: ");
        preOrderTraversal(root);
        System.out.println();

        // 중위 순회 출력
        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        // 후위 순회 출력
        System.out.print("Post-order Traversal: ");
        postOrderTraversal(root);
        System.out.println();
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 왼쪽 root 오른쪽 순  - 중위 순회
     * @param root
     */
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        // 왼쪽 서브트리를 중위 순회
        inOrderTraversal(root.left);

        // 루트 노드를 방문
        System.out.print(root.val + " ");

        // 오른쪽 서브트리를 중위 순회
        inOrderTraversal(root.right);
    }

    /**
     * 왼쪽 - 오른쪽 - root  - 후위 순회
     * @param root
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) return;

        // 왼쪽 서브트리를 후위 순회
        postOrderTraversal(root.left);

        // 오른쪽 서브트리를 후위 순회
        postOrderTraversal(root.right);

        // 루트 노드를 방문
        System.out.print(root.val + " ");
    }

    /**
     * root - 왼쪽 - 오른쪽  : 전위 순회
     */
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        // 루트 노드를 방문
        System.out.print(root.val + " ");

        // 왼쪽 서브트리를 전위 순회
        preOrderTraversal(root.left);

        // 오른쪽 서브트리를 전위 순회
        preOrderTraversal(root.right);
    }
}
