import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> nowList = new ArrayList<Integer>();

            for (int j = 0; j < 5; j++) nowList.add(Integer.parseInt(st.nextToken()));

            int max = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        int point = (nowList.get(j) + nowList.get(k) + nowList.get(l)) % 10;
                        if (max < point) max = point;
                    }
                }
            }
            list.add(max);
        }

        int res = Collections.max(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (res == list.get(i)) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}