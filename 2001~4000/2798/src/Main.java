import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max = 0, sum =0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                for(int k= j+1; k<N; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum > M) continue;
                    max = Math.max(sum, max);
                }
            }
        }
        System.out.println(max);
    }
}
