import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int nA, nB;
    static TreeSet<Integer> A = new TreeSet<>();
    static Set<Integer> B = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nA; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nB; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        for(int key : B){
            if(A.contains(key)) {
                A.remove(key);
            }
        }
        if(A.size() == 0) {
            System.out.print(0);
            return;
        }
        sb.append(A.size()).append('\n');
        for(int key : A) {
            sb.append(key).append(" ");
        }

        System.out.print(sb);
    }
}
