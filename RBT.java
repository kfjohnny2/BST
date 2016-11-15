package rbt;

public class RBT {

	private Node root;
	private RBT leftTree;
	private RBT rightTree;
	
// GETTERS AND SETTERS
	
	public Node getRoot() {
		return root;
	}

	public RBT getLeftTree() {
		return leftTree;
	}

	public RBT getRightTree() {
		return rightTree;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void setLeftTree(RBT leftTree) {
		this.leftTree = leftTree;
	}

	public void setRightTree(RBT rightTree) {
		this.rightTree = rightTree;
	}

// FUNCTIONS	
	
	public void percursoEmOrdem(){
		if (root == null) return;
		
		if (leftTree != null) leftTree.percursoEmOrdem();
		System.out.printf(root.getKey()+" ");
		if (rightTree != null) rightTree.percursoEmOrdem();
	}
	
	public void percursoPreOrdem(){
		if (root == null) return;
		
		System.out.printf(root.getKey()+" ");
		if (leftTree != null) leftTree.percursoPreOrdem();
		if (rightTree != null) rightTree.percursoPreOrdem();
	}
	
	public void percursoPosOrdem(){
		if (root == null) return;
		
		if (leftTree != null) leftTree.percursoPosOrdem();
		if (rightTree != null) rightTree.percursoPosOrdem();
		System.out.printf(root.getKey()+" ");
	}
	
	public RBT searchKey(int key) {
		if (root.getKey() == key)
			return this;
		else if (key > root.getKey())
			return rightTree.searchKey(key);
		else
			return leftTree.searchKey(key);
	}
	
	public void insert(int key, char color){
		root = new Node(key, color);
		root.setLeft(root.getRight());
		root.setRight(root.getParent);
		root.setParent(null);

		Node aux = root;
		Node aux2 = null;

		while(aux!=null){
			aux2.setNode(aux);
			if(root.getKey() < aux.getKey()){
				aux.setNode(aux.getLeft());
			} else if (root.getKey() > aux.getKey()){
				aux.setNode(aux.getRight());
			} else{
				aux.setKey(key);
				root.setNode(aux);
				return;
			}
		}
        if (root.getKey() <  aux2.getKey()){
            aux2.setLeft(root);
        }
        else{
            aux2.setRight(root);
        }

        root.setParent(aux2);
	}
	
	public void remove(int key){
		
	}
	
	// f is the father of a, b is the right child of a
	public void rotateLeft(RBT f, RBT a, RBT b) {
		if (f != null) {
			if (f.leftTree == a)
				f.leftTree = b;
			else
				f.rightTree = b;
		}
		
		a.rightTree = b.leftTree;
		b.leftTree = a;
	}
	
	// f is the father of a, b is the left child of a
	public void rotateRight(RBT f, RBT a, RBT b) {
		if (f != null) {
			if (f.leftTree == a)
				f.leftTree = b;
			else
				f.rightTree = b;
		}
		
		a.leftTree = b.rightTree;
		b.rightTree = a;
	}

	// f is the father of a, b is the right child of a, c is the left child of b
	public void doubleRotateLeft(RBT f, RBT a, RBT b, RBT c) {
		rotateRight(a,b,c);
		rotateLeft(f,a,b);
	}
	
	// f is the father of a, b is the left child of a, c is the right child of b
	public void doubleRotateRight(RBT f, RBT a, RBT b, RBT c) {
		rotateLeft(a,b,c);
		rotateRight(f,a,b);
	}
}

