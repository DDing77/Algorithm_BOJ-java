import java.io.*;
import java.util.*;

public class Main {

    static int A, B;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        int count = 1;
        int res = 0;

        for (int i = 0; i < B; i++) {
            for (int j = 0; j < count; j++) {
                list.add(count);
            }
            count++;
        }

        for (int i = A; i <= B; i++) {
            res += list.get(i - 1);
        }

        System.out.println(res);
    }
}