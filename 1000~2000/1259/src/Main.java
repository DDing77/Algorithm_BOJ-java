import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if(str.length() ==1 && str.charAt(0) == '0') {
                System.out.print(sb);
                return;
            }
            boolean isP = true;
            for(int i=0; i<str.length()/2; i++) {
                if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                    isP = false;
                    break;
                }
            }
            if(isP) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }
    }
}
