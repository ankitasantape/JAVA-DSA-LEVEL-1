package Goldman_Sachs_Coderpad_Round_Interview_Question;

import java.util.*;

class BinarySearchTree {
	Node root = null;

	public BinarySearchTree() {
	}

	public BinarySearchTree(Node root) {
		this.root = root;
	}

	private void addNode(int val, Node node){
        if(val < node.getVal()){
            if(node.getLeft() == null){
                node.setLeft(new Node(val));
            } else {
                addNode(val, node.getLeft());
            }
        } else {
            if(node.getRight() == null){
                node.setRight(new Node(val));
            } else {
                addNode(val, node.getRight());
            }
        }
    }

    public void addNode(int val){
        if(root == null){
            root = new Node(val);
        } else if (val < root.getVal()){

            if(root.getLeft() == null){
                root.setLeft(new Node(val));
            } else {
                addNode(val, root.getLeft());
            }

        } else {
            if(root.getRight() == null){
                root.setRight(new Node(val));
            } else {
                addNode(val, root.getRight());
            }
        }
    }

    public void printInOrderDFT(){
        if(root.getLeft() != null){
            printInOrderDFT(root.getLeft());
        }

        System.out.println(root.getVal());

        if(root.getRight() != null){
            printInOrderDFT(root.getRight());
        }
    }

    private void printInOrderDFT(Node node){
    	
    	
//        if(Optional.ofNullable(node.getLeft()).isPresent()){
//            printInOrderDFT(node.getLeft());
//        }

    	if( node.getLeft() != null ) {
    		printInOrderDFT(node.getLeft());
    	}
    	
        System.out.println(node.getVal());

        if( node.getRight() != null ) {
    		printInOrderDFT(node.getRight());
    	}
        
//        if(Optional.ofNullable(node.getRight()).isPresent()){
//            printInOrderDFT(node.getRight());
//        }
    }
}

class Node {
	int data;
	Node left = null;
	Node right = null;

	public Node(int data) {
		this.data = data;
		
	}

	public int getVal() {
		return data;
	}

	public void setVal(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

public class A03_Inorder_Traversal {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(5);
        bst.addNode(3);
        bst.addNode(7);
        bst.addNode(1);
        bst.addNode(2);
        bst.printInOrderDFT();
	}

}
