package stringsnarrays;

import java.util.Hashtable;

public class ArrayProblems {
	
	private boolean FindTrippletSumsToVal(int [] arr, int target) {
		Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>(); 
		//Arrays.sort(arr);
		for(int i=0; i < arr.length - 2; i++) {
			map.clear();
			if (findPairToSum(arr, target - arr[i], i+1, map )) {
				return true;
			}
		}
		return false;
	}
	
	
	private boolean findPairToSum(int[] arr, int target, int startFrom, Hashtable<Integer, Integer> map) {
		for(int i = startFrom; i < arr.length ; i ++) {
			map.put(arr[i], 1);
			if(map.containsKey(target - arr[i])) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayProblems arrayProblems =  new ArrayProblems();
		
		int[] arr = {12, 3, 4, 1, 6, -9};
		System.out.println(arrayProblems.FindTrippletSumsToVal(arr, 24));
		System.out.println(arrayProblems.FindTrippletSumsToVal(arr, -5));
	}

}
