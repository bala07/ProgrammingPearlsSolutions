package HandMadeSets;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class BinaryTreeSet implements ISet {
    private Node root;

    public BinaryTreeSet() {
        root = null;
    }

    @Override
    public void insert(int element) {
        root = recursiveInsert(root, element);
//        iterativeInsert(element);
    }

    private void iterativeInsert(int element) {
        if (root == null) {
            root = new Node(element);
            return;
        }

        Node prev = root, cur = root;
        while (cur != null) {
            if (cur.value == element) {
                return;
            }

            prev = cur;
            if (element < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (element < prev.value) {
            prev.left = new Node(element);
        } else {
            prev.right = new Node(element);
        }
    }

    private Node recursiveInsert(Node root, int element) {
        if (root == null) {
            return new Node(element);
        }

        if (element != root.value) {
            if (element < root.value) {
                root.left = recursiveInsert(root.left, element);
            } else {
                root.right = recursiveInsert(root.right, element);
            }
        }

        return root;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<Integer> report() {
        ArrayList<Integer> numbers = newArrayList();
        inorderTraversal(root, numbers);

        return numbers;
    }

    private void inorderTraversal(Node root, ArrayList<Integer> numbers) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, numbers);
        numbers.add(root.value);
        inorderTraversal(root.right, numbers);
    }

    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }
}
