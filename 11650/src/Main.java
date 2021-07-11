import java.io.*;
import java.util.*;

public class Main { // BOJ_11650
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[j][0] = Integer.parseInt(st.nextToken());
            arr[j][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, ((o1, o2) -> {
            if(o1[0] == o2[0]) return Integer.compare(o1[1],o2[1]);
            else return Integer.compare(o1[0],o2[0]);
        }));
        for(int i=0;i<N;i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}
