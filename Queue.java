import java.util.*;
public class Queue {
    public static void main(String[] args) {
        ArrayList<Integer> queue=new ArrayList<>();
        push(2,queue);
        push(4,queue);
        push(3,queue);
        printQueue(queue);
        int removedElement=pop(queue);
        System.out.println(removedElement);
        printQueue(queue);
        push(5,queue);
        printQueue(queue);
        push(6,queue);
        printQueue(queue);
        int r=pop(queue);
        printQueue(queue);
        push(7,queue);
        printQueue(queue);
    }
    public static void push(int ele,ArrayList<Integer> queue){
        ArrayList<Integer> q1=new ArrayList<>();
        if(queue.size()==0){
        queue.add(ele);
        }
        else{
            while(queue.size()!=0){
                int r=queue.remove(queue.size()-1);
                q1.add(r);
            }
            queue.add(ele);
            while(q1.size()!=0){
                int r=q1.remove(q1.size()-1);
                queue.add(r);
            }
        }
        // Collections.reverse(queue);


    }
    public static int pop(ArrayList<Integer> queue)
    {
        if(queue.size()==0){
            return Integer.MAX_VALUE;
        }
        else{
            return queue.remove(queue.size()-1);
        }
    }
    public static void printQueue(ArrayList<Integer> queue){
        for(int i:queue){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
