package com.sunsat.sathish.java.hackerrank.preparation.ideserv.trees;

import java.util.*;

/**
 * Created by ssundar2 on 5/27/2017.
 */
public class CustomizedBinarySearchTree<T> {

    class Node<T> {
        Node(T val) {
            this.val = val;
        }
        T val;
        Node<T> left;
        Node<T> right;
    }

    private Node<T> root;

    private Comparator comparator = null;

    public CustomizedBinarySearchTree() {
        root = null;
    }

    public CustomizedBinarySearchTree(Comparator<T> c) {
        root = null;
        this.comparator = c;
    }

    public void insert(T t) {
        if(root == null) {
            root = new Node<>(t);
        } else {
            insert(t,root);
        }
    }

    private void insert(T val, Node<T> root) {
        Node<T> newNode = new Node<>(val);
        Node<T> temp = root;
        while (temp != null) {
            int res = compare(val,temp.val);
            if(res >= 0) {
                if(temp.right == null) {
                    temp.right = newNode;
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                if(temp.left == null) {
                    temp.left = newNode;
                    break;
                } else {
                    temp = temp.left;
                }
            }
        }
    }

    private boolean delete(T val) {
        if(root == null) return false;
        Node<T> parent = findParent(val,root);
        if(parent == null) {
            return false;
        }
        int compRes = compare(val,parent.val);

        if(compRes < 0) {
            if(compare(val,parent.right) == 0) {
                //
            }
        } else {
            if(compare(val,parent.left) == 0) {
                //
            }
        }
        return false;
    }

    private  Node<T> findParent(T val,Node<T> rootNode) {
        Node<T> temp = rootNode;
        while(temp != null) {
            int comResult = compare(val,temp.val);
            if(comResult < 0) {
                if(temp.left == null) return null;
                int comRes = compare(val,temp.left.val);
                if(comRes == 0) {
                    return temp;
                } else {
                    temp = temp.left;
                }
            } else if(comResult > 0) {
                if(temp.right == null) return null;
                int comRes = compare(val,temp.right.val);
                if(comRes == 0) {
                    return temp;
                } else {
                    temp = temp.right;
                }
            } else {
                return temp;
            }
        }
        return  temp;
    }

    public void inOrderTreeTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    public void preOrderTreeTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    public void postOrderTreeTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node<T> root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    private void preOrderTraversal(Node<T> root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private void postOrderTraversal(Node<T> root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    private void levelOrderTraversal(Node<T> root) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            System.out.println(temp.val);
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    private int compare(Object o1, Object o2) {
        return (comparator == null) ? ((Comparable)o1).compareTo(o2) :
                comparator.compare(o1,o2);
    }

    public static void main(String[] args) {
        CustomizedBinarySearchTree<Integer> tree = new CustomizedBinarySearchTree<>();
        Scanner inputSc = new Scanner(System.in);
        one : while(true) {
            System.out.println("1: Add  2: Delete 3: Inorder 4: PreOrder 5: PostOrder 6: LevelOrder 7:Print Right Sub" +
                    " Tree 8: Print Left SubTree 9:" +
                    " 9: Exit");
            Integer option = inputSc.nextInt();
            switch (option) {
                case 1 :
                    System.out.println("Enter how many Numbers wants to Add.");
                    Integer count = inputSc.nextInt();
                    for(int i=0;i<count;i++) {
                        System.out.println("Enter count: " + (i+1));
                        tree.insert(inputSc.nextInt());
                    }
                    break;
                case 2 :
                    System.out.println(" Enter Value you wants to delete.");
                    tree.delete(inputSc.nextInt());
                    break;
                case 3 :
                    tree.inOrderTreeTraversal();
                    break;
                case 4 :
                    tree.preOrderTreeTraversal();
                    break;
                case 5 :
                    tree.postOrderTreeTraversal();
                    break;
                case 6 :
                    tree.levelOrderTraversal();
                    break;
                case 7 :
                    break;
                case 8 :
                    break;
                case 9 :
                    System.out.println("Leaving now bye.");
                    break one;
                case 10 :
                    break;
            }
        }
    }
}
