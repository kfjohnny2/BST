public class ABB {

	private Node sentinela;
	Node root;
	private Node result;
	
	ABB(){
		sentinela = new Node(0);
		root = sentinela.getFather();		
		result = null;
	}
	
	void percursoEmOrdem(Node search){
		if (search!= null){
			percursoEmOrdem(search.getLeft());
			System.out.printf(search.getKey()+" ");
			percursoEmOrdem(search.getRight());
		}
	}
	
	void percursoPreOrdem(Node search){
		if (search!= null){
			System.out.printf(search.getKey()+" ");
			percursoPreOrdem(search.getLeft());
			percursoPreOrdem(search.getRight());
		}
	}
	
	void percursoPosOrdem(Node search){
		if (search!= null){
			percursoPreOrdem(search.getLeft());
			percursoPreOrdem(search.getRight());
			System.out.printf(search.getKey()+" ");
		}
	}
	
	Node searchKey(int key, Node node){
		result = null;
		if (node.getKey() == key)
			return node;
		if(key > node.getKey()){
			result = searchKey(key,node.getRight());
		}else if(key < node.getKey()){
			result = searchKey(key,node.getLeft());
		} 
		return result;
	}
	
	Node max(Node search){
		result = null;
		if(search.getRight()==null){
			result = search;
		}else{
			max(search.getRight());
		}
		return result;
	}
	
	Node min(Node search){
		result = null;
		if(search.getLeft()==null){
			result = search;
		}else{
			min(search.getLeft());
		}
		return result;
	}
	
	Node getPredecessor(Node search){
		if(root.getRight()!=null)
			result = min(root.getRight());
		else{
			
		}
		return result;
	}
	
	Node getSucessor(Node search){
		if(search.getRight()!=null)
			result = min(search.getRight());
		else{
			Node b;
			b = search;
			while(b.getKey() <= search.getKey()){
				if(b.getFather()==null)
					break;
				
				b = b.getFather();
			}

			result = b;
			
		}
		
		return result;
	}
	
	void insert(int key){
		if(sentinela.getFather()==null){
			root = new Node(key);
			sentinela.setFather(root);
		}else{
			insertSearch(root, key);
		}
	}
	
	private void insertSearch(Node node, int key){
		if(key < node.getKey()){
			if(node.getLeft()==null){
				Node X = new Node(key);
				X.setFather(node);
				node.setLeft(X);
				
			}else 
				insertSearch(node.getLeft(), key);
		}
		else if(key > node.getKey()){
			if(node.getRight()==null){
				Node X = new Node(key);
				node.setRight(X);
				X.setFather(node);
			}
			else
				insertSearch(node.getRight(), key);
		}
		else 
			return;
	}
	
	void remove(int key){
		Node node = searchKey(key, root);
		if(node.getLeft() == null && node.getRight() ==null){
			node = node.getFather();
			if(node.getLeft().getKey()==key)
				node.setLeft(null);
			else if(node.getRight().getKey() == key)
				node.setRight(null);
		}
		else{
			node = node.getFather();
			
		}
	}

	boolean arvoreDeBuscaValida(){
		
		return true;
	}

	void profundidade(Node no, int p){
		if(no != null){
			profundidade(no.getRight(), p+1);
			System.out.println(no.getKey() + " (" + p + ")");
			profundidade(no.getLeft(), p+1);
		}
	}

	int altura(Node no){
		if(no == null)
			return -1;

		int hesq = altura(no.getRight());
		int hdir = altura(no.getLeft());

		if(hesq > hdir)
			return hesq + 1;
		else
			return hdir + 1;
	}

	boolean completa(Node no){
		if(no == null)
			return false;

		int filho = 0;
		boolean esq = completa(no.getRight());
		boolean dir = completa(no.getLeft());

		if(no.getRight() != null && (filho == 2))
			filho++;
		if(no.getLeft() != null)
			filho++;

		if(esq && dir)
			return true;
		else
			return false;
	}

	boolean cheia(Node no){
		if(no == null)
			return true;

		int filho = 0;

		boolean esq = cheia(no.getRight());
		boolean dir = cheia(no.getLeft());

		if(no.getRight() != null)
			filho++;
		if(no.getLeft() != null)
			filho++;

		if(esq && dir && (filho != 1))
			return true;
		else
			return false;
	}
	
}
