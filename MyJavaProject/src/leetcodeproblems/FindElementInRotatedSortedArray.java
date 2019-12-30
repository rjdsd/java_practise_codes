//https://leetcode.com/problems/search-in-rotated-sorted-array/
class FindElementInRotatedSortedArray {
    
    private int findPivot(int[] nums, int start, int end){
        int pivot;
        if(start>=end){
            return -1;
        }
        pivot = (start+end)/2;
        if(nums[pivot]>nums[pivot+1]){
            return pivot;
        }
        if(nums[pivot] <= nums[end]){
            return findPivot(nums, start, pivot);
        }
        else {
            return findPivot(nums, pivot, end);
        }
    }
    
    private int binarySearch(int[] nums, int start, int end, int target){
        int mid = (start + end)/2;
        int pos = -1;
        if(start > end){
            return -1;
        }
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] > target){
            return binarySearch(nums, start, mid-1, target);
        } 
        else {
            return binarySearch(nums, mid+1, end, target);
        }
    }
    
    
    public int search(int[] nums, int target) {
      if(nums.length == 1){
        return nums[0] == target ? 0 : -1;
      }  
      if(nums.length == 0){
          return -1;
      }  
      int pivot = findPivot(nums, 0, nums.length-1);
      System.out.println(pivot);
      if(target >= nums[pivot+1] && target <= nums[nums.length-1] ){
          return binarySearch(nums, pivot+1, nums.length-1, target);
      } else {
          return binarySearch(nums, 0, pivot, target);
      }
    }
}