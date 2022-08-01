public class MergeSort {

    public static void merge(int datas[],int left,int mid,int right){
        int[] temp = new int[right-left+1];
        int a = left;
        int b = mid+1;
        int c = 0;
        if(datas[a]<datas[b]){
            temp[c] = datas[a];
        }else{

        }
    }
    public static void mergeSort(int datas[],int left,int right){
        int mid = (left+right)/2;
        if(left>=right){
            return;
        }
        mergeSort(datas,left,mid);
        mergeSort(datas,mid+1,right);
    }

    public static void main(String []args){

    }

}