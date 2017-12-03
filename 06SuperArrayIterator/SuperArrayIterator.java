java.import.util.Iterator;

public class SuperArrayIterator implements Iterator<Strings>{
  private int current, end;
  private SuperArray data;

  public SuperArrayIterator(String input){
    data = input;
    current = 0;
    end = input.size()-1;
  }

  //--Methods--//
  public String next(){
    current++;
    return data.get(current - 1);
  }

    public boolean hasNext(){
  return current <=  end;
    }
}
