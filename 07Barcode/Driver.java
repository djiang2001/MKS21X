public class Driver{
  public static void main(String[]args){
    Barcode home = new Barcode("10324");
    Barcode school = new Barcode("13456");
    System.out.println(home);//|:::||||:::::||:::|:|:|::|||:::| (10324)
    System.out.println(home.getZip());//1032
    System.out.println(home.getBarcode());//|:::||||:::::||:::|:|:|::|||:::|
    System.out.println(school.getBarcode());//|:::||::||::|::|:|:|::||::|:|::|
    System.out.println(home.equals(school));//false
    System.out.println(home.compareTo(school));//-3
  }
}
