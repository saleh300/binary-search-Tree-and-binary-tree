package Tree;

public class Main {
	
	//print tree using pre order way
	public static void preOrder(BTNode<Integer> root) {
		if(root != null) {
			System.out.print(root.getItem()+" ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	//print tree using  breadth First
	public static void breadthFirst(BTNode<Character> root) {
		LinkedQueue<BTNode> item = new LinkedQueue<>() ;

		if(root != null)
			item.enqueue(root);

		while (!item.isEmpty()) {
			BTNode P1 = item.dequeue() ;
			System.out.println(P1.getItem());

			if(P1.getLeft() != null)
				item.enqueue(P1.getLeft());
			if(P1.getRight() != null)
				item.enqueue(P1.getRight());
		}
	}
	// this method is to convert the tree to expression
	public static void covertExp(BTNode<Character> p) {

		if( p == null)
			return ;

		if(p.getLeft() != null && p.getRight() != null) 
			System.out.print("(");

		covertExp(p.getLeft()) ;
		System.out.print(p.getItem());
		covertExp(p.getRight()) ;

		if(p.getLeft() != null && p.getRight() != null) 
			System.out.print(")");
	}
	
	//return the number of leaf node
	public static int getLeafCount(BTNode<Integer> root) {
		if(root == null)
			return 0 ;

		if(root.getLeft() == null && root.getRight() == null)
			return 1 ;

		return getLeafCount(root.getLeft()) + getLeafCount(root.getRight()); 
	}
	
	//return the number of parent
	public static int getParentCount(BTNode<Integer> root) {
		if(root == null)
			return 0 ;

		if(root.getLeft() == null && root.getRight() == null)
			return 0 ;

		return 1 + getParentCount(root.getLeft()) + getParentCount(root.getRight());

	}
	//to count the node that is the same given value
	static int count = 0 ;
	public static int countOccurrence(BTNode<Integer> root, int num) {

		if(root == null)
			return 0 ;

		if(root.getItem() == num) 
			count++ ;

		countOccurrence(root.getLeft(), num) ;
		countOccurrence(root.getRight(), num) ;

		return count ;
	}
	public static int coutNode(BTNode<Integer> root) {

		if(root == null)
			return 0 ;

		return 1+ coutNode(root.getLeft())+ coutNode(root.getRight()) ;

	}
	//print the sapling
	public static void noSpling(BTNode<Integer> root) {

		if(root != null) {

			if(root.getLeft() != null && root.getRight() == null) {
				System.out.println(root.getLeft().getItem());
			}
			if(root.getLeft() == null && root.getRight() != null) {
				System.out.println(root.getRight().getItem());
			}
			noSpling(root.getLeft());
			noSpling(root.getRight());
		}

	}


	//to print the path from the root to last value
	public static String PathNode(BTNode root, String path, String n) {

		if(root != null) {
			path += root.getItem()+"," ;

			if(root.getLeft() == null && root.getRight() == null && root.getItem().equals(n) == true)
				System.out.println(path);

			PathNode(root.getLeft(), path, n) ;
			PathNode(root.getRight(), path, n) ;
		}
		return path ;

	}
	//return the sum of positive value
	static int sumpos ; 
	public static int sumPostive(BTNode<Integer> root) {
		if(root == null)
			return 0 ;
		
		if(root.getItem()  > 0)
			sumpos+= root.getItem() ;

		sumPostive(root.getLeft()) ;
		sumPostive(root.getRight()) ;

		return sumpos ;

	}
	//return the max value
	static int Max = Integer.MIN_VALUE ;
	public static int MaxVal(BTNode<Integer> root) {

		if(root == null)
			return 0 ;
		if(root.getItem() > Max)
			Max = root.getItem() ;

		MaxVal(root.getLeft()) ;
		MaxVal(root.getRight()) ;
		return Max ;
	}
	
	//sum of the tree
	public static int sumation(BTNode<Integer>root)
	{
		if(root == null)
			return 0 ;

		return root.getItem()+sumation(root.getLeft()) + sumation(root.getRight()) ;
	}
	
	// this method is check if root value equals to the child's 
	public static boolean isSum(BTNode<Integer> root) {
		if(root == null)
			return true; 

		Integer l = sumation(root.getLeft());
		Integer r = sumation(root.getRight()) ;

		if((Integer)root.getItem() == (l+r))
			return true ;


		isSum(root.getLeft()) ;
		isSum(root.getRight()) ;
		return false ;
	}
	//delete the leaf node
	public static void deletLeaf(BTNode<Integer> root) {
		if(root == null)
			return ;
		if(root.getLeft() != null) {
			if(root.getLeft().getLeft() == null && root.getLeft().getRight() == null)
				root.setLeft(null);
		}
		if(root.getRight() != null) {
			if(root.getRight().getRight() == null && root.getRight().getLeft() == null)
				root.setRight(null);
		}

		deletLeaf(root.getLeft());
		deletLeaf(root.getRight());
	}
	//return the sum of odd value
	static int sumOdd = 0 ;
	public static int sumOdd(BTNode<Integer> root) {
		if(root == null)
			return 0 ;
		
		if(root.getItem() % 2 ==1)
			sumOdd+= root.getItem() ;
		
		sumOdd(root.getLeft()) ;
		sumOdd(root.getRight()) ;
		return sumOdd ;
	}

	// this method is swap between the most left value and most right value
	public static void swapMost(BTNode<Integer> root) {
		if(root == null)
			return ;
		
		BTNode<Integer> MostLeft = root ; // take the most left element in the tree
		BTNode<Integer> MostRight = root ;// take the most right element in the tree
		
		while (MostLeft.getLeft() != null) {
			MostLeft = MostLeft.getLeft() ;
		}
		while (MostRight.getRight() != null) {
			MostRight = MostRight.getRight() ;
		}
		//Swapping between the mostLeft and mostRight
		int temp = (int)MostLeft.getItem() ;
		MostLeft.setItem(MostRight.getItem());
		MostRight.setItem(temp);
	}
	public static void main(String[] args) {

		BTNode<Integer> root = new BTNode<>() ;
		root.setItem(26);
		BTNode<Integer> l1 = new BTNode<>() ;
		l1.setItem(10);
		BTNode<Integer> r1 = new BTNode<>() ;
		r1.setItem(6);
		BTNode<Integer> r2 = new BTNode<>() ;
		r2.setItem(3);
		BTNode<Integer> l2 = new BTNode<>() ;
		l2.setItem(2);
		BTNode<Integer> r3 = new BTNode<>() ;
		r3.setItem(5);
		BTNode<Integer> l3 = new BTNode<>() ;
		l3.setItem(4);

		







	}

}
