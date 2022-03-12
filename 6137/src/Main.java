import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static String S;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        S = "";
        for(int i=0; i<N; i++) S += br.readLine();

        String res = "";
        ArrayList<Character> list = new ArrayList<>();
        int L = 0;
        int R = N-1;
        while(L < R) {
            if(S.charAt(L) < S.charAt(R)) {
                list.add(S.charAt(L));
                L++;
            }
            else if(S.charAt(L) == S.charAt(R)) {
                int tempL = L;
                int tempR = R;
                while( S.charAt(tempL) == S.charAt(tempR)) {
                    if(tempR > 0 ) tempR--;
                    if(tempL < N-1) tempL++;
                    if(S.charAt(tempL) < S.charAt(tempR) ) {
                        list.add(S.charAt(L));
                        L++;
                        break;
                    }
                    else if(S.charAt(tempL) > S.charAt(tempR)) {
                        list.add(S.charAt(R));
                        R--;
                        break;
                    }
                }
            }
            else if(S.charAt(L) > S.charAt(R)) {
                list.add(S.charAt(R));
                R--;
            }
        }

        list.add(S.charAt(R));
        for(int i=0; i<N; i++){
            if(i !=0 && i %80 == 0) sb.append('\n');
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}

