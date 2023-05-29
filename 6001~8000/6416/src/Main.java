import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map;
    static Set<Integer> vertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        out:
        for (int tc = 1; ; tc++) {
            map = new HashMap<>();
            vertex = new HashSet<>();
            boolean flag = false;

            st = new StringTokenizer(br.readLine());
            while (true) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (a == 0) break;
                if (a == -1) break out;

                if (!vertex.add(b)) { // 간선 2개이상 fail
                    flag = true;
                }
                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            if (vertex.size() != 0) { // vertex 0인 경우 그냥 pass
                int rootNum = 0;
                for (int num : map.keySet()) {
                    if (!vertex.contains(num)) rootNum++;
                }
                // root 1개 이상 or 0
                if (rootNum != 1) flag = true;
            }
            if (flag) {
                sb.append("Case " + (tc) + " is not a tree.\n");
            } else {
                sb.append("Case " + (tc) + " is a tree.\n");
            }
        }
        System.out.println(sb.toString());
    }
}

