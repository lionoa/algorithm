package linkedlist;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlibSinglyLinkedList {
    private final Node head;

    public GlibSinglyLinkedList() {
        head = new Node();
    }

    //创建结点
    public void createNode(String data) {
        Node node = new Node();
        node.setData(data);
        if (head.getNext() == null) {
            head.setNext(node);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    //查看长度
    public int length() {
        int length = 0;
        Node temp = head;
        while (temp.getNext() != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    //遍历结点
    public void printList() {
        int count = 0;
        Node temp = head;
        while (temp.getNext() != null) {
            count++;
            temp = temp.getNext();
            log.info("结点" + count + ": " + temp.getData());
        }
    }

    //删除第index个结点
    public int deleteNode(int index) {
        int i = 1;
        if (isExist(index)) {
            log.info(" 无法删除！");
            return 0;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            if (i == index) {
                temp.setNext(temp.getNext().getNext());
                log.info("第" + index + "个结点删除成功！");
                break;
            }
            temp = temp.getNext();
            i++;
        }
        return 1;
    }

    //判断第index个结点是否存在
    public boolean isExist(int index) {
        if (index < 1 || index > length()) {
            log.info("没有第" + index + "个结点");
            return true;
        }
        return false;
    }

    //修改第index个结点的数据
    public void updateNode(int index, String data) {
        int i = 1;
        if (isExist(index)) {
            log.info(" 无法修改！");
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            if (i == index) {
                temp.getNext().setData(data);
                log.info("第" + index + "个结点修改成功！");
                break;
            }
            temp = temp.getNext();
            i++;
        }
    }

    //查看第index个结点的数据域
    public void showNode(int index) {
        int i = 1;
        if (isExist(index)) {
            log.info(" 无法查看！");
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            if (i == index) {
                log.info("第" + index + "个结点的数据为：" + temp.getNext().getData());
                break;
            }
            temp = temp.getNext();
            i++;
        }
    }
}
