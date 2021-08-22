package linkedlist;

/**
 * @author lionoa
 * @date 2021/8/22 17:48
 * 反转单链表
 * 1->2->3->4->5
 * 反转成5->4->3->2->1
 **/
public class ReverseListNode {

    public static void main(String[] args) {
        Node node5 = new Node(null,"5");
        Node node4 = new Node(node5,"4");
        Node node3 = new Node(node4,"3");
        Node node2 = new Node(node3,"2");
        Node node1 = new Node(node2,"1");
        Node reverse = reverse(node1);
        System.out.println(reverse);
    }

    /**
     * 只要将next指针的指向反转就行了
     * 一个prev节点用于保存已经修改了next指针的结点
     * 一个next节点用于遍历
     * 一个curr用于保存当前要修改的节点
     * @param head 头结点
     * @return 反转后的头节点
     */
    public static Node reverse(Node head) {
        Node prev = null, next;
        Node curr = head;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
