import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class hashset {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            Set<Integer> S = new HashSet<>();
            int n = sc.nextInt();
            for(int i = 0; i < n; i ++){
                int m = sc.nextInt();
                S.add(m);
            }
            int depnum = 0;
            depnum = n - S.size();
            System.out.println(depnum);
        }
}
