package HandMadeSets;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ListSet implements ISet {
    private Node head;
    private int size;

    public ListSet() {
        head = null;
        size = 0;
    }

    @Override
    public void insert(int element) {
//        head = recursiveInsert(head, element);
        iterativeInsert(element);
    }

    private Node recursiveInsert(Node cur, int element) {
        if (cur == null) {
            ++size;
            return new Node(element);
        }

        if (cur.value == element) {
            return cur;
        }

        if (cur.value < element) {
            cur.next = recursiveInsert(cur.next, element);
            return cur;
        }

        Node newNode = new Node(element);
        newNode.next = cur;
        ++size;

        return newNode;
    }

    private void iterativeInsert(int element) {
        if (head == null) {
            head = new Node(element);
            ++size;
        }

        Node prev = null, cur = head;
        while (cur != null) {
            if (element == cur.value) {
                return;
            }

            if (element < cur.value) {
                Node newNode = new Node(element);
                newNode.next = cur;
                if (prev == null) {
                    head = newNode;
                } else {
                    prev.next = newNode;
                }
                ++size;
                return;
            }

            prev = cur;
            cur = cur.next;
        }

        prev.next = new Node(element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Integer> report() {
        List<Integer> numbers = newArrayList();
        Node cur = head;
        while (cur != null) {
            numbers.add(cur.value);
            cur = cur.next;
        }

        return numbers;
    }

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
