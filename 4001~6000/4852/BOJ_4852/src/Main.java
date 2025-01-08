import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private ArrayList<String[]> edgeOrderList;
    private HashMap<String, Node> edgeMap;
    private HashSet<String> isVisited;

    private void execDFS(ArrayList<String> trace, Node cur) {

        if (isVisited.contains(cur.myName)) {
            for (int i = 0; i < trace.size(); i++) {
                sb.append(trace.get(i)).append(" to ");
            }
            sb.append(trace.get(0)).append(".").append("\n");
            return;
        }

        trace.add(cur.myName);
        isVisited.add(cur.myName);
        execDFS(trace, cur.nextNode);
    }

    private void solution() throws IOException {

        int caseNum = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            String from = st.nextToken();
            if (from.equals("#")) {
                break;
            }
            String to = st.nextToken();

            edgeOrderList = new ArrayList<>();
            edgeMap = new HashMap<>();
            isVisited = new HashSet<>();

            edgeOrderList.add(new String[]{from, to});

            if (!edgeMap.containsKey(from)) {
                edgeMap.put(from, new Node(from));
            }

            if (!edgeMap.containsKey(to)) {
                edgeMap.put(to, new Node(to));
            }

            edgeMap.get(from).setNextNode(edgeMap.get(to));


            while (true) {
                st = new StringTokenizer(br.readLine());

                from = st.nextToken();
                if (from.equals("#")) {
                    break;
                }

                to = st.nextToken();
                edgeOrderList.add(new String[]{from, to});

                if (!edgeMap.containsKey(from)) {
                    edgeMap.put(from, new Node(from));
                }

                if (!edgeMap.containsKey(to)) {
                    edgeMap.put(to, new Node(to));
                }

                edgeMap.get(from).setNextNode(edgeMap.get(to));

            }

            sb.append("Party number ").append(caseNum++).append("\n");
            for (String[] edge : edgeOrderList) {
                if (!isVisited.contains(edge[0])) {
                    execDFS(new ArrayList<>(), edgeMap.get(edge[0]));
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Node {

        String myName;
        Node nextNode;

        public Node(String myName) {
            this.myName = myName;
        }

        public Node(String myName, Node nextNode) {
            this.myName = myName;
            this.nextNode = nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
