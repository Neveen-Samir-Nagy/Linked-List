package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * . public
 *
 * @author EL-hamd
 *
 */
public class Linked_List implements ILinkedList {

	/**.
	 * . Node
	 */
	private Node head;
	/**
	 * . int
	 */
	private int size;

	/**
	 * . Linked
	 */
	public Linked_List() {
		head = null;
		size = 0;
	}

	@Override
	public final void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		Node curr = head;
		Node temp = new Node(element, null);

		if (index > size || index < 0) {
			throw new UnsupportedOperationException("Error");
		}
		if (index == 0) {
			temp.setNext(head);
			head = temp;
		} else {
			for (int i = 1; i < index; i++) {
				curr = curr.getNext();
			}
			temp.setNext(curr.getNext());
			curr.setNext(temp);
		}
		size++;
	}

	@Override
	public final void add(final Object element) {
		// TODO Auto-generated method stub
		Node curr1 = head;
		Node temp = new Node(element, null);

		if (head == null) {
			head = temp;
		} else {
			while (curr1.getNext() != null) {
				curr1 = curr1.getNext();
			}

			curr1.setNext(temp);
		}
		size++;
	}

	@Override
	public final Object get(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new UnsupportedOperationException("Error");
		}
		Node curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.getNext();
		}

		return curr.getData();
	}

	@Override
	public final void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index > size || index < 0) {
			throw new UnsupportedOperationException("Error");
		}
		Node curr = head;
		Node temp = new Node(element, null);
		if (index == 0) {
			temp.setNext(curr.getNext());
			head = temp;
		} else {
			for (int i = 0; i < index - 1; i++) {
				curr = curr.getNext();
			}
			temp.setNext(curr.getNext().getNext());
			curr.setNext(temp);

		}
		if (index == size) {
			size++;
		}
	}

	@Override
	public final void clear() {
		// TODO Auto-generated method stub
		head = null;
		size = 0;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null || size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public final void remove(final int index) {
		// TODO Auto-generated method stub
		Node curr = head;
		if (head == null) {
			throw new UnsupportedOperationException("Error");
		}
		if (index == 0) {
			head = head.getNext();
		} else if (index > 0 && index < size) {
			for (int i = 0; i < index - 1; i++) {
				curr = curr.getNext();
			}
			curr.setNext(curr.getNext().getNext());
		} else {
			throw new UnsupportedOperationException("Error");
		}

		size--;
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public final ILinkedList sublist(
			final int fromIndex,
			final int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex < 0
				||
				fromIndex > size || toIndex < 0
				||
				toIndex > size
				||
				toIndex < fromIndex) {
			throw new UnsupportedOperationException("Error");
		}
		ILinkedList sLinkedList = new Linked_List();

		Object o;
		for (int i = fromIndex; i <= toIndex; i++) {
			o = get(i);
			sLinkedList.add(o);
		}
		return sLinkedList;
	}

	@Override
	public final boolean contains(final Object o) {
		// TODO Auto-generated method stub
		int i;
		if (head != null) {
			Node curr = head;
			for (i = 0; i < size; i++) {
				if (curr.getData().equals(o)) {
					return true;
				}
				curr = curr.getNext();
			}
		}
		return false;
	}
}