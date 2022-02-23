import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String S;
    static Set<String> Sset = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            String temp = String.valueOf(S.charAt(i));
            Sset.add(temp);
            for (int j = i + 1; j < length; j++) {
                String res = temp.concat(String.valueOf(S.charAt(j)));
                Sset.add(res);
                temp = res;
            }
        }
        System.out.println(Sset.size());
    }
}
