import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("         ,r'\"7").append('\n');
        sb.append("r`-_   ,'  ,/").append('\n');
        sb.append(" \\. \". L_r'").append('\n');
        sb.append("   `~\\/").append('\n');
        sb.append("      |").append('\n');
        sb.append("      |\n");

        System.out.print(sb);
    }
}
