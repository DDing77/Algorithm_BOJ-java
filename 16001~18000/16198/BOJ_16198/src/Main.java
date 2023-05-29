import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer> list;
    static int res;

    static void bt(ArrayList<Integer> list, int sum) {
        if (list.size() <= 2) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            int tSum = temp.get(i - 1) * temp.get(i + 1);
            temp.remove(i);
            bt(temp, sum + tSum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));

        res = 0;
        bt(list, 0);

        System.out.println(res);
    }
}
