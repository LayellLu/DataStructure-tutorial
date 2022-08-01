import java.util.Scanner;

public class QuickSort {
    public static void bubbleSort(int datas[]){
        for(int i = datas.length; i > 0; i--){
            for(int j = 0; j <= i-2; j++){
                if(datas[j] > datas[j+1]){
                    int p = datas[j];
                    datas[j] = datas[j+1];
                    datas[j+1] = p;
                }
            }
        }
    }

    public static void insertSort(int datas[]){
        for(int i = 1; i <= datas.length - 1; i ++){
            int temp = datas[i];
            int poi = i - 1;
            while(poi >= 0 && datas[poi] >= temp){
                datas[poi + 1] = datas[poi];
                poi--;
            }
            datas[poi+1] = temp;
        }
    }

    public static void findMid(int datas[]){
        if(datas.length%2==0){
            int p = datas.length/2 + 1;
            float q = datas[p]/datas[p-1];
            System.out.println(q);
        }else{
            System.out.println(datas[datas.length/2]);
        }
    }

    public static void main(String []args){
        int datas[] = new int[6];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<6;i++){
            datas[i] = sc.nextInt();
        }
        insertSort(datas);
        for(int i = 0; i < datas.length; i ++){
            System.out.println(datas[i]);
        }
    }
}