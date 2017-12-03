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
    int index = 0;
    for(int x = 0; x< super.size(); x++){
      if(super.get(x).equals(value)){
        index = x;
      }
    }
    return index;
  }


  public int indexOfBinary(String value){
    int index = 0;
    int start = 0;
    int end = super.size()-1;
    int mid = (start + end)/2;
    if(end >= 0){
      while(start != end){
        if(this.get(mid).compareTo(value) == 0){
          index = mid;
        }

        if(this.get(mid).compareTo(value) < 0){
          end = mid + 1;
        }

        else{
          start = mid - 1;
        }
      }
      index = -1;
    }
    return index;
  }

  public int lastIndexOf(String value){
    int index =0;
    for(int x = this.size()-1; x > -1;x--){
      if(this.get(x).equals(value)){
        index = x;
      }else{
        index = -1;
      }
    }
    return index;
  }



 public static void main(String[] args) {
        System.out.println("cat".compareTo("rabbit"));
        String[] strSetA  = {"cat", "rat", "Dog", "cats", "Eels", "lion", "dog" };
        OrderedSuperArray A = new OrderedSuperArray();
        OrderedSuperArray B = new OrderedSuperArray(strSetA);
        System.out.println(B); // [Dog, Eels, cat, cats, dog, lion, rat]
        System.out.println(A); // empty
        A.add("rabbit");
        System.out.println(A); // [rabbit]
        A.add(strSetA[0]);
        A.add(strSetA[1]);
        A.add(strSetA[2]);
        A.add(strSetA[3]);
        A.add(strSetA[4]);
        A.add(strSetA[5]);
        A.add(strSetA[6]);
        System.out.println(A); // [Dog, Eels, cat, cats, dog, lion, rabbit, rat]
        for (int x = 0; x < 6; x++) {
            A.add("panda");
        }

        System.out.println(A); // [Dog, Eels, cat, cats, dog, lion, panda, panda, panda, panda, panda, panda, rabbit, rat] (6 panda)

        System.out.println(A.indexOf("panda")); // 6
        System.out.println(A.indexOf("lion")); // 5
        System.out.println(A.indexOf("cats")); // 3
        System.out.println(A.indexOf("dog")); // 4
        System.out.println(A.indexOf("Dog")); // 0

        for (int x = 0; x < 3; x++) {
            A.add(strSetA[x]);
        }
        System.out.println(A); //[Dog, Dog, Eels, cat, cats, cats, dog, lion, panda, panda, panda, panda, panda, panda, rabbit, rat, rat] (6 panda)
        System.out.println(A.lastIndexOf("panda")); // 13
        System.out.println(A.lastIndexOf("lion")); // 7
        System.out.println(A.lastIndexOf("cats")); // 5
        System.out.println(A.lastIndexOf("dog")); // 6
        System.out.println(A.lastIndexOf("Dog")); // 1
        System.out.println(A.lastIndexOf("rat")); // 16


}
}
