import java.io.*;
import java.util.*;

public class Main { //BOJ_1978
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Boolean> Eratos = new ArrayList<Boolean>(1000);
        Eratos.add(false);
        Eratos.add(false);
        for (int i = 2; i < 1001; i++) {
            Eratos.add(i, true);
        }
        for (int i = 2; (i * i) < 1001; i++) {
            if(Eratos.get(i)) {
                for(int j = i * i ; j < 1001; j+= i) {
                    Eratos.set(j,false);
                }
            }
        }
        int count = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(Eratos.get(num)== true){
                count++;
            }
        }
            System.out.println(count);
    }
}
