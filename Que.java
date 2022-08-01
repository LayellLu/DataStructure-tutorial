import java.util.*;

//队空
//队满
//入队
//出队
//得到队首

public class Que {

    public static void main(String []args){
//        Queue<Integer> Q = new ArrayDeque<>();
//        //判空
//        if(Q.isEmpty()){
//            System.out.println("队列空");
//        }
//        //入队 1 2 3
//        Q.add(1);
//        Q.add(2);
//        Q.add(3);
//        //得到队首元素
//        Integer m = Q.peek();
//        System.out.println(m);
//        //出队
//        Q.poll();
//        m = Q.peek();
//        System.out.println(m);


        //1. 定义一个队列，存string

//        Queue<String> Qe = new ArrayDeque<>();
//        Qe.add("apple");
//        Qe.add("banana");
//        Qe.add("orange");
//        // 3. 得到队首元素并打印
//        String a = Qe.peek();
//        System.out.println(a);
//        // 4. 判断队列是否为空
//        if(Qe.isEmpty()) {
//            System.out.println("is empty");
//        }
//        Qe.poll();
//        Qe.poll();
//        // 5. 出队 两次 6.打印队首元素
//        String b = Qe.peek();
//        System.out.println(b);
//        // 2. apple banana orange

        Queue<Integer> Q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ctn = 0;
        for(int i = 1; i <= n; i++){
            Q.add(i);
        }
        int q = 0;
        while(!Q.isEmpty()){
            q = Q.peek();
            Q.poll();
            ctn++;
            if(ctn!=m){
                Q.add(q);
            }else{
                System.out.println(q);
                ctn = 0;
            }
        }
    }
}
//pta