import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                System.out.print(sb);
                break;
            }
            if( arr[0] == arr[1] && arr[1] == arr[2] && arr[0] == arr[2]) {
                sb.append("Equilateral").append('\n');
                continue;
            }
            Arrays.sort(arr);
            if(arr[2] >= arr[0] + arr[1]) {
                sb.append("Invalid").append('\n');
                continue;
            }
            int cnt=0;
            for(int i=0; i<2; i++) {
                for(int j =i+1; j<3; j++) {
                    if(arr[i] == arr[j]) cnt++;
                }
            }
            if(cnt == 0) {
                sb.append("Scalene").append('\n');
                continue;
            }
            if(cnt == 1) {
                sb.append("Isosceles").append('\n');
                continue;
            }
        }
    }
}
