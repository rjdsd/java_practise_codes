package implementDS;

import java.util.ArrayList;
import java.util.LinkedList;

	
	class CustomHashMapNode<K,V> {
	
		K key;
		V value;
				
		CustomHashMapNode(K key, V value) {
			this.key = key;
			this.value = value;			
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
		
	}
	
	
	class CustomHashMap<K,V> {
		
		int SIZE = 10;
		
		ArrayList<LinkedList<CustomHashMapNode<K,V>>>  map = 
				new ArrayList<LinkedList<CustomHashMapNode<K,V>>>(); 
		
		public CustomHashMap() {
			// TODO Auto-generated constructor stub
			for(int i = 0; i < SIZE; i++) {
				map.add(new LinkedList<CustomHashMapNode<K,V>>());
			}
		}
		
		public void put (K key, V value) {
			int index = key.hashCode() % SIZE;
			CustomHashMapNode<K,V> cur = new CustomHashMapNode<K,V>(key,value);
			LinkedList<CustomHashMapNode<K,V>> list = map.get(index);
			for (CustomHashMapNode<K,V> node : list) {
				if(node.getKey().equals(key)) {
					node.setValue(value);
					return;
				}			
			}
			list.add(cur);			
		}
		
		
		public V get(K key) {
			//  find the index position
			int index = key.hashCode() % SIZE;
			// find the  linkList stored at the index position
			LinkedList<CustomHashMapNode<K,V>> list =  map.get(index);
			if (list == null) {
				return null;
			}
			// search for the node when key matches
			else {
				for (CustomHashMapNode<K,V> node : list) {
					if(node.getKey().equals(key)) {
						return node.getValue();
					}			
				}
			}
			return null;			
		}		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode()); */
		
		CustomHashMap<Integer, Integer> map = new CustomHashMap<Integer, Integer>();
		map.put(100, 101);
		map.put(100, 102);
		map.put(-100, 102);
		map.put(-100, 105);
		System.out.println(map.get(100));
		System.out.println(map.get(-100));
		
		CustomHashMap<Integer, Double> doubleMap = new CustomHashMap<Integer, Double>();
		doubleMap.put(100, 200.50);
		doubleMap.put(-100, 200.50);
		doubleMap.put(100, 100.50);
		doubleMap.put(-100, 100.50);
		System.out.println(doubleMap.get(100));
		System.out.println(doubleMap.get(-100));

	}

}
