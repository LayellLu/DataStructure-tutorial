public class HeapSort {
    public static void HeapDown(int[] datas, int n, int i) {
        while (2 * i <= n) {
            int lo = 2 * i;
            if(lo + 1 <= n && datas[lo] < datas[lo+1])lo=lo+1;//找最大子节点的位置
            //和父节点比较，如果大于父节点，父节点下移
            if(datas[i] < datas[lo]){
                int t = datas[i];
                datas[i] = datas[lo];
                datas[lo] = t;
            }
            else{
                //否则，循环停止
                break;
            }
            i = lo;
        }
    }

    public static void buildHeap(int[] datas){
        for(int i = datas.length/2; i >= 1; i--){
            HeapDown(datas, datas.length-1, i);
        }
    }

    public static void heapSort(int[] datas, int n){
        buildHeap(datas);
        while(n >= 1){
            int temp = datas[1];
            datas[1] = datas[n];
            datas[n] = temp;
            n--;
            HeapDown(datas, n,1);
        }
    }

    public static void main(String []args){
        HeapSort HG = new HeapSort();
        int[] datas = new int[]{0,1,2,3,4,5,6};
        heapSort(datas,6);
        for(int i = 1; i < datas.length; i ++){
            System.out.println(datas[i]);
        }
    }

}
