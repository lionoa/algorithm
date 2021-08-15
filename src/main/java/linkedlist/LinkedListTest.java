package linkedlist;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkedListTest {
    public static void main(String[] args) {
        GlibSinglyLinkedList glibSinglyLinkedList = new GlibSinglyLinkedList();
        glibSinglyLinkedList.createNode("人生若只如初见，");
        glibSinglyLinkedList.createNode("何事秋风悲画扇。");
        glibSinglyLinkedList.createNode("等闲变却故人心，");
        glibSinglyLinkedList.createNode("却道故人心易变。");
        log.info("单链表的结点数量为："+glibSinglyLinkedList.length());
        glibSinglyLinkedList.printList();
        log.info(String.valueOf(glibSinglyLinkedList.deleteNode(2)));
    }
}
