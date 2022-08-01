import java.util.Arrays;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] datas = new int[6];
        for(int i = 0; i < datas.length; i ++){
            datas[i] = sc.nextInt();
        }
        int len = datas.length;
        int head = 0;
        int end  = len-1;
        while(head != end){
            if(datas[head] > 0){
                int p = datas[head];
                datas[head] = datas[end];
                datas[end] = p;
                end--;
            }else if(datas[head] < 0){
                head++;
            }
        }
        for(int i = 0; i < len; i ++){
            System.out.println(datas[i]);
        }
    }

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int[] datas = new int[5];
//        for(int i = 0; i < datas.length; i ++){
//            datas[i] = sc.nextInt();
//        }
//        Arrays.sort(datas);
//        for(int i = 0; i < datas.length/2; i++){
//            int p = datas[i];
//            datas[i] = datas[datas.length-1-i];
//            datas[datas.length-1-i] = p;
//        }
//        System.out.println(datas[2]);
//    }
}
