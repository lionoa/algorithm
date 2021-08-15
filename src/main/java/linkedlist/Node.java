package linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    //定义一个结点
    private Node next = null;
    //定义数据域
    private String data;

}
