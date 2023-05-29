import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[1001];
        int input;
        int count=0;
        for(int i=0;i <10; i++) {
            input = Integer.parseInt(br.readLine());
            if(arr[input%42] == 0) {
                arr[input % 42]++;
                count++;
            }
        }
        System.out.println(count);
    }
}
