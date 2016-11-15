package rbt;

public class Node {
	
	private int key;
	private char color; // V for red, N for black, D for double black
	private Node left;
	private Node right;

	public Node(int key, char color){
		this.key = key;
		this.color = color;
		left = right = null;
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
