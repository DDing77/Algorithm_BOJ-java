import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] alpha = new int[26];
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            arr[i] = input;
        }
        for(int i=0; i<N; i++) {
            int temp = (int)Math.pow(10, arr[i].length()-1);
            for(int j=0; j< arr[i].length(); j++) {
                alpha[(int)arr[i].charAt(j)-65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alpha);
        int number = 9;
        int sum =0;
        for(int i=alpha.length-1; i>0; i--) {
            if(alpha[i] == 0) {
                break;
            }
            sum+= alpha[i]*number;
            number--;
        }
        System.out.println(sum);
    }
}
