import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int min;
    static int idx;
    static int[] Node;
    static int INF = Integer.MAX_VALUE;
    static int initTD(int left, int right, int nodeNum) {
        if(left == right) {
            return Node[nodeNum];
        }
        int mid = (left + right) /2 ;
        return Node[nodeNum] = Math.min(initTD(left, mid, nodeNum*2), initTD(mid+1, right, nodeNum*2 + 1));
    }

    static int updateTD(int left, int right, int target, int value, int nodeNum) {
        if(target <left || target > right) return Node[nodeNum];
        if(left == right) {
            Node[nodeNum] = value;
            return Node[nodeNum];
        }

        int mid = (left + right) /2 ;
        return Node[nodeNum] = Math.min(updateTD(left, mid, target, value, nodeNum*2)
                ,updateTD(mid+1, right, target, value, nodeNum*2+1));

    }
    static void queryTD(int left, int right, int queryLeft, int queryRight, int nodeNum) {
        if(queryLeft> right || queryRight < left) return;

        if( left== right ) {
            if(min > Node[nodeNum]) {
                idx = nodeNum ;
                min = Node[nodeNum];
                return;
            }
            return;
        }
        int mid = (left + right) /2 ;
        queryTD(left, mid, queryLeft, queryRight, nodeNum*2);
        queryTD(mid+1, right, queryLeft, queryRight, nodeNum*2+1);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        int startLeaf = 1;
        while(startLeaf <N) startLeaf *= 2;
        int len = startLeaf * 2;

        Node = new int[len+ 1];
        Arrays.fill(Node, INF);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            Node[startLeaf + i] = Integer.parseInt(st.nextToken());
        }

        initTD(1,startLeaf,1);
//        System.out.println(Arrays.toString(Node));

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                int target = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                updateTD(1,startLeaf,target,value,1);
            } else {
                min = Integer.MAX_VALUE;
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                queryTD(1,startLeaf,queryLeft,queryRight,1);
                sb.append(idx -startLeaf + 1).append('\n');
            }
        }
//        System.out.println(Arrays.toString(Node));
//        System.out.println(idx - startLeaf + 1);
        System.out.println(sb);
    }
}
