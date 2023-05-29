import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vk = Integer.parseInt(st.nextToken());
        int jk = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int vl = Integer.parseInt(st.nextToken());
        int jl = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int vh = Integer.parseInt(st.nextToken());
        int dh = Integer.parseInt(st.nextToken());
        int jh = Integer.parseInt(st.nextToken());

        long heavyChain = vh * dh * jh;
        long lightChainK = vk * jk;
        long lightChainL = vl * jl;
        long totalVariant = heavyChain * (lightChainK + lightChainL);

        System.out.print(totalVariant);
    }
}