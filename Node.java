import java.util.Scanner;
//public class Node {
//    public int value;//值
//    public Node next;//指向下一个节点的指针
//    public Node(int v){
//        value = v;
//        next = null;
//    }
//    public static void main(String []args){
//
//    }
//}

public class Node {
    public Node next;//指针
    public int value;//值
    public Node(){
        value = 0;
        next = null;
    }
    public Node(int v){
        value = v;
        next = null;
    }
}