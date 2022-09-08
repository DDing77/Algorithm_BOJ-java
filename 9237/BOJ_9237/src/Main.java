import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) tree.add(Integer.parseInt(st.nextToken()));

        Collections.sort(tree, Collections.reverseOrder());

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, tree.get(i) + i + 1);
        }

        res += 1;
        System.out.println(res);
    }
}