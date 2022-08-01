public class ErFen {
    public int datas[];
    public int N;

    public ErFen(int n) {
        N = n;
        datas = new int[N];
    }

    public int binarySearch(int v) {
        int left = 0, right = datas.length-1;
        while (left<=right){
            int m = (left + right)/2;
            if (v == datas[m]){
                return m;
            }
            else if (v < m){
                right = m - 1;
            }
            else{
                left = m + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }

}
