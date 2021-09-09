import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result {
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode MergeTwoOrderedList(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        SinglyLinkedListNode answer = (l1.data <= l2.data) ? l1 : l2;
        if(l1.data <= l2.data) l1 = l1.next;
        else l2 = l2.next;

        SinglyLinkedListNode tmp = answer;

        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                tmp.next = l1;
                l1 = l1.next;
            } else{
                tmp.next = l2;
                l2 = l2.next;
            }

            tmp = tmp.next;
        }

        if(l1 == null) tmp.next = l2;
        if(l2 == null) tmp.next = l1;

        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        SinglyLinkedList l1 = new SinglyLinkedList();

        int l1Count = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, l1Count).forEach(i -> {
            try {
                int l1Item = Integer.parseInt(bufferedReader.readLine().trim());

                l1.insertNode(l1Item);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedList l2 = new SinglyLinkedList();

        int l2Count = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, l2Count).forEach(i -> {
            try {
                int l2Item = Integer.parseInt(bufferedReader.readLine().trim());

                l2.insertNode(l2Item);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedListNode result = Result.MergeTwoOrderedList(l1.head, l2.head);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
