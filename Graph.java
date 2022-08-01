import java.util.Scanner;

public class Graph {
    public int graph[][]; //二维数组
    public int N;//有几个点
    public int M;//有几条边
    public int[] temp;
    public Graph(){
        graph = new int[100][100];
        temp = new int[100];
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
        for(int i=0;i<M;i++){
            int p,q;
            p = sc.nextInt();
            q = sc.nextInt();
            graph[p][q] = graph[q][p] = 1;
        }
    }
    //相邻的所有节点
    public void query(int i){
        for(int n = 1; n <= N; n ++){
            if(graph[i][n] == 1){
               System.out.println(n);
            }
        }
    }

    public void dfs(int n){
        System.out.println(n);
        temp[n] = 1;
        for(int i = 1; i <= N; i ++){
            if(graph[n][i] == 1 && temp[i]!=1){
                dfs(i);
            }
        }
    }

    public  static void main(String[] args){
        Graph G = new Graph();
        G.input();
        G.dfs(1);
    }
}