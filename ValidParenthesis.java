import java.util.*;
public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> stack=new ArrayList<>();
        String s=sc.next();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.add("(");
            }
            else if(s.charAt(i)==')'){
                if(stack.size()==0){
                // stack.remove(stack.size()-1);
                continue;
                }
            }
            else{
                stack.remove(stack.size()-1);
            }
        }
        if(stack.size()==0){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }

    }
}
