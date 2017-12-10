import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
  private int current, end;
  private SuperArray data;

  public SuperArrayIterator(SuperArray input){
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
