package com.narytree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

// n-ary tree, return the preorder traversal of its nodes' values.
public class narypreorder {
    List<Integer> values = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        updateListIterative(root);
        return values;
    }

    private void updateListIterative(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node temp = stack.pop();
            values.add(temp.val);

            List<Node> childrens = temp.children;
            // or use Collections.reverse(node.children);
            for (int i=childrens.size()-1; i>=0; i--) {
                stack.push(childrens.get(i));
            }
        }
    }

    public static void main(String[] args){
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node3 = new Node(3);

        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);

        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node1 = new Node(1);

        node1.children = new ArrayList<>();
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        narypreorder n = new narypreorder();
        List<Integer> list = n.preorder(node1);
        System.out.println(list);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int val)
    {
        this.val = val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
