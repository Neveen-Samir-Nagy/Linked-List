package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

/**
 * . Public
 *
 * @author EL-hamd
 *
 */
public class DNode {

	/**.
	 * . Object
	 */
	private Object element;
	/**
	 * . Dnode
	 */
	private DNode next, prev;

	/**
	 * . Dnode
	 *
	 * @param newelement
	 *            first
	 * @param newnext
	 *            seconed
	 * @param newprev
	 *            third
	 */
	public DNode(final Object newelement,
			final DNode newnext,
			final DNode newprev) {
		this.element = newelement;
		this.next = newnext;
		this.prev = newprev;
	}

	/**
	 * . Object
	 *
	 * @return Object
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * . DNode
	 *
	 * @return DNode
	 */
	public DNode getPrev() {
		return prev;
	}

	/**
	 * . DNode1
	 *
	 * @return DNode
	 */
	public DNode getNext() {
		return next;
	}

	/**
	 * . Void
	 *
	 * @param newElement
	 *            first
	 */
	public void setElement(final Object newElement) {
		element = newElement;
	}

	/**
	 * . Void1
	 *
	 * @param newPrev
	 *            first
	 */
	public void setPrev(final DNode newPrev) {
		prev = newPrev;
	}

	/**
	 * . Void2
	 *
	 * @param newNext
	 *            second
	 */
	public void setNext(final DNode newNext) {
		next = newNext;
	}
}
