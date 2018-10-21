package Acollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AList<E> implements List<E> {

	E[] array;

	public AList() {
		array = (E[]) new Object[0];
	}

	@Override
	public boolean add(E e) {
		E[] t = (E[]) new Object[size() + 1];
		for (int i = 0; i < size(); i++) {
			t[i] = array[i];
		}
		t[size()] = e;

		array = t;
		return true;
	}

	@Override
	public void add(int index, E e) {

		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Pogrešan indeks!");
		}

		E[] t = (E[]) new Object[size() + 1];

		for (int i = 0; i < index; i++) {
			t[i] = array[i];
		}
		t[index] = e;
		for (int i = index + 1; i < size() + 1; i++) {
			t[i] = array[i - 1];
		}
		array = t;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {

		E[] t = (E[]) new Object[size() + c.size()];
		E[] t1 = (E[]) c.toArray();

		for (int i = 0; i < size(); i++) {
			t[i] = array[i];
		}
		for (int i = size(); i < t.length;) {
			for (int j = 0; j < t1.length;) {
				t[i] = t1[j];
				i++;
				j++;
			}
		}
		array = t;
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub

		E[] t = (E[]) new Object[size() + c.size()];

		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (c == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i < index; i++) {
			t[i] = array[i];
		}

		E[] t1 = (E[]) c.toArray();
		for (int i = index; i < index + t1.length;) {
			for (int j = 0; j < t1.length;) {
				t[i] = t1[j];
				i++;
				j++;
			}
		}

		for (int i = index + c.size(); i < t.length;) {
			for (int j = index; j < size();) {
				t[i] = array[j];
				i++;
				j++;
			}
		}

		array = t;

		return false;
	}

	@Override
	public void clear() {
		E[] temp = (E[]) new Object[0];
		array = temp;

	}

	@Override
	public boolean contains(Object o) {
		boolean contain = false;

		for (int i = 0; i < size(); i++) {
			if (array[i] == o) {
				contain = true;
				break;
			}
		}

		return contain;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		E[] temp = (E[]) c.toArray();
		
		for(int i = 0; i < temp.length; i++) {
				if(!contains(temp[i])) {
					return false;
				}
		}
		
		return true;
	}

	@Override
	public E get(int index) {
		if (index > size() && index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else
		return array[index];
		
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		if (contains(o)) {
			for (int i = 0; i < size(); i++) {
				if (array[i].equals(o)) {
					index = i;
					break;
				}
			}
		} else {
			throw new IllegalArgumentException("Nema otog vode!");
		}
		return index;
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
	public int lastIndexOf(Object o) {
		int index = 0;
		if (contains(o) && size() != 0) {
			for (int i = size() - 1; i >= 0; i--) {
				if (array[i] == o) {
					index = i;
					break;
				}
			}
		} else {
			throw new IllegalArgumentException("Nema otog vode!");
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		
		ListIterator<E> iterator = new ListIterator<E>() {
			
			int index = 0;

			@Override
			public void add(E e) {
				// TODO Auto-generated method stub
				add(e);
				index++;
				
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < size() && array[index] != null;
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return index > 0 && array[index] != null;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				if(index == size() - 1) {
					throw new IndexOutOfBoundsException();
				}
				return array[index++];
			}

			@Override
			public int nextIndex() {
				// TODO Auto-generated method stub
				if(index == size() - 1) {
					throw new IndexOutOfBoundsException();
				}
				return index++;
			}

			@Override
			public E previous() {
				// TODO Auto-generated method stub
				if (index  == 0) {
					throw new IndexOutOfBoundsException();
				}
				return array[index--];
			}

			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				if (index  == 0) {
					throw new IndexOutOfBoundsException();
				}
				return index--;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				AList.this.remove(get(index));
				
			}

			@Override
			public void set(E e) {
				// TODO Auto-generated method stub
				AList.this.set(index, e);
			}
		};
		
		return iterator;
	}

	@Override
	public ListIterator<E> listIterator(int firstIndex) {
		// TODO Auto-generated method stub
			ListIterator<E> iterator = new ListIterator<E>() {
				
				int index = firstIndex;

				@Override
				public void add(E e) {
					// TODO Auto-generated method stub
					add(e);
					index++;
					
				}

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return index < size() && array[index] != null;
				}

				@Override
				public boolean hasPrevious() {
					// TODO Auto-generated method stub
					return index > 0 && array[index] != null;
				}

				@Override
				public E next() {
					// TODO Auto-generated method stub
					if(index == size() - 1) {
						throw new IndexOutOfBoundsException();
					}
					return array[index++];
				}

				@Override
				public int nextIndex() {
					// TODO Auto-generated method stub
					if(index == size() - 1) {
						throw new IndexOutOfBoundsException();
					}
					return index++;
				}

				@Override
				public E previous() {
					// TODO Auto-generated method stub
					if (index  == 0) {
						throw new IndexOutOfBoundsException();
					}
					return array[index--];
				}

				@Override
				public int previousIndex() {
					// TODO Auto-generated method stub
					if (index  == 0) {
						throw new IndexOutOfBoundsException();
					}
					return index--;
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub
					AList.this.remove(get(index));
					
				}

				@Override
				public void set(E e) {
					// TODO Auto-generated method stub
					AList.this.set(index, e);
				}
		};
		
		return iterator;
	}

	@Override
	public boolean remove(Object o) {

		E[] temp = (E[]) new Object[size() - 1];
		
		if (contains(o)) {
			int index = indexOf(o);
			
			for(int i = 0; i < index; i++) {
				temp[i] = array[i];
			}
			for(int i = index; i < temp.length; i++) {
				temp[i] = array[i + 1];
			}
			
			array = temp;
			
			return true;
		}else {
			
			return false;
		}
	}
	@Override
	public E remove(int index) {
		return array[index] = null;

	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		E[] temp = (E[]) c.toArray();
		for(int i = 0; i < size();i++) {
			for(int j = 0; j < temp.length; j++) {
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
		for(int i = 0; i < size(); i++) {
			if(!c.contains(array[i]))
				remove(array[i]);
		}
		return true;
	}

	@Override
	public E set(int index, E e) {

		if (size() == 0) {
			E[] temp = (E[]) new Object[index];
			for (int i = 0; i < index; i++) {
				temp[i] = null;
			}
			temp[index] = e;
			array = temp;

		}

		if (index < 0 || index > size())
			throw new ArrayIndexOutOfBoundsException("Nejma tolko indeksa.");
		else
			array[index] = e;
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return array.length;
	}

	@Override
	public List<E> subList(int first, int last) {

		if (first < 0 || last > size()) {
			throw new ArrayIndexOutOfBoundsException("Nejma tolko indeksa.");
		}

		List<E> temp = new ArrayList<>();
		for (int i = first; i <= last; i++) {
			temp.add(get(i));
		}
		return temp;
	}

	@Override
	public Object[] toArray() {

		return (Object[]) array;
	}

	@Override
	public <T> T[] toArray(T[] old) {
		return (T[]) old;
	}

}
