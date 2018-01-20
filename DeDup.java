package com.sample;

import java.util.Arrays; 
import java.util.HashSet; 
import java.util.Iterator; 
import java.util.LinkedHashSet; 
import java.util.Set; 


public class DeDup
{
  
  public static void main(String[] args)
  {
   
   int input []  = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
    DeDup obj = new DeDup();
   
    obj.printArray(obj.filterUsingHashSet(input));
    obj.printArray(obj.filterUsingOrderedSet(input));
    obj.printArray(obj.filterUsingStream(input));
    
  }
  
  public int[] filterUsingStream(int[] input){
    return Arrays.stream(input).distinct().toArray();
  }
  
  public int[] filterUsingHashSet(int[] input){
    return filterUsingCollection(input, false);
  }
  
  public int[] filterUsingOrderedSet(int[] input){
    return filterUsingCollection(input, true);
  }
  
  private int[] filterUsingCollection(int[] input, boolean ordered){
    Set<Integer> set = null;
    if(ordered){
      set = new LinkedHashSet<>();
    }else{
      set = new HashSet<>();
    }
    for(int i : input){
      set.add(i);
    }
    int output[] = new int[set.size()];
    int index = 0;
    Iterator<Integer> it = set.iterator();
    while(it.hasNext()){
      output[index++] = it.next();
    }
    return output;
  }
  
  public void printArray(int[] input){
    System.out.print("[");
    for(int i : input){
      System.out.print(i+ ",");
    }
    System.out.println("]");
  }
  
    
}
