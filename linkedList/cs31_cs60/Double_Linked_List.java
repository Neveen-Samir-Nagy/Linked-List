package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * . Public
 *
 * @author EL-hamd
 *
 */
public class Double_Linked_List implements ILinkedList {

	/**.
	 * . Dnode
	 */
	private DNode head = new DNode(null, null, null);

	/**
	 * . DNode
	 */
	private DNode tail = new DNode(null, null, head);

	/**
	 * . int
	 */
	private int size;

	/**
	 *
	 * . Double
	 */
	public Double_Linked_List() {
		size = 0;
		head.setNext(tail);
	}

	@Override
	public final void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		DNode curr = head.getNext();
		DNode temp = new DNode(element, null, null);

		if (index > size || index < 0) {
			throw new UnsupportedOperationException("Error");
		}
		if (index == 0) {
			temp.setNext(curr);
			temp.setPrev(head);
			curr.setPrev(temp);
			head.setNext(temp);
		} else if (index == size) {
			DNode curr1 = tail.getPrev();
			temp.setPrev(curr1);
			temp.setNext(tail);
			curr1.setNext(temp);
			tail.setPrev(temp);
		} else {
			for (int i = 0; i < size; i++) {
				if (i == index - 1) {
					temp.setNext(curr.getNext());
					temp.setPrev(curr);
					(curr.getNext()).setPrev(temp);
					curr.setNext(temp);
					break;
				}
				curr = curr.getNext();
			}
		}
		size++;
	}

	@Override
	public final void add(final Object element) {
		// TODO Auto-generated method stub
		DNode temp = new DNode(element, null, null);
		if (size == 0) {
			temp.setNext(tail);
			temp.setPrev(head);
			temp.setElement(element);
			head.setNext(temp);
			tail.setPrev(temp);
		} else {
			temp.setPrev(tail.getPrev());
			temp.setNext(tail);
			DNode curr = tail.getPrev();
			tail.setPrev(temp);
			curr.setNext(temp);
		}
		size++;
	}

	@Override
	public final Object get(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new UnsupportedOperationException("Error");
		}
		DNode curr = head.getNext();
		if (index == 0) {
			return curr.getElement();
		}
		if (index == size - 1) {
			DNode curr1 = tail.getPrev();
			return curr1.getElement();
		}
		for (int i = 0; i < index; i++) {
			curr = curr.getNext();
		}

		return curr.getElement();
	}

	@Override
	public final void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index > size || index < 0) {
			throw new UnsupportedOperationException("Error");
		}
		DNode curr = head.getNext();
		DNode temp = new DNode(element, null, null);
		if (index == size) {
			size++;
			temp.setNext(tail);
			temp.setPrev(tail.getPrev());
			(tail.getPrev()).setNext(temp);
			(tail).setPrev(temp);
		} else if (index == 0) {
			temp.setPrev(head);
			temp.setNext(curr.getNext());
			(curr.getNext()).setPrev(temp);
			head.setNext(temp);
			curr.setNext(null);
			curr.setPrev(null);
		} else if (index == size - 1) {
			DNode curr1 = tail;
			temp.setNext(tail);
			temp.setPrev(curr1.getPrev().getPrev());
			(curr1.getPrev().getPrev()).setNext(temp);
			tail.setPrev(temp);
			curr1.getPrev().setNext(null);
			curr1.getPrev().setPrev(null);
		} else {
			for (int i = 0; i < index; i++) {
				curr = curr.getNext();
			}
			if (index != size) {
				temp.setNext(curr.getNext());
				temp.setPrev(curr.getPrev());
				(curr.getPrev()).setNext(temp);
				(curr.getNext()).setPrev(temp);
				curr.setNext(null);
				curr.setPrev(null);
			}
		}
	}

	@Override
	public final void clear() {
		// TODO Auto-generated method stub
		head.setNext(tail);
		size = 0;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head.getNext() == null || size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public final void remove(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || size == 0 || index < 0) {
			throw new UnsupportedOperationException("Error");
		}
		DNode curr = head.getNext();

		if (index == 0) {

			head.setNext(curr.getNext());
			(curr.getNext()).setPrev(head);
			curr.setNext(null);
			curr.setPrev(null);
		} else if (index == size - 1) {
			DNode curr1 = tail.getPrev();
			tail.setPrev(curr1.getPrev());
			(curr1.getPrev()).setNext(tail);
			curr1.setNext(null);
			curr1.setPrev(null);
		} else {
			for (int i = 0; i < index; i++) {
				curr = curr.getNext();
			}

			(curr.getPrev()).setNext(curr.getNext());
			(curr.getNext()).setPrev(curr.getPrev());
			curr.setNext(null);
			curr.setPrev(null);
		}

		size--;

	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public final ILinkedList sublist(final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex < 0
				||
				fromIndex > size
				||
				toIndex < 0 || toIndex > size
				||
				toIndex < fromIndex) {
			throw new UnsupportedOperationException("Error");
		}
		ILinkedList dLinkedList = new Double_Linked_List();

		Object o;
		for (int i = fromIndex; i <= toIndex; i++) {
			o = get(i);
			dLinkedList.add(o);
		}

		return dLinkedList;
	}

	@Override
	public final boolean contains(final Object o) {
		// TODO Auto-generated method stub
		DNode temp = head.getNext();
		if (head.getNext() != null) {
			for (int i = 0; i < size; i++) {
				if (temp.getElement().equals(o)) {
					return true;
				}
				temp = temp.getNext();

			}
		}
		return false;
	}

}