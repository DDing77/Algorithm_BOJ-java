import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] Node = new int[400040];

    static int initTD(int left, int right, int nodeNum) {
        if (left == right) return Node[nodeNum] = 1;
        int mid = (left + right) / 2;
        return Node[nodeNum] = initTD(left, mid, nodeNum * 2) + initTD(mid + 1, right, nodeNum * 2 + 1);
    }

    static int queryTD(int left, int right, int target, int nodeNum) {
     if(left == right) return left;
        int mid = (left + right) / 2;
        if(target <= Node[nodeNum*2]) return queryTD(left, mid,target, nodeNum*2);
        else return queryTD(mid+1, right, target - Node[nodeNum*2], nodeNum*2+1);
    }
    static int updateTD(int left, int right, int nodeNum, int targetNodeNum) {
        if(left ==right) return Node[nodeNum] = 0;
        Node[nodeNum]--;
        int mid = (left + right) / 2;
        if(targetNodeNum > mid) return updateTD(mid+1, right, 2*nodeNum+1, targetNodeNum);
        else return updateTD(left, mid, 2*nodeNum, targetNodeNum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        initTD(1, N, 1);
//        System.out.println(Arrays.toString(Node));
        sb.append("<");
        int target = 1;
        for (int i = 0; i < N; i++) {
            int size = N-i;
            target += K-1;
            if(target % size == 0) target = size;
            else if ( target > size) target %=size;
            int deleteNodeNum  = queryTD(1,N,target,1);
            updateTD(1,N,1,deleteNodeNum);
            if( i == N-1) sb.append(deleteNodeNum).append(">");
            else sb.append(deleteNodeNum).append(", ");
        }
//        System.out.println(Arrays.toString(Node));
        System.out.println(sb);
    }
}
