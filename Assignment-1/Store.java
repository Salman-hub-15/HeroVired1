import java.util.*;
class Product{
    int Pid;
    String Pname;
    int Pcost;
    int Pcount;
    public Product(int Pid,String Pname,int Pcost,int Pcount){
        this.Pid=Pid;
        this.Pname=Pname;
        this.Pcost=Pcost;
        this.Pcount=Pcount;
    }
    public int getPid(){
        return Pid;
    }
    public String getPname(){
        return Pname;
    }
    public int getPcost(){
        return Pcost;
    }
    public int getPcount(){
        return Pcount;
    }
    public void modify1(int pc,int pr){
        this.Pcount=pc;
        this.Pcost=pr;
    }
    public void del(int pc){
        this.Pcount=pc;
    }
}
class ProductList{
   final int n=100;
    Product pd[]=new Product[n];
    int i=0;
    public void addProduct(Product p){
        pd[i]=p;
        i++;
    }
    public void viewList(){
        System.out.println("Product ID\t\tProduct Name\t\tPrice\t\tQuantity");
        for(int j=0;j<i;j++)
        {
            System.out.println(pd[j].getPid()+"\t\t"+pd[j].getPname()+"\t\t"+pd[j].getPcost()+"\t\t"+pd[j].getPcount());
        }
    }
    public void productQnt(int pid){
        System.out.println("Product ID\t\tQunatity");
        for(int j=0;j<i;j++){
            if(pd[j].getPid()==pid){
                System.out.println(pd[j].getPid()+"\t\t"+pd[j].getPcount());
                return;
            }
        }
        System.out.println("Sorry the Product is not available");
    }
    public void prodSpec(int pid,String pname){
        System.out.println("Product ID\t\tProduct name\t\tPrice\t\tQuantity");
        for(int j=0;j<i;j++){
            if(pd[j].getPid()==pid){
            System.out.println(pd[j].getPid()+"\t\t"+pd[j].getPname()+"\t\t"+pd[j].getPcost()+"\t\t"+pd[j].getPcount());
            return;
        }
        System.out.println("Sorry the Product is not available");
        }
    }
    public void modify(int pid,int c,int amt){

        for(int j=0;j<i;j++){
            if(pd[j].getPid()==pid){
                pd[j].modify1(pd[j].getPcount()+c,pd[j].getPcost()+amt);
                return;
            }
        }
        System.out.println("Sorry the Product is not available");
    }
    public void delete(int pid,int c){
        for(int j=0;j<i;j++){
            if(pd[j].getPid()==pid && pd[j].getPcount()>0 && pd[j].getPcount()>c){
                pd[j].del(pd[j].getPcount()-c);
                return;
            }
        }
        System.out.println("Sorry the Product is not available");
    }

}
public class Store {
    public static void main(String[] args) {
        ProductList p=new ProductList();
        Product a;
        int id,cost,ct,ch;
        String pname;
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Add Product\n2.View Details\n3.Get Product Qunatity\n4.Get Product Specs\n5.Modify the Data\n6.Delete Quantity\n7.Exit");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                     id=sc.nextInt();
                     sc.nextLine();
                     pname=sc.next();
                     sc.nextLine();
                     cost=sc.nextInt();
                     sc.nextLine();
                     ct=sc.nextInt();
                     sc.nextLine();
                     a=new Product(id,pname,cost,ct);
                     p.addProduct(a);
                     break;
                case 2:
                    p.viewList();
                    break;
                case 3:
                    id=sc.nextInt();
                    sc.nextLine();
                    p.productQnt(id);
                    break;
                case 4:
                    id=sc.nextInt();
                    sc.nextLine();
                    pname=sc.next();
                    sc.nextLine();
                    p.prodSpec(id, pname);
                    break;
                case 5:
                    id=sc.nextInt();
                    sc.nextLine();
                    int c=sc.nextInt();
                    sc.nextLine();
                    int amt=sc.nextInt();
                    p.modify(id, c, amt);
                    break;
                case 6:
                    id=sc.nextInt();
                    sc.nextLine();
                    int k=sc.nextInt();
                    sc.nextInt();
                    p.delete(id, k);
                    break;
                case 7:
                      System.exit(0);
            }
        }
    }
}
