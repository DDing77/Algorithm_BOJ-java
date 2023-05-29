import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String name = br.readLine();

        sb.append(":fan:").append(":fan:").append(":fan:").append('\n');
        sb.append(":fan:").append(":").append(name).append(":").append(":fan:").append('\n');
        sb.append(":fan:").append(":fan:").append(":fan:");
        System.out.println(sb);
    }
}