import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("FBI");
        int idx = 0;

        while (idx++ < 5) {
            Matcher matcher = pattern.matcher(br.readLine());
            if (matcher.find()) sb.append(idx + " ");
        }

        System.out.println(sb.length() == 0 ? "HE GOT AWAY!" : sb);
    }
}