package carrental.datastructureimpl;

public class MapEntry<K,V> {
	private final K key;
	private V value;
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public MapEntry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	
	
}
