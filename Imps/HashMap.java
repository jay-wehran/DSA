import java.util.ArrayList;
import java.util.LinkedList;
 
 /**
  * Hash Table with chaining, uses Linked list as 2ndary structure
  */
 public class HashMap<K, V> {
     private int size;
     private double loadFactor;
     private LinkedList<HashMapEntry<K, V>>[] hashTable;
 
     // Constructors
     // O(log n)
     public HashMap() {
         this(100, 0.9);
     }
 
     // O(log n)
     public HashMap(int c) {
         this(c, 0.9);
     }
 
     // O(log n)
     public HashMap(int c, double lf) {
         hashTable = new LinkedList[trimToPowerOf2(c)];
         loadFactor = lf;
         size = 0;
     }
 
     // private methods
     // O(log n)
     private int trimToPowerOf2(int c) {
         int capacity = 1;
         while (capacity < c)
             capacity = capacity << 1; // sams as (capacity * 2)
         return capacity;
     }
 
     // O(1)
     private int hash(int hashCode) {
         return hashCode & (hashTable.length - 1); // use bit mask to create valid index
     }
 
     private void rehash() {
         ArrayList<HashMapEntry<K, V>> list = toList(); // get all current elements O(n)
         hashTable = new LinkedList[hashTable.length << 1]; // make a new table of double size
         size = 0;
         for (HashMapEntry<K, V> entry : list) // put all items back into the new table ... outer is O(n)
             put(entry.getKey(), entry.getValue());
     }
 
     // public interface
     public int size() {
         return size;
     }
 
     public void clear() {
         size = 0;
         for (int i = 0; i < hashTable.length; i++)
             if (hashTable[i] != null)
                 hashTable[i].clear();
     }
 
     public boolean isEmpty() {
         return (size == 0);
     }
 
     // search for key - returns true if found
     public boolean containsKey(K key) {
         if (get(key) != null)
             return true;
         return false;
     }
 
     // returns the value of key if found, null otherwise
     public V get(K key) {
         int HTIndex = hash(key.hashCode());
         if (hashTable[HTIndex] != null) {
             LinkedList<HashMapEntry<K, V>> ll = hashTable[HTIndex];
             for (HashMapEntry<K, V> entry : ll) {
                 if (entry.getKey().equals(key))
                     return entry.getValue();
             }
         }
         return null;
     }
 
     // remove a key if found
     public void remove(K key) {
         int HTIndex = hash(key.hashCode());
         if (hashTable[HTIndex] != null) { // key is in the hash map
             LinkedList<HashMapEntry<K, V>> ll = hashTable[HTIndex];
             for (HashMapEntry<K, V> entry : ll) {
                 if (entry.getKey().equals(key)) {
                     ll.remove(entry);
                     size--;
                     break;
                 }
             }
         }
     }
 
     // adds a new key or modifies an existing key
     public V put(K key, V value) {
         if (get(key) != null) { // The key is in the hash map
             int HTIndex = hash(key.hashCode());
             LinkedList<HashMapEntry<K, V>> ll;
             ll = hashTable[HTIndex];
             for (HashMapEntry<K, V> entry : ll) {
                 if (entry.getKey().equals(key)) {
                     V old = entry.getValue();
                     entry.setValue(value);
                     return old;
                 }
             }
         }
         // key not in the hash map - check load factor...
         if (size >= hashTable.length * loadFactor)
             rehash();
         int HTIndex = hash(key.hashCode());
         // create a new LL if empty
         if (hashTable[HTIndex] == null) {
             hashTable[HTIndex] = new LinkedList<>();
         }
         hashTable[HTIndex].add(new HashMapEntry<>(key, value));
         size++;
         return value;
     }
 
     // returns the elements of the hash map as a list
     // O(n)
     public ArrayList<HashMapEntry<K, V>> toList() {
         ArrayList<HashMapEntry<K, V>> list = new ArrayList<>();
         for (int i = 0; i < hashTable.length; i++) {  // O(n)
             if (hashTable[i] != null) {
                 LinkedList<HashMapEntry<K, V>> ll = hashTable[i];
                 for (HashMapEntry<K, V> entry : ll) // O(n)
                     list.add(entry);
             }
         }
         return list;
     }
 
     // returns the elements of the hash map as a string
     // O(n)
     public String toString() {
         String out = "[";
         for (int i = 0; i < hashTable.length; i++) {
             if (hashTable[i] != null) {
                 for (HashMapEntry<K, V> entry : hashTable[i])
                     out += entry.toString();
                 out += "\n";
             }
         }
         out += "]";
         return out;
     }
 
     public static void main(String[] args) {
         HashMap<String, String> states = new HashMap<>(10);
         states.put("PA", "Pennsylvania");
         states.put("NY", "New York");
         states.put("MA", "Massachusetts");
         states.put("CA", "California");
         states.put("NJ", "New Jersey");
         states.put("OH", "Ohio");
         states.put("NM", "New Mexico");
         states.put("WA", "Washington");
 
         System.out.println(states);
         System.out.println("Code NJ is for " + states.get("NJ"));
         System.out.println("NY is in the map? " +
                 states.containsKey("NY"));
         states.remove("MA");
         System.out.println("MA is in the map (after removal)? " + states.containsKey("MA") );
         System.out.println(states);
         states.clear();
         System.out.println(states);
     }
 
 }
 
