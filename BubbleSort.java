public class BubbleSort {
    public static void bsort(int[] Arrays){
        boolean exchanged = false;
        for(int i = 0; i < Arrays.length - 1; i ++){
            exchanged = false;
            for(int j = 0; j < Arrays.length - i -1 ; j ++) {

                if (Arrays[j] > Arrays[j + 1]) {
                    int temp = Arrays[j];
                    Arrays[j] = Arrays[j + 1];
                    Arrays[j + 1] = temp;
                    exchanged = true;
                }
            }
            if(exchanged == false)break;
        }
    }
    public static void main(String[] args){
        int[] datas = new int[]{3,4,5,2,1};
        bsort(datas);
        for(int i = 0; i < datas.length; i ++){
            System.out.println(datas[i]);
        }
    }
}
