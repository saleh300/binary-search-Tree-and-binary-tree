package Tree;

public class BTNode<E> {
	
	private E item ;
	private BTNode<E> right ;
	private BTNode<E> left ;
	
	
	public BTNode() {
		item = null ;
		left = right = null ;
	}


	public E getItem() {
		return item;
	}


	public void setItem(E item) {
		this.item = item;
	}


	public BTNode<E> getRight() {
		return right;
	}


	public void setRight(BTNode<E> right) {
		this.right = right;
	}


	public BTNode<E> getLeft() {
		return left;
	}


	public void setLeft(BTNode<E> left) {
		this.left = left;
	}
	
	public boolean isLeaf() {
		return (left == null && right == null) ;
	}
}
