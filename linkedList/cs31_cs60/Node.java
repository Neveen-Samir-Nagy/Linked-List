package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

/**
 * . DNode
 *
 * @author EL-hamd
 *
 */
public class Node {
	/**.
	 * . Node
	 */
	private Node next;
	/**
	 * . Object
	 */
	private Object data;

	/**
	 * . node
	 *
	 * @param s
	 *            first
	 * @param n
	 *       second
	 */
	public Node(final Object s, final Node n) {
		this.next = n;
		this.data = s;
	}

	/**
	 * . Object
	 *
	 * @return Object
	 */
	public Object getData() {
		return this.data;
	}

	/**
	 * . Void
	 *
	 * @param newdata
	 *            first
	 */
	public void setData(final Object newdata) {
		this.data = newdata;
	}

	/**
	 * . Node
	 *
	 * @return Node
	 */
	public Node getNext() {
		return this.next;
	}

	/**
	 * . set
	 *
	 * @param nextNode
	 *            first
	 */
	public void setNext(final Node nextNode) {
		this.next = nextNode;
	}

}
