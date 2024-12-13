
public class Main {
	public static void main(String[] args) {
		
		BinarySearchTree BST1 = new BinarySearchTree();
		BST1.Add(8);
		BST1.Add(6);
		BST1.Add(7);
		BST1.Add(9);
		BST1.delete(1);
		BST1.delete(7);
		BST1.delete(9);
		BST1.delete(6);
	}
}