import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Set<Integer> list = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) list.add(Integer.parseInt(st.nextToken()));

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            if(list.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
