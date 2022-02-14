import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Node[] nodes;
    static List<Node>[] nodes2Depth;
    static Node root;
    static int maxDepth;

    static int answerDepth = 1;
    static int answerLevel = 1;

    static class Node{
        Node left;
        Node right;

        int id;
        int leftWidth;
        int rightWidth;
        int depth;
        int absoluteWidth;

        public Node(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        nodes2Depth = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i ++) {
            nodes[i] = new Node(i);
            nodes2Depth[i] = new ArrayList<>();
        }

        boolean[] rootChecker = new boolean[N + 1];


        for(int i = 0; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            rootChecker[left != -1 ? left : 0] = true;
            rootChecker[right != -1 ? right : 0] = true;

            nodes[parent].left = left != -1 ? nodes[left] : null;
            nodes[parent].right = right != -1 ? nodes[right] : null;
        }

        for(int i = 1; i < N + 1; i ++){
            if(!rootChecker[i]){
                root = nodes[i];
                break;
            }
        }

        dfs(root, 1);
        root.absoluteWidth = root.leftWidth + 1;
        absoluteWidthSearch(root);

        for(int depth = 2; depth <= maxDepth; depth ++){
            Node leftMost = nodes2Depth[depth].get(0);
            Node rightMost = nodes2Depth[depth].get(nodes2Depth[depth].size() - 1);
            int level = rightMost.absoluteWidth - leftMost.absoluteWidth + 1;

            if(answerLevel < level){
                answerDepth = depth;
                answerLevel = level;
            }
        }

        System.out.println(answerDepth + " " + answerLevel);
    }

    public static int dfs(Node node, int depth){
        if(node == null) return 0;

        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);
        node.leftWidth = left;
        node.rightWidth = right;
        node.depth = depth;
        nodes2Depth[depth].add(node);
        maxDepth = Math.max(depth, maxDepth);
        return left + right + 1;
    }

    public static void absoluteWidthSearch(Node node){

        if(node.left != null){
            Node left = node.left;
            left.absoluteWidth = node.absoluteWidth - node.leftWidth + left.leftWidth;
            absoluteWidthSearch(left);
        }
        if(node.right != null){
            Node right = node.right;
            right.absoluteWidth = node.absoluteWidth + node.rightWidth - right.rightWidth;
            absoluteWidthSearch(right);
        }
    }
}
