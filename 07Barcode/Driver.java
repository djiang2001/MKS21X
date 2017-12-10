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
}
