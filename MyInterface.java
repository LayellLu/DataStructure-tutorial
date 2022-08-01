public interface MyInterface {
    static int CountZero(int n){
        int count = 0;
        for(int i = 0; i <= n; i++){
            while(i > 0){
                if(i%10==0){
                    count++;
                }
                i /= 10;
            }
        }
        return  count;
    }
}
