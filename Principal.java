import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada =new Scanner(System.in);
		ABB abb = new ABB();
		abb.insert(30);
		abb.insert(50);
		abb.insert(20);
		abb.insert(10);
		abb.insert(5);
		abb.insert(12);
		abb.insert(25);
		abb.insert(40);
		abb.insert(60);
		abb.insert(55);
		abb.insert(65);
		
		System.out.println("PERCURSO EM ORDEM");
		abb.percursoEmOrdem(abb.root);

		System.out.println("\nPERCURSO PREORDEM");
		abb.percursoPreOrdem(abb.root);

		System.out.println("\nPERCURSO POSORDEM");
		abb.percursoPosOrdem(abb.root);

		System.out.println("\nALTURA ATUAL: " + abb.altura(abb.root));

		System.out.println("\nBUSCA");
		Node nSearch = abb.searchKey(55, abb.root);
		if(nSearch != null)
			System.out.println("Key: " + nSearch.getKey() /*+ "\n Left: " + nSearch.getLeft().getKey() + "\nRight: " + nSearch.getRight().getKey()*/);
		else
			System.out.println("KEY NOT FOUND");

		System.out.println("\nMAX: "+ abb.max(abb.root).getKey());
		System.out.println("\nMIN: "+ abb.min(abb.root).getKey());

		System.out.println("\nPredecessor de 20: " + abb.getPredecessor(abb.root).getKey());
		System.out.println("\nSucessor de 20: " + abb.getSucessor(abb.root).getKey());

		tipoArvore(abb);

		System.out.println("\nAPÓS REMOVER: 25");
		abb.remove(25);
		abb.percursoEmOrdem(abb.root);

		System.out.println("\nALTURA ATUAL: " + abb.altura(abb.root));

		System.out.println(abb.getSucessor(abb.searchKey(55, abb.root)).getKey());
		abb.profundidade(abb.root, 0);
		System.out.println(abb.altura(abb.root));

		tipoArvore(abb);

	}

	private static void tipoArvore(ABB abb) {
		System.out.print("Tipo de árvore: ");
		if(abb.cheia(abb.root))
			System.out.println("Completa Cheia");
		else if(!abb.cheia(abb.root) && !abb.completa(abb.root))
			System.out.println("Não cheia e Não completa");
		else
			System.out.println("Não cheia e Completa");
	}		

}
