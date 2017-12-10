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
    for(int i = 0; i < this.size(); i++){
      add(ary[i]);
    }
  }

  //--Methods--//

  public void add(int index, String value){
    super.add(index,value);
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

}
