package rbt;

public class RBT {

	private Node root;
	
// GETTERS AND SETTERS
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
// FUNCTIONS	

/*
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
*/
	
	public Node searchKey(int key) {
		Node curr = root;
		
		while (curr != null) {
			if (curr.getKey() == key)
				break;
			else if (key > curr.getKey())
				curr = curr.getRight(); 
			else
				curr = curr.getLeft();
		}
		
		return curr;
	}

	public void insert(int key) {
		insert(key, root, null, null, 1);
	}
	
	public int insert(int key, Node current, Node father, Node grandfather, int a) {
		if (current == null) {
			current = new Node(key, 'V');
			if (root == null) {
				current.setColor('N');
				root = current;
			} else {
				if (key < father.getKey())
					father.setLeft(current);
				else
					father.setRight(current);
			}
		} else {
			if (key != current.getKey()) {
				Node nextCurr;
				if (key < current.getKey())
					nextCurr = current.getLeft();
				else
					nextCurr = current.getRight();
				a = insert(key, nextCurr, current, father, a);
				if (a == 1)
					a = rota(nextCurr, current, father, grandfather, a); 
				else if (a == 0)
					a = 1;
			} else {
				System.out.println("Inserção inválida");
			}
		}
		
		return a;
	}
	
	
	private int rota(Node target, Node father, Node grandfather, Node ggfather, int a) {
		a = 2;
		if (father.getColor() == 'V') {
			Node uncle;
			if (grandfather.getLeft() == father)
				uncle = grandfather.getRight();
			else
				uncle = grandfather.getLeft();

			
			char tColor;
			if (uncle == null)
				tColor = 'N';
			else
				tColor = uncle.getColor();
			
			// Casos
			if (tColor == 'V') {
				// Caso 2.1
				grandfather.setColor('V');
				father.setColor('N');
				uncle.setColor('N');
				a = 0;
			} else {
				grandfather.setColor('V');
				boolean targetIsLeft = (target == father.getLeft());
				boolean fatherIsLeft = (father == grandfather.getLeft());				
				
				if (targetIsLeft && fatherIsLeft) {
					rotateRight(ggfather, grandfather, father);
					father.setColor('N');
				} else if (targetIsLeft && !fatherIsLeft) {
					doubleRotateLeft(ggfather, grandfather, father, target);
					target.setColor('N');
				} else if (!targetIsLeft && fatherIsLeft) {
					doubleRotateRight(ggfather, grandfather, father, target);
					target.setColor('N');
				} else {
					rotateLeft(ggfather, grandfather, father);
					father.setColor('N');
				}
			}
		}
		
		root.setColor('N');
		return a;
	}

	public void remove(int key){
		
	}
	
	// f is the father of a, b is the right child of a
	public void rotateLeft(Node f, Node a, Node b) {
		if (f != null) {
			if (f.getLeft() == a)
				f.setLeft(b);
			else
				f.setRight(b);
		}
		
		a.setRight(b.getLeft());
		b.setLeft(a);
	}
	
	// f is the father of a, b is the left child of a
	public void rotateRight(Node f, Node a, Node b) {
		if (f != null) {
			if (f.getLeft() == a)
				f.setLeft(b);
			else
				f.setRight(b);
		}
		
		a.setLeft(b.getRight());
		b.setRight(a);
	}
	
	// f is the father of a, b is the right child of a, c is the left child of b
	public void doubleRotateLeft(Node f, Node a, Node b, Node c) {
		rotateRight(a,b,c);
		rotateLeft(f,a,b);
	}
	
	// f is the father of a, b is the left child of a, c is the right child of b
	public void doubleRotateRight(Node f, Node a, Node b, Node c) {
		rotateLeft(a,b,c);
		rotateRight(f,a,b);
	}
}

