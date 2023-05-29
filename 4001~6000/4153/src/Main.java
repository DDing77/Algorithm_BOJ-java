import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        arr = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
            else {
                Arrays.sort(arr);
                if ((arr[0] * arr[0] + arr[1] * arr[1]) == arr[2] * arr[2]) {
                    sb.append("right").append("\n");
                } else {
                    sb.append("wrong").append("\n");
                }
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}
