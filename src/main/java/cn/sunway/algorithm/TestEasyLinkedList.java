package cn.sunway.algorithm;

import cn.sunway.structure.EasyLinkedList;

/**
 * @author sunw
 * @date 2023/3/17
 */
public class TestEasyLinkedList {

    public static void main(String[] args) {
        EasyLinkedList easyLinkedList = new EasyLinkedList();
        System.out.println(easyLinkedList);
        easyLinkedList.addFirst(1);
        System.out.println(easyLinkedList);
        easyLinkedList.addFirst(2);
        System.out.println(easyLinkedList);
        easyLinkedList.addLast(3);
        System.out.println(easyLinkedList);
        easyLinkedList.addLast(4);
        System.out.println(easyLinkedList);
    }
}
