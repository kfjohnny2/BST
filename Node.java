package rbt;

public class Node {
	
	private int key;
	private char color; // R for red, B for black, D for double black

	public Node(int key, char color){
		this.key = key;
		this.color = color;
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
}
