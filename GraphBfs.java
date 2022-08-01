import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class GraphBfs {
        public int datas[][];//图矩阵
        public int N;//点
        public int M;//边
        public int vis[];//标记某个点有没有被访问过
        public int[][] temp;
        public GraphBfs(){
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            M = sc.nextInt();
            datas = new int[N+1][N+1];
            vis = new int[N+1];
            for(int i=0;i<M;i++){
                int p,q;
                p = sc.nextInt();
                q = sc.nextInt();
                datas[p][q] = datas[q][p] = 1;
            }
        }

        public void bfs(int v){
            //1. 起始点入队列并标记
            Queue<Integer> Q = new ArrayDeque<>();
            Q.add(v);
            vis[v] = 1;
            //2. 循环 当队列不为空，循环
            while(!Q.isEmpty()){
                int p = Q.peek();
                Q.poll();
                for(int i = 1; i <= N; i++){
                    if(datas[p][i] == 1 && vis[i] != 1){
                        Q.add(i);
                        vis[i] = 1;
                    }
                }
            }
            //2.1 把队首节点出队
            //2.2 找到跟队首节点相邻并且没被访问过的节点，入队
            //找到广度遍历最小节点个数
        }

    public void bfsminnum(int v){
        //1. 起始点入队列并标记
        Queue<Integer> Qn = new ArrayDeque<>();
        Queue<Integer> Qe = new ArrayDeque<>();
        int q = 0;
        Qn.add(v);
        Qe.add(0);
        vis[v] = 1;
        //2. 循环 当队列不为空，循环
        while(!Qn.isEmpty()){
            int p = Qn.peek();
            q = Qe.peek();
            Qn.poll();
            Qe.poll();
            for(int i = 1; i <= N; i++){
                if(datas[p][i] == 1 && vis[i] != 1){
                    Qn.add(i);
                    vis[i] = 1;
                    Qe.add(q+1);
                }
            }
        }
        System.out.println(q);
        //2.1 把队首节点出队
        //2.2 找到跟队首节点相邻并且没被访问过的节点，入队
        //找到广度遍历最小节点个数
    }

        //  2  3
        //1       4
        //  6   5
        public  static void main(String[] args){
            GraphBfs GB = new GraphBfs();
//            GB.bfs(5);
            GB.bfsminnum(1);
        }
}
