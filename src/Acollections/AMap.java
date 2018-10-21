package Acollections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AMap<K, V> implements Map<K, V> {

	K[] keys;
	V[] values;

	public AMap() {
		keys = (K[]) new Object[0];
		values = (V[]) new Object[0];
	}

	@Override
	public void clear() {
		keys = (K[]) new Object[0];
		values = (V[]) new Object[0];
	}

	@Override
	public boolean containsKey(Object o) {
		boolean containsObject = false;

		for (int i = 0; i < size(); i++) {
			if (keys[i].equals(o)) {
				containsObject = true;
				break;
			}
		}

		return containsObject;
	}

	@Override
	public boolean containsValue(Object o) {
		boolean containsObject = false;

		for (int i = 0; i < size(); i++) {
			if (values[i].equals(o)) {
				containsObject = true;
				break;
			}
		}

		return containsObject;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		ASet<Entry<K, V>> pairSet = new ASet<>();
		Entry<K, V> e = new Entry<K, V>() {

			@Override
			public K getKey() {
				// TODO Auto-generated method stub
				return keys[0];
			}

			@Override
			public V getValue() {
				// TODO Auto-generated method stub
				return values[0];
			}

			@Override
			public V setValue(V v) {
				// TODO Auto-generated method stub
				return values[0] = v;
			}
		};
		pairSet.add(e);
		return pairSet;
	}

	@Override
	public V get(Object o) {
		// TODO Auto-generated method stub
		if (!containsKey(o)) {
			throw new IllegalArgumentException("Otog elementa nema evodj!");
		}
		V element = values[0];
		for (int i = 1; i < keys.length; i++) {
			if (keys[i].equals(o)) {
				return element = values[i];
			}
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		ASet<K> setOfKeys = new ASet<>();
		for (int i = 0; i < keys.length; i++) {
			setOfKeys.add(keys[i]);
		}
		return setOfKeys;
	}

	@Override
	public V put(K k, V v) {
		
		if (!containsKey(k)) {
			K[] tempK = (K[]) new Object[size() + 1];
			V[] tempV = (V[]) new Object[size() + 1];
			for (int i = 0; i < size(); i++) {
				tempK[i] = keys[i];
				tempV[i] = values[i];
			}
			tempK[size()] = k;
			tempV[size()] = v;
			
			keys = tempK;
			values = tempV;
			return v;
		} else {
			return null;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		ASet<K> keysS = (ASet<K>) m.keySet();
		ASet<V> valuesS = (ASet<V>) m.values();
		
		Iterator<K> keysIterator = keysS.iterator();
		Iterator<V> valuesIterator = valuesS.iterator();
		
		while(keysIterator.hasNext() && valuesIterator.hasNext()) {
			if(!containsKey(keysIterator.next())) {
				put(keysIterator.next(), valuesIterator.next());
			}
		}

	}

	@Override
	public V remove(Object o) {
		// TODO Auto-generated method stub
		V value = values[0];
		K[] tempK = (K[]) new Object[size() - 1];
		V[] tempV = (V[]) new Object[size() - 1];
		int index = 0;
		for(int i = 0; i < keys.length; i++) {
			if (keys[i].equals(o)) {
				index = i;
				break;
			}
		}
		
		for (int i = 0; i < index; i++) {
			tempK[i] = keys[i];
			tempV[i] = values[i];
		}
		
		for (int i = index; i < tempK.length; i++) {
			tempK[i] = keys[i + 1];
			tempV[i] = values[i + 1];
		}
		
		keys = tempK;
		values = tempV;
		
		return values[index];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return values.length;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		AList<V> valuesList = new AList<>();
		for (int i = 0; i < values.length; i++) {
			valuesList.add(values[i]);
		}
		return valuesList;
	}

}
