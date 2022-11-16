package Tree;

public class BSTmain {
	public static void preOrder(BTNode<Integer> root) {

		if(root != null) {

			preOrder(root.getLeft());
			System.out.println(root.getItem());
			preOrder(root.getRight());
		}


	}

	public static void insert(BTNode<Integer> root , int data ) {

		BTNode<Integer> newNode = new BTNode<Integer>() ;
		newNode.setItem(data);
		if(root == null) {
			root = newNode ;
		}

		if(data < root.getItem()) {
			insert(root.getLeft(), data);
		}else {
			insert(root.getRight(), data);
		}

	}
	public static boolean attach(BSTNode Rtree1, BSTNode Rtree2) {

		int num  ;
		if((int)Rtree1.getData() > (int)Rtree2.getData()) { 
			num = maxValue(Rtree2.getLeft()) ;
			return (num < (int)Rtree1.getData()) ;	
		}else {
			num = minValue(Rtree2.getRight()) ;
			return (num <= (int)Rtree1.getData()) ;
		}
	}
	public static int minValue(BSTNode root) {
		if(root == null)
			return 0 ;

		BSTNode trav = root ;
		while (trav.getLeft() != null) {
			trav = trav.getLeft() ;
		}
		return (int)trav.getData() ;

	}
	public static int maxValue(BSTNode root) {

		if(root == null)
			return 0 ;
		if(root.getRight() == null)
			return (int)root.getData() ;

		return maxValue(root.getRight()) ;
	}


	public static void main(String[] args) {

		BSTree<Integer, Integer> myt = new BSTree<>() ;

		myt.insert(50, 50);
		myt.insert(40, 40);
		myt.insert(30, 30);
		myt.insert(20, 20);
		myt.insert(48, 48);
		myt.insert(60, 60);
		myt.insert(55, 55);
		myt.insert(58, 58);
		myt.insert(70, 70);
		

		BSTree<Integer, Integer> myt2 = new BSTree<>() ;


		myt2.insert(45, 45);
		myt2.insert(42, 42);
		myt2.insert(41, 41);
		myt2.insert(47, 47);
		myt2.insert(46, 46);
		myt2.insert(43, 43);
		
//		myt.print();
		System.out.println("=============");
		System.out.println(attach(myt.root, myt2.root)) ;



	}

}
