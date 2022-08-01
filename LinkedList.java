public class LinkedList {
    public Node head;
    public LinkedList(){
        head = null;
    }
    public void insert(int v){
        if(head == null){
            head = new Node(v);
        }
        else{
            Node p = head;
            while(p.next!=null){
                p = p.next;
            }
            Node q = new Node(v);
            p.next = q;
        }
    }
    public Node reverse(Node p){
        if(p.next == null){
            head = p;
            return p;
        }
        Node q = reverse(p.next);
        q.next = p;
        return p;
    }

}
