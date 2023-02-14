import java.util.*;
import java.util.Collections;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class RemoveDuplicates
{
    static Scanner sc=new Scanner(System.in);
    static Node create(int n)
    {
        Node head=null;
        for(int i=0;i<n;i++)
        {
            Node j=new Node(sc.nextInt());
            if(head==null)
            {
                head=j;
            }
            else
            {
                Node p=head;
                while(p.next!=null)
                {
                    p=p.next;
                }
                p.next=j;
            }
        }
        return head;
    }
    public static Node removeduplicate(Node start)
    {
        Node temp=start;
        HashSet<Integer> hs=new HashSet<>();
        while(temp!=null){
            hs.add(temp.data);
            temp=temp.next;
        }
        Node head=null;
        for(int ele:hs)
        {
            Node j=new Node(ele);
            if(head==null)
            {
                head=j;
            }
            else
            {
                Node p=head;
                while(p.next!=null)
                {
                    p=p.next;
                }
                p.next=j;
            }
        }
        return head;
    }
   
    public static void print(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.print("\n");
    }
    public static void main(String args[])
    {
        System.out.println("Enter the size of List");
        int n=sc.nextInt();
        System.out.println("Enter the elements of the list in sorted order");
        Node head=create(n);
        System.out.println("Linked List");
        print(head);
        Node start=removeduplicate(head);   
        print(start);
        
    }
}
