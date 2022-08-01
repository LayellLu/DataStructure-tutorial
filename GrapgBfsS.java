import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class GrapgBfsS {
    public int graph[][]; //二维数组
    public int N;//有几个点
    public int M;//有几条边
    public int[][] temp;
    public GrapgBfsS(){
        graph = new int[100][100];
        temp = new int[100][100];
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=0;i<N;i++){
            for(int j=0; j < M; j++){
                int t;
                t = sc.nextInt();
                graph[i][j] = t;
            }
//            int p,q;
//            p = sc.nextInt();
//            q = sc.nextInt();
//            graph[p][q] = graph[q][p] = 1;
        }
    }
    public void bfs(int i, int j){
        Queue<Integer> Qx = new ArrayDeque<>();
        Queue<Integer> Qy = new ArrayDeque<>();
        Queue<Integer> Ql = new ArrayDeque<>();
        Qx.add(i);
        Qy.add(j);
        Ql.add(0);
        temp[i][j] = 1;
        int len = 0;
        while(!Qx.isEmpty()){
            int q = Qx.peek();
            int p = Qy.peek();
            len = Ql.peek();
            Qx.poll();
            Qy.poll();
            Ql.poll();
            int dx[] = {0,0,-1,1};
            int dy[] = {-1,1,0,0};
            for(int m=0;m<4;m++){
                int tx = q + dx[m];
                int ty = p + dy[m];
                //判断当前坐标没越界 判断当前坐标能走 判断当前点没被访问过
                if((tx >= 0 && tx <= N-1)&& (ty >= 0 && ty <= M-1) ){
                    if(graph[tx][ty] == 1 && temp[tx][ty]!= 1){
                        Qx.add(tx);
                        Qy.add(ty);
                        Ql.add(len+1);
                        temp[tx][ty] = 1;
                    }
                }
            }
        }
        System.out.println(len);
    }

    //11011
    //11110
    //01111

    public static void main(String[] args){
        GrapgBfsS GB = new GrapgBfsS();
        GB.input();
        GB.bfs(0,0);
    }
}
