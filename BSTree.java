package Tree;

import Sorting.BST;

public class BSTree<K extends Comparable<K>, T> {

	public BSTNode<K, T> root ;


	
	//calling helper method
	public void print() {
		print(root);
	}
	//helper method to print the BST in order
	private void print(BSTNode root) {
		if(root != null) {
			print(root.getLeft());
			System.out.println(root.getData());
			print(root.getRight());
		}
	}

	
	//calling helper method
	public T findMin() {
		return minValue(root) ;
	}
	//helper method to find the minimum value of BST 
	private T minValue(BSTNode root) {
		if(root == null)
			return null ;

		BSTNode trav = root ;
		while (trav.getLeft() != null) {
			trav = trav.getLeft() ;
		}
		return (T)trav.getData() ;

	}
	
	//calling helper method
	public T findMax() {
		return maxValue(root) ;
	}
	//helper method to find the maximum value of BST 
	private T maxValue(BSTNode root) {

		if(root == null)
			return null ;
		if(root.getRight() == null)
			return (T)root.getData() ;

		return maxValue(root.getRight()) ;
	}
	
	//calling helper method
	public boolean isBST() {
		return isBST(root) ;
	}
	// this method to check if is it BST or not
	private boolean isBST(BSTNode root) {
		if(root == null)
			return false ;

		if(root.getLeft() != null && (Integer)maxValue(root.getLeft()) > (Integer)root.getKey())
			return false ;

		if(root.getRight() != null && (Integer)minValue(root.getRight()) < (Integer)root.getKey()) 
			return false ;

		isBST(root.getLeft()) ;
		isBST(root.getRight()) ;
		return true ;
	}
	
	//calling helper method
	public int sum() {
		return sum(root);
	}
	//return the sum of BST
	private int sum(BSTNode root) {

		if(root ==null)
			return 0 ;

		return (Integer)root.getData()+ sum(root.getLeft()) + sum(root.getRight()) ;
	}
	
	//calling helper method
	public int CountNodes() {
		return countNodes(root) ;
	}
	//return the number of nodes in BST
	private int countNodes(BSTNode root) {
		if(root == null)
			return 0 ;
		return 1+ countNodes(root.getLeft()) + countNodes(root.getRight()) ;
	}
	
	//calling helper method
	public boolean contains(T data) {
		return search(root, (Integer)data) ;
	}
	//search for the value 
	private boolean search(BSTNode root , Integer data) {

		if(root != null) {
			if(root.getData() == data)
				return true ;

			return search(root.getLeft(), data) || search(root.getRight(), data) ;
		}
		return false ;
	}
	
	//calling helper method
	public int getLeafNode() {
		return leafNode(root) ;
	}
	//return the number of leaf node that have no child
	private int leafNode(BSTNode root) {

		if(root == null)
			return 0 ;

		if(root.getLeft() == null && root.getRight() == null)
			return 1 ;

		return leafNode(root.getLeft()) + leafNode(root.getRight()) ;
	}
	
	//calling helper method
	public void printPath(K value) {
		String path = "" ;
		pathNode(root, path, value);
	}
	//to print the path from the root the last node 
	private void pathNode(BSTNode<K, T> root ,String path, K value) {

		if(root == null)
			return ;

		path+= root.getData()+" " ;

		if(root.getKey().compareTo(value) == 0) {
			System.out.println(path);
			return ;
		}
		if(root.getKey().compareTo(value) > 0)
			pathNode(root.getLeft(), path, value);
		else
			pathNode(root.getRight(), path, value);
	}
	
	//calling helper method
	public void PrintBetween(int x, int y) {
		Between(root, x, y);
	}
	//to print the value between 2 given value
	private void Between(BSTNode root, int x, int y) {

		if(root != null) {
			if((Integer)root.getData() >= x && (Integer)root.getData() < y) {
				System.out.println(root.getData());
			}
			Between(root.getLeft(), x, y);
			Between(root.getRight(), x, y);
		}
	}
	//calling helper method
	public T search(K k) {
		BSTNode<K, T> n = Find(root, k) ;
		if(n == null)
			return null ;
		else
			return n.getData() ;
	}
	// search for element but using the iterative way
	private BSTNode Find(BSTNode<K, T> root, K key) {
		BSTNode<K, T> trav = root ;

		if(trav == null)
			return null ;
		while (trav != null) {
			if(key.compareTo(trav.getKey()) == 0)
				return trav ;
			if(key.compareTo(trav.getKey()) > 0)
				trav = trav.getLeft() ;
			else
				trav = trav.getRight() ;
		}
		return null ;
	}

	//calling helper method
	public void PrintRevers() {
		revers(root);
	}
	//this method print the BST from the large number to small
	private void revers(BSTNode<K, T> root) {

		if(root != null) {
			revers(root.getRight());
			System.out.println(root.getData());
			revers(root.getLeft());
		}

	}
	
	//calling helper method

	public void printParent() {
		printParent(root);
	}
	// print parent the have a least one child
	private void printParent(BSTNode<K, T> root) {

		if(root != null) {
			if(root.getLeft() == null && root.getRight() != null)
				System.out.println(root.getData());
			printParent(root.getLeft());
			printParent(root.getRight());
		}
	}
	public void printRinge(int low, int hight) {
		printRange(root, low, hight);
	}
	private void printRange(BSTNode root, int low, int hight) {

		if(root != null) {

			printRange(root.getLeft(), low, hight);
			if((int)root.getData() >= low && (int)root.getData() <= hight)
				System.out.println(root.getData());
			printRange(root.getRight(), low, hight);

		}
	}
	public void insert(K key, T data) {
		root =insert(root, key, data);
	}
	private BSTNode<K, T> insert(BSTNode<K, T>root, K key, T data) {
		if(root == null) {
			return new BSTNode(key, data) ;
		}

		if(key.compareTo(root.getKey()) < 0)
			root.setLeft(insert(root.getLeft(), key, data));
		else
			root.setRight(insert(root.getRight(), key, data));

		return root ;

	}
	//calling helper method

	public void printSmallest() {
		smallestThree(root);
	}
	
	//this method is to print the smallest 3 element in BST
	static int val = Integer.MAX_VALUE ;
	static int val2 = Integer.MAX_VALUE ;
	static int val3 = Integer.MAX_VALUE ;
	private void smallestThree(BSTNode root) {

		if (root==null)
			return;
		if(root != null){
			if ((int)root.getData() < val){
				val = (int)root.getData() ;
			}
			if((int)root.getData()  < val2 && (int)root.getData() > val){
				val2 = (int)root.getData() ;
			}
			if((int)root.getData()  < val3 && (int)root.getData()  > val2){
				val3 = (int)root.getData() ;
			}
			smallestThree(root.getLeft());
			smallestThree(root.getRight());
		}
		System.out.println(val);
		System.out.println(val2);
		System.out.println(val3);
	}

	


}
