public class ReversedCharSequence{
  private String data;

  public static void main(String [] args){
    String test = "ABCDEFG";
    ReversedCharSequence a = new ReversedCharSequence(test);
    System.out.println(a);
    System.out.println(a.subSequence(0,3));
    System.out.println(a.length());
    System.out.println(a.charAt(1));
  }

  public ReversedCharSequence(String input){
    String reversed = "";
    for(int i = input.length()-1; i >= 0; i--){
      reversed += input.charAt(i);
    }
    data = reversed;
  }

  public int length(){
    return data.length();
  }

  public int charAt(int index){
    return data.charAt(index);
  }

  public String toString(){
    String a = "";
    for(int i = 0; i < data.length();i++){
      a += data.charAt(i);
    }
    return a;
  }

  public String subSequence(int start,int end){
    return data.substring(start, end);
  }
}
