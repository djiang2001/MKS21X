/*Crystal Wang helped me with solving issues for tests 3 and 6*/
import java.util.*;
public class OrderedSuperArray extends SuperArray{
  
  //--Constructors--//
  public OrderedSuperArray(){
    super();
  }

  public OrderedSuperArray(int capacity){
    super(capacity);
  }

  public OrderedSuperArray(String[] ary){
    super();
    for(int i = 0; i < ary.length; i++){
      add(ary[i]);
    }
  }

  //--Methods--//

  public void add(int index, String value){
    add(value);
  }


  public boolean add(String value){
    int index = this.findIndexBinary(value);
    super.add(index,value);
    return true;
  }


  public int findIndex(String value){
    int index = 0;
    for(int i = 0; i< this.size(); i++){
      if(value.compareTo(this.get(i)) > 0){
        index = i + 1;
      }
    }
    return index;
  }


  private int findIndexBinary(String value){
    int start = 0;
    int end = size();
    int mid = end / 2;
    while (start != end) {
      if (value.compareTo(get(mid)) > 0) {
        start = mid+1;
        mid = (start + end)/2;
      }
      else {
        end = mid;
        mid = (start + end)/2;
      }
    }
    return start;
  }

  public String set(int index,String value){
    throw new UnsupportedOperationException();
  }

  public int indexOf(String value){
    int result = findIndexBinary(value);
    while (result != 0 && get(result).compareTo(get(result-1)) == 0) {
      result--;
    }
    return result;
  }


  public int indexOfBinary(String value){
    int start = 0;
    int end = size();
    int mid = end/2;
    while(start != end){
      if(value.compareTo(get(mid)) > 0){
        start = mid + 1;
        mid = (start + end)/2;
      }
      else {
        end = mid;
        mid = (start + end)/2;
      }
    }
    return start;
  }

  public int lastIndexOf(String value){
    int result = findIndexBinary(value);
    while (result != size() - 1  && get(result).compareTo(get(result +1)) == 0) {
      result++;
    }
    return result;
  }

    public static void runTest02(int testID){
  
  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }
  
  OrderedSuperArray s1 = new OrderedSuperArray();
  ArrayList<String> s2 = new ArrayList<>();
  
  try{
    if(testID == 0 ){
    }
    
    if(testID == 1 ){
      s1.add("4");
      s2.add("4");
      s1.add("1");
      s2.add("1");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 2 ){
      s1.add("3");
      s2.add("3");
      s1.add("1");
      s2.add("1");
      s1.add("5");
      s2.add("5");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 3 ){
      s1.add("1");
      s2.add("1");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    if(testID == 4 ){
      s1.add("1");
      s2.add("1");
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 5 ){
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 6 ){
      String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
      s1 = new OrderedSuperArray(x);
      s2.addAll(Arrays.asList(x));
    }
    
    if(testID == 7 ){
      s1.add("1");
      s2.add("1");
      
      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        s1.add(v);
        s2.add(v);
      }
    }
    
    
  }catch(Exception f){
    s2.add("0");
    //f.printStackTrace();
  }
  
  Collections.sort(s2);
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
  }
}


public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(!s.get(i).equals( a.get(i))){

          return false;
        }
      }
      return true;
    }
    return false;
  }

}
