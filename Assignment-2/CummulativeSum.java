import java.util.*;
public class CummulativeSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of the Array");
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=1;i<n;i++){
            a[i]=a[i]+a[i-1];
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
