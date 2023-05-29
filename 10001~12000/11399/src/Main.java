import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] str = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);

        int sum =0, preSum=0;
        for(int i=0; i<arr.length; i++) {
            sum = (sum + arr[i]);
            preSum += sum;
        }
        System.out.println(preSum);
    }
}
