import java.util.*;
public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        int k=a[a.length-1];
        HashMap<Integer,Integer> hp=new HashMap<>();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(hp.containsKey(a[i])){
                hp.put(a[i],hp.get(a[i])+1);
            }
            else{
                hp.put(a[i],1);
            }
        }
        for(int i=1;i<=k;i++){
            if(hp.containsKey(i)){
                continue;
            }
            else{
                al.add(i);
            }
        }
        System.out.println(al);
    }
}
