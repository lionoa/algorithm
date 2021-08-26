package linkedlist;

/**
 * @author lionoa
 * @date 2021/8/23 0:47
 **/
public class RemoveElements {
    public static void main(String[] args) {
        Node node5 = new Node(null,"5");
        Node node4 = new Node(node5,"15");
        Node node3 = new Node(node4,"35");
        Node node2 = new Node(node3,"45");
        Node node1 = new Node(node2,"55");
        Node node = removeElements(node1, "5");
        System.out.println(node);
    }
    public static Node removeElements(Node head,String val) {
        Node newHead = new Node();
        newHead.setNext(head);
        Node curr = newHead;
        while(curr.getNext() != null) {
            if(curr.getNext().getData().equals(val)) {
                curr.setNext(curr.getNext().getNext());
            } else {
                curr = curr.getNext();
            }
        }
        return newHead.getNext();
    }
}
