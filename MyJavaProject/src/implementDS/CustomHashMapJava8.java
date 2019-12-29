package implementDS;

import java.util.ArrayList;
import java.util.LinkedList;

//  troubles  : if negative array index out of bound :  it is fine. Handled by Mod function
// null pointer if key is not existing
public class CustomHashMapJava8<K,V> {
	
	int SIZE;
	
	ArrayList<LinkedList<CustomHashMapNode<K,V>>> data ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode()); */
		
		/*CustomHashMapJava8<Integer, Integer> map = new CustomHashMapJava8<Integer, Integer>();
		map.put(100, 101);
		map.put(100, 102);
		map.put(-100, 102);
		map.put(-100, 105);
		System.out.println(map.get(100));
		System.out.println(map.get(-100));  */
		
		CustomHashMapJava8<Integer, Double> doubleMap = new CustomHashMapJava8<Integer, Double>();
		doubleMap.put(100, 200.50);
		doubleMap.put(-100, 200.50);
		doubleMap.put(100, 300.50);
		doubleMap.put(-100, 400.50);
		
		System.out.println(doubleMap.get(100));
		System.out.println(doubleMap.get(-100));
		System.out.println(doubleMap.get(-120));

	}
	
	CustomHashMapJava8() {	
		SIZE = 100;
		data = new ArrayList<LinkedList<CustomHashMapNode<K,V>>>();
		for(int i=0; i < SIZE; i++) {
			data.add(new LinkedList<CustomHashMapNode<K,V>>());
		}
		//data.forEach(list -> System.out.println(list));
	} 
	
	public void put (K key, V value) {
		int index = key.hashCode() % SIZE;
		if (index < 0 ) {
			 index = index * -1;
		}
		CustomHashMapNode<K,V> node = new CustomHashMapNode<K,V>(key,value);
		if(data.get(index) == null) {
			data.add(index, new LinkedList<CustomHashMapNode<K,V>>());
		}
		CustomHashMapNode<K,V> targetNode = 
		data.get(index)
		.stream()
		.filter(x -> key.equals(x.getKey()))
		.findAny()
		.orElse(null);
		
		if(targetNode!= null ) {
			targetNode.setValue(value);
		} else {
			data.get(index).add(node);
		}
		
		
	}
	
	public V get (K key) {
		int index = key.hashCode() % SIZE;
		if (index < 0 ) {
			 index = index * -1;
		}
		CustomHashMapNode<K,V> targetNode =  
				data.get(index)
				.stream()
				.filter(node -> key.equals(node.getKey()))
				.findFirst()
				.orElse(null);
		if(targetNode == null) {
			return null; 
		} else {
			return targetNode.getValue();
		}

		
	}
	
	

}
