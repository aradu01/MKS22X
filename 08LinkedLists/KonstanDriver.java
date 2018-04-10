import java.util.LinkedList;

public class KonstanDriver {
    public static void main(String[]args){
	MyLinkedList nums = new MyLinkedList();
	LinkedList<Integer> nums2 = new LinkedList<>();
      
	for(int i = 0; i < 2000; i++  ){
	    int index = (int)(Math.random()*(1 + nums.size()));
	    // System.out.println(nums.size() + " " + nums2.size());
	    nums.add(index,i);
	    nums2.add(index,i);
	}
	for(int i = 0; i < nums.size(); i++  ){
	    if(nums.get(i) != nums2.get(i).intValue()){
		System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
		return;
	    }
	}
	System.out.println("PASS Randomized adds");
      
	int max = nums.size();
	for(int i = 0; i < max/2; i++  ){
	    if(nums.remove(i)!=nums2.remove(i).intValue()){
		System.out.println("FAIL while removing index: "+i);
		return;
	    }
	}
	nums.remove(0);
	nums2.remove(0);
	nums.remove(nums.size()-1);
	nums2.remove(nums2.size()-1);
      
	for(int i = 0; i < nums.size(); i++  ){
	    if(nums.get(i)!=nums2.get(i).intValue()){
		System.out.println("FAIL consecutive removes");
		return;
	    }
	}
	System.out.println("PASS consecutive removes");
      
      
	for(int i = 0; i < 1000; i++  ){
	    int index = (int)(Math.random()*(1 + nums.size()));
	    nums.add(index,i);
	    nums2.add(index,i);
	}
	for(int i = 0; i < nums.size(); i++  ){
	    if(nums.get(i) != nums2.get(i).intValue()){
		System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
		return;
	    }
	}
	System.out.println("PASS Randomized adds phase 2");
      
      
	max = nums.size();
	for(int i = 0; i < max/2; i++  ){
	    int index = (int)(Math.random()*nums.size());
	    if(nums.remove(index)!=nums2.remove(index).intValue()){
		System.out.println("FAIL while removing index: "+index);
		return;
	    }
	}
	nums.remove(0);
	nums2.remove(0);
	nums.remove(nums.size()-1);
	nums2.remove(nums2.size()-1);
      
	for(int i = 0; i < nums.size(); i++  ){
	    if(nums.get(i)!=nums2.get(i).intValue()){
		System.out.println("FAIL randomized removes");
		return;
	    }
	}
	System.out.println("PASS randomized removes");
      
	//get-------------------
	try{
	    nums.get(-3);
	    System.out.println("FAIL get access negative index did not throw exception");
	    return;
	}catch(IndexOutOfBoundsException e){
	    System.out.println("PASS get out of bounds negateive index ");
	}
      
	try{
	    nums.get(nums.size());
	    System.out.println("FAIL get access index too large did not throw exception");
	    return;
	}catch(IndexOutOfBoundsException e){
	    System.out.println("PASS get out of bounds index too large");
	}
      
      
	//set-------------------
	try{
	    nums.set(-3,5);
	    System.out.println("FAIL set access negative index did not throw exception");
	    return;
	}catch(IndexOutOfBoundsException e){
	    System.out.println("PASS set out of bounds negateive index ");
        
	}
      
	try{
	    nums.set(nums.size(),5);
	    System.out.println("FAIL set access index too large did not throw exception");
	    return;
	}catch(IndexOutOfBoundsException e){
	    System.out.println("PASS set out of bounds index too large");
	}
      
      
      
	//add-------------------
	try{
	    nums.add(nums.size()+1,5);
	    System.out.println("FAIL add access index too large did not throw exception");
	    return;
	}catch(IndexOutOfBoundsException e){
	    System.out.println("PASS add out of bounds index too large");
	}
      
	try{
	    nums.add(-1,5);
	    System.out.println("FAIL add access negative index did not throw exception");
	    return;
	}catch(IndexOutOfBoundsException e){
	    System.out.println("PASS add out of bounds negative index");
	}
      
      
      
	//remove-------------------
	try{
	    nums.remove(nums.size()+1);
	    System.out.println("FAIL remove access index too large did not throw exception");
	    return;
	}catch(IndexOutOfBoundsException e){
	    System.out.println("PASS remove out of bounds index too large");
	}
      
	try{
	    nums.remove(-1);
	    System.out.println("FAIL remove access index too large did not throw exception");
	    return;
	}catch(IndexOutOfBoundsException e){
	    System.out.println("PASS remove out of bounds index too large");
	}
      
      
	//
	nums.clear();
	if(nums.size()==0){
	    System.out.println("PASS clear");
	}else{
	    System.out.println("FAIL clear");
	    return;
	}
      
      
      
	//REMOVE BY VALUE (not index)
	nums.clear();
	for(int i = 0; i < 10; i++){
	    nums.add(0,Integer.valueOf(i));
	}
	if(nums.remove(Integer.valueOf(0)) && nums.remove(Integer.valueOf(1)) &&
	   nums.remove(Integer.valueOf(5)) && nums.remove(Integer.valueOf(3)) &&
	   nums.remove(Integer.valueOf(8))&& nums.remove(Integer.valueOf(9)))  {
	    try{
		int[]result = { 7, 6, 4, 2};
		for(int i = 0; i < nums.size();i++ ){
		    if(result[i]!=nums.get(i).intValue()){
			System.out.println("FAIL to remove by value. Final State bad");
			return;
		    }
		}
	    }catch(Exception e){
		System.out.println("FAIL to remove by value. Exception thrown");
		return;
	    }
	}else{
	    System.out.println("FAIL to remove by value.");
	    return;
	}
	System.out.println("PASS remove by values (Integer, not int).");
      
	nums.clear();
	long end,start = System.currentTimeMillis();
      
	System.out.println("#Adding to 100000 values to the front, and 100000 to the end, should be fast.\n#If the next line doesn't print right away you have some issues.");
	for(int i = 0; i < 100000; i++  ){
	    nums.add(i);
	    nums.add(nums.size(),i);
	}
	end = System.currentTimeMillis();
	//mine was 8msec on a laptop, so 250 should be fine!
	if(end - start > 250){
	    System.out.println("FAIL! Should be much faster than "+(end-start)+"msec");
	    return;
	}else{
	    System.out.println("PASS "+ (end-start)+" msec current size: "+nums.size());
	}
    }
    
}
