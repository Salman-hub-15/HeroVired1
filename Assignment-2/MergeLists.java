import java.util.*;

public class MergeLists {
    static Scanner sc=new Scanner(System.in);
    static class Node{
        int val;
        Node next;
        Node(int value){
            this.val=value;
        }
    }
    public static Node merge(Node start1,Node start2){
       ArrayList<Integer> c=new ArrayList<>();
       Node t1=start1;
       Node t2=start2;
       while(t1!=null){
        c.add(t1.val);
        // System.out.print(t1.val+" ");
        t1=t1.next;
       }
       while(t2!=null){
        c.add(t2.val);
        // System.out.print(t2.val+" ");
        t2=t2.next;
       }
       Collections.sort(c);
       Node n=new Node(-1);
       Node head=null;
       for(int ele:c){
        if(head==null){
            head=new Node(ele);
        }
        else{
            Node k=head;
            while(k.next!=null){
                k=k.next;
            }
            k.next=new Node(ele);
        }
       }
       Node p=head;
       while(p!=null){
        p=p.next;
       }
       return head;
    }
    public static Node createlist(int[] a,int n)
    {
        Node temp=null;
        for(int i=0;i<n;i++){
            if(temp==null){
                temp=new Node(a[i]);
            }
            else{
                Node p=temp;
                while(p.next!=null){
                    p=p.next;
                }
                p.next=new Node(a[i]);
            }
        }
        return temp;
    }
    
    public static void main(String[] args) {
        System.out.println("Enter no.of elements in a list");
        int n1=sc.nextInt();
        int a[]=new int[n1];
        System.out.println("Enter First List ");
        for(int i=0;i<n1;i++){
            a[i]=sc.nextInt();
        }
        Node head1=createlist(a, n1);
        System.out.println("Enter no.of elements in a list");
        int n2=sc.nextInt();
        int b[]=new int[n2];
        System.out.println("Enter Second List ");
        for(int i=0;i<n1;i++){
            b[i]=sc.nextInt();
        }
        Node head2=createlist(b,n2);
       Node start= merge(head1,head2);
    
        while(start!=null){
            System.out.print(start.val+"->");
            start=start.next;
        }
        
    }
}
