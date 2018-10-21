package Acollections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ASet<E> implements Set<E> {

	E[] array;

	public ASet() {
		array = (E[]) new Object[0];
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		E[] temp = (E[]) new Object[size() + 1];
		if (contains(e))
			return false;
		else {
			for (int i = 0; i < size(); i++) {
				temp[i] = array[i];
			}
			temp[size()] = e;

			array = temp;
			return true;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		E[] t = (E[]) c.toArray();
		for (int i = 0; i < t.length; i++) {
			if (!contains(t[i])) {
				add(t[i]);
			}
		}
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

		E[] t = (E[]) new Object[0];
		array = t;

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		

		for (int i = 0; i < size(); i++) {
			if (array[i].equals(o)) {
				return true;
				
			}
		}

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		E[] temp = (E[]) c.toArray();

		for (int i = 0; i < temp.length; i++) {
			if (!contains(temp[i])) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> iterator = new Iterator<E>() {

			int index = 0;

			@Override
			public boolean hasNext() {

				return index < size() && array[index] != null;
			}

			@Override
			public E next() {
				return array[index++];
			}
		};
		return iterator;
	}

	@Override
	public boolean remove(Object o) {
		E[] t = (E[]) new Object[size() - 1];
		int index = 0;
		for (int i = 1; i < size(); i++) {
			if (array[i].equals(o)) {
				index = i;
			}
		}

		if (contains(o)) {

			for (int i = 0; i < index; i++) {
				t[i] = array[i];
			}
			for (int i = index; i < t.length; i++) {
				t[i] = array[i + 1];
			}

			array = t;

			return true;
		} else {

			return false;
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		E[] temp = (E[]) c.toArray();
		for (int i = 0; i < size(); i++) {
			for (int j = 0; j < temp.length; j++) {
				if (array[i].equals(temp[j])) {
					remove(array[i]);
				}
			}
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size(); i++) {
			if (!c.contains(array[i]))
				remove(array[i]);
		}
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return array.length;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return (Object[]) array;
	}

	@Override
	public <T> T[] toArray(T[] c) {
		// TODO Auto-generated method stub
		return (T[]) c;
	}

}
