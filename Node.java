class Node {
	
	private Node father;
	private Node left;
	private Node right;
	private int key;

	Node(int key){
		father = null;
		left = null;
		right = null;
		this.key = key;
	}

	Node getFather() {
		return father;
	}

	void setFather(Node father) {
		this.father = father;
	}

	Node getLeft() {
		return left;
	}

	void setLeft(Node left) {
		this.left = left;
	}

	Node getRight() {
		return right;
	}

	void setRight(Node right) {
		this.right = right;
	}

	int getKey() {
		return key;
	}
	
	void setKey(int key) {
		this.key = key;
	}
	
	
}
