import java.io.*;
import java.util.*;

public class Main {
    public static class HUMAN {
        int weight;
        int hegith;

        public HUMAN(int weight, int hegith) {
            this.weight = weight;
            this.hegith = hegith;
        }
//
//        @Override
//        public int compareTo(HUMAN o) {
//
//        }
    }
    static HUMAN[] humans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        humans = new HUMAN[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            humans[i] = new HUMAN(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<N; i++) {
            int up =0;
            for(int j=0; j<N; j++) {
                if( i == j ) continue;
                if(humans[i].weight < humans[j].weight && humans[i].hegith < humans[j].hegith) up++;
            }
            sb.append(up+1).append(" ");
        }
        System.out.print(String.valueOf(sb));
    }
}
