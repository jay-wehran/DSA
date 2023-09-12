/**
 * From CSE017 lecture 10 slide deck;
 * 2023-06-27
 */

 public class HashMapEntry<K, V> {
    private K key;
    private V value;

    public HashMapEntry(K k, V v) {
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K k) {
        key = k;
    }

    public void setValue(V v) {
        value = v;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

