package com.leetcode;

import java.util.List;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/5/19
 * // Definition for a Node.
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};