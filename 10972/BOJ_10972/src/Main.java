import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean flag = false;
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;

        if (i <= 0) flag = true;
        int j;
        if (!flag) {
            j = arr.length - 1;
            while (arr[j] <= arr[i-1]) j--;

            int temp = arr[i - 1];
            arr[i - 1] = arr[j];
            arr[j] = temp;

            j = arr.length - 1;
            while (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            for (int k = 0; k < N; k++) sb.append(arr[k]).append(" ");
            System.out.println(sb);
        } else System.out.println(-1);


    }
}
