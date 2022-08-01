public class List {
    public Node head;
    public List(){
        head = new Node();
    }
    //插入
    public void insert(int v){
        Node p = new Node(v);
        p.next = head.next;
        head.next = p;
    }
    //计算长度
    public int getLength(){
        int count = 0;
        Node p = head.next;
        while(p != null){
            p = p.next;
            count++;
        }
        return count;
    }

    public void remove(int v){
        Node pre = head;
        Node now = head.next;
        while(now!=null && now.value != v){
            pre = now;
            now = now.next;
        }
        if(now!=null){
            pre.next = now.next;
        }
    }


    public void removenum(int v){
        Node pre = head;
        Node now = head.next;
        while( v != 1){
            if(now == null){
                System.out.println("The input out of the length of the linklist");
                break;
            }
            pre = now;
            now = now.next;
            v--;
        }
        if(now != null){
            pre.next = now.next;
        }
    }

    public void removerevnum(int v){
        Node pre = head;
        Node now = head.next;
        int len = getLength();
        while( v != len - 1){
            if(now == null){
                System.out.println("The input out of the length of the linklist");
                break;
            }
            pre = now;
            now = now.next;
            v++;
        }
        if(now != null){
            pre.next = now.next;
        }
    }
}