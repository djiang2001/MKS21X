public class Barcode implements Comparable<Barcode>{
  private String zip;
  //--Constructor--//

  public Barcode(String code){
    zip = code;
  }

  //--Accessors--//

  public String getZip(){
    return zip;
  }

  public String getBarcode(){
    return this.toBar();
  }

  //--Methods--//
  public String toString(){
    return getBarcode() + " " + "("+ getZip() + ")";
  }

  public int compareTo(Barcode other){
    return getZip().compareTo(other.getZip());
  }

  public boolean equals(Barcode other){
    return getZip().equals(other.getZip());
  }

  //--Helpers--//

  private String toBar(){
    String result = "|";
    for(int i = 0; i < zip.length();i++){
      result += toCode(getZip().charAt(i));
    }
    result += toCode(checkDigit()) + "|";
    return result;
  }

  private char checkDigit(){
    int result = 0;
    for(int i = 0;i < zip.length(); i++){
      result += Character.getNumericValue(getZip().charAt(i));
    }
    return (char)('0' + (result % 10));
  }

  private String toCode(char a){
    String[] key = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    return key[Character.getNumericValue(a)];
  }
}
