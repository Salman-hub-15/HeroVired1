import java.util.*;

public class UniqueNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            hs.add(a[i]);
        }
        System.out.println(hs);
        

    }
}
