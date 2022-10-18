import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    static int n, k;
    static HashSet<String> set;
    static String[] input;
    static int res;
    static boolean[] isCheck;

    static void backTracking(String str, int cnt) {
        if (cnt == k) {
            if (!set.contains(str)) {
                set.add(str);
                res++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!isCheck[i]) {
                String newStr = str + input[i];
                isCheck[i] = true;
                backTracking(newStr, cnt + 1);
                isCheck[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        input = new String[n];
        isCheck = new boolean[n];

        for (int i = 0; i < n; i++) input[i] = br.readLine();

        res = 0;

        backTracking("", 0);

        System.out.println(res);
    }
}
