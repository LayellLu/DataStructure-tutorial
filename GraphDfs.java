import java.util.Scanner;

public class GraphDfs {
    public int graph[][]; //二维数组
    public int N;//有几个点
    public int M;//有几条边
    public int[][] temp;
    public GraphDfs(){
        graph = new int[100][100];
        temp = new int[100][100];
    }

    /*
    4 4
    1 2
    2 3
    1 4
    3 4
     */
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

    public void dfs(int i,int j){
        temp[i][j] = 1;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int p=0;p<4;p++){
            int tx = i +dx[p];
            int ty = j + dy[p];
            //判断当前坐标没越界 判断当前坐标能走 判断当前点没被访问过
            if((tx >= 0 && tx <= N-1)&& (ty >= 0 && ty <= M-1) ){
                if(graph[tx][ty] == 1 && temp[tx][ty]!= 1){
                    dfs(tx,ty);
                }
            }
        }
    }

    //11011
    //11110
    //00111



    public  static void main(String[] args){
        GraphDfs G = new GraphDfs();
        G.input();
        G.dfs(0,0);
        if(G.temp[G.N-1][G.M-1] == 1){
            System.out.println("Success");
        }
    }
}