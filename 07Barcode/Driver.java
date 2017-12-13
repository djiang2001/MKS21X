<<<<<<< HEAD
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
=======
public class Driver {
    public static void main(String[] args) {
        Barcode A = new Barcode("08451");
        Barcode B = new Barcode("51401");
        Barcode C = new Barcode("51401");

        System.out.println(A); // |||:::|::|::|::|:|:|::::|||::|:| 08451
        System.out.println(A.getCode()); // |||:::|::|::|::|:|:|::::|||::|:|
        System.out.println(A.getZip()); // 08451
        System.out.println();

        System.out.println(B); // |:|:|::::||:|::|||::::::||:::||| 51401
        System.out.println(B.getCode()); // |:|:|::::||:|::|||::::::||:::|||
        System.out.println(B.getZip()); // 51401
        System.out.println();

        System.out.println(A.equals(C)); // false
        System.out.println(B.equals(C)); // true
        System.out.println();

        System.out.println(A.compareTo(C)); // -5 , A less than C
        System.out.println(B.compareTo(C)); // 0 , B equal C
        System.out.println();

        System.out.println("|:|:|::::||:|::|||::::::||:::||| : " + Barcode.toZip("|:|:|::::||:|::|||::::::||:::|||")); // 51401
        System.out.println("51401 : " + Barcode.toCode("51401")); // |:|:|::::||:|::|||::::::||:::|||
    }
>>>>>>> 90d66d72d4e60c362d373dab3c999dcff255f1d9
}
