import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] biTree = new char[26][2];
    static StringBuilder sb = new StringBuilder();
    static int N;
    static void preOrder(char root) {
        if('A' <= root && 'Z' >= root){
            sb.append(root);
            int idx = root -'A';
            if(biTree[idx][0] != '.') {
                preOrder(biTree[idx][0]);
            }
            if(biTree[idx][1] != '.') {
                preOrder(biTree[idx][1]);
            }
        }
    }
    static void inOrder(char root) {
        if('A' <= root && 'Z' >= root){
            int idx = root -'A';
            if(biTree[idx][0] != '.') {
                inOrder(biTree[idx][0]);
            }
            sb.append(root);
            if(biTree[idx][1] != '.') {
                inOrder(biTree[idx][1]);
            }
        }
    }
    static void postOrder(char root) {
        if('A' <= root && 'Z' >= root){
            int idx = root -'A';
            if(biTree[idx][0] != '.') {
                postOrder(biTree[idx][0]);
            }
            if(biTree[idx][1] != '.') {
                postOrder(biTree[idx][1]);
            }
            sb.append(root);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            biTree[a -'A'][0] = b;
            biTree[a -'A'][1] = c;
        }

        preOrder('A');
        sb.append('\n');
        inOrder('A');
        sb.append('\n');
        postOrder('A');
        System.out.println(sb);
    }
}
