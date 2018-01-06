public class Barcode implements Comparable<Barcode>{
  private String zip;
  //--Constructor--//

  public Barcode(String zip){
    if(zip.length() != 5){
	    throw new IllegalArgumentException();
    }
    for(int i =0;i <zip.length();i++){
      if(!Character.isDigit(zip.charAt(i))){
		    throw new IllegalArgumentException();
      }
      this.zip = zip;
    }
  }

  
  //--Accessors--//

  public String getZip(){
    return zip;
  }

  

  public String getCode(){
    String[] key = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    String result = "|";
    int counter = 0;
    for (int x = 0; x < zip.length(); x++) {
      result += key[(int) zip.charAt(x) - 48];
      counter += (int)zip.charAt(x) - 48;
    }
    return result + key[counter % 10] + "|" ;
  }

  

  //--Methods--//
  public static String toCode(String zip){
    return new Barcode(zip).getCode();
  }


  
  public static String toZip(String code){
    if(code.length() > 32){
      throw new IllegalArgumentException();
    }
    if(code.charAt(0) != '|' && code.charAt(code.length()) != '|'){
      throw new IllegalArgumentException();
    }
    code = code.substring(1, code.length()-1);
    String[] key = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    String zip = "";
    int counter = 0;
    for (int i = 0;i<30;i+=5) {
      int zipCount = -1;
      for (int a = 0; a < 10; a++) {
        if (key[a].equals(code.substring(i,i+5))){
          zipCount = a;
        } 
      }
      if (zipCount == -1) {
        throw new IllegalArgumentException();
      }
      zip += zipCount;
      counter += zipCount;
    }
    if (zip.charAt(5) - 48 != (checkSum(zip.substring(0,5)))){
      throw new IllegalArgumentException();
    }
    return zip.substring(0,5);
  }


  
  public String toString(){
    return getCode() + " " + "("+ getZip() + ")";
  }


  
  public int compareTo(Barcode other){
    return getZip().compareTo(other.getZip());
  }


  
  public boolean equals(Barcode other){
    return getZip().equals(other.getZip());
  }

  public static int checkSum(String zip){
    int sum = 0;
    String strSum;
    for (int i = 0;i < zip.length();i++){
      sum += Integer.parseInt(zip.substring(i,i + 1));
    }
    return sum % 10;
  }

}
