import java.util.Iterator;

public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;

  public SuperArray(){
    data = new String[10];
  }

  public SuperArray(int startingCapacity){
    data = new String[startingCapacity];
  }


  public Iterator<String> iterator(){
    return new SuperArrayIterator(this);
  }

  public void clear(){
    data = new String[data.length];
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return this.size() == 0;
  }

  public boolean add(String input){
    if(data.length == size){
	    this.resize();
    }
    data[size] = input;
    size++;
    return true;
  }

  public String toString(){
    String a = "";
    for(int i =0; i<size;i++){
       a = a + data[i] + " ";
    }
    return a;
  }

  public String get(int index){
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  public String set(int index,String content){
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
      data[index] = content;
      return "Success";
  }

  public void resize(){
    String[] bigger = new String[2*this.size() + 1];
    for(int i=0;i<size;i++){
      bigger[i]= data[i];
    }
    data = bigger;
  }

  public boolean contains(String content){
    for(int i = 0; i< size;i++){
      if(data[i].equals(content)){
        return true;
      }
    }
    return false;
  }

  public int indexOf(String content){
    for(int i=0;i< size;i++){
      if(data[i].equals(content)){
         return i;
      }
    }
    return -1;
  }

  public int lastindexOf(String content){
    for(int i= size - 1;i>=0;i--){
      if(data[i].equals(content)){
        return i;
      }
    }
    return -1;
  }

  public void add(int index,String content){
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException();
    }
    if(data.length == size){
      this.resize();
    }
    for(int i = size - 1;i >= index;i--){
      data[i+1] = data[i];
    }
    size++;
    data[index] = content;
  }

  public String remove(int index){
    String a = "";
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    } else {
      {
        for(int x = index; x < size-1; x++){
          data[x] = data[x+1]; }
        data[size-1] = null;
        size--;
      }
      a = "Success";
    }
    return a;
  }

  public boolean remove(String element){
    boolean a = false;
    for(int i=0;i<size;i++){
      if(data[i].equals(element)){
        data[i]=data[i+1];
        a = true;
        size--;
      }
    }
    return a;
  }

}







