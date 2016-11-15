package rbt;

public class Node {
	
	private int key;
	private char color; // R for red, B for black, D for double black
    private Node left, right, parent;

	public Node(int key, char color){
		this.key = key;
		this.color = color;
        this.left = right = parent = nulls;
        color = RED;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public char getColor(){
		return color;
	}
	
	public void setColor(char color) {
		this.color = color;
	}

	public Node getLeft(){
		return this.left;
	}

	public void setLeft(Node left){
		this.left = left;
	}
	public Node getRight(){
		return this.right;
	}

	public void setRight(Node right){
		this.right = right;
	}
	public Node getParent(){
		return this.parent;
	}

	public void setParent(Node parent){
		this.parent = parent;
	}
}
