package com.binary_Search;

import java.util.NoSuchElementException;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/9/19
 */
public class BinarySearchTree {
    public static void main(String[] args){
        BinarySearchTree bn = new BinarySearchTree();

        bn.insert(4);
        bn.insert(2);
        bn.insert(1);
        bn.insert(8);
        bn.insert(6);
        bn.insert(5);
        bn.insert(12);
        bn.insert(9);
        bn.insert(3);
        System.out.println("Completed the insertion");
        bn.display(bn.root);
        boolean status = bn.find(6);
        System.out.println("Completed the finding: " +status);
        bn.delete(5);
        System.out.println("Completed the deletion");
        bn.display(bn.root);
        System.out.println("Completed the display");
    }
    class Node{
        Object data;
        Node left;
        Node right;

        public Node(Object element){
            this.data = element;
            this.left = this.right = null;
        }
    }
    public Node root;

    // based on the value of n, compare with root.data
    // if root.data>n, then go left else go right.
    // go until we find the leaves ie null child i.e return false
    public boolean find_recursion(Object n){

        if(root== null){
            throw new NoSuchElementException();
        }
        if((int)root.data == (int)n){
            return true;
        } else if((int)root.data > (int)n && (root.left != null)){
            find_recursion(root.left.data);
        } else if((int)root.data < (int)n &&  (root.right != null)){
            find_recursion(root.right.data);
        }
        return false;
    }

    public Node getSuccessor(Node deleleNode){
        Node successsor =null;
        Node successsorParent =null;
        Node current = deleleNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    // based on the value of n, compare with root.data
    // if root.data>n, then go left else go right.
    // go until we find the leaves ie null child i.e return false
    public boolean find(Object n){
        Node current = root;

        while(current!=null){
            if((int)current.data == (int)n){
                return true;
            } else if((int)current.data > (int)n){
                current = current.left;
            } else if((int)current.data < (int)n){
                current = current.right;
            }
        }
        return false;
    }

    // Use the same logic of find() to find the node where value is good.
    // iterate till the node is null and then add this node there to the leaf
    public void insert(Object n){
        Node newNode = new Node(n);
        if(root == null){
            root = newNode;
            return;
        }
        Node current = root;
        while(current != null){
            if((int)current.data >= (int)n){
                if(current.left == null){
                    current.left = newNode;
                    return;
                }else {
                    current = current.left;
                }

            } else if((int)current.data < (int)n){
                if(current.right == null){
                    current.right = newNode;
                    return;
                }else {
                    current = current.right;
                }
            }
        }
    }

    /** Node to be deleted is a leaf node
     *      set parent.left = null or parent.right = null
     *  Node to be deleted has only one child
     *      Traverse to the node.
     *      keep track of the parent node and the left or right child node
     *      check for child node which is null
     *      remove the entire subtree and add it to parent tree is on the delete node.
     *  Node to be deleted has two child
     *      Find the succesor node which will replace the deleted node
     *      successor is the smallest node in the right subtree of the node to be deleted
    */
    public boolean delete(Object del){

        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while((int)current.data!=(int)del){
            parent = current;
            if((int)current.data>(int)del){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }
    // Print the entire tree in the increasing order
    // Have to use recursion, I see no other options.
    public void display(Node root){
        Node current = root;

        System.out.println(root.data);
        if(root.left!=null){
            display(root.left);
        }
        if(root.right != null) {
            display(root.right);
        }
        return;
    }
}
