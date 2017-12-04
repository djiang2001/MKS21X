public class Barcode implements Comparable<Barcode>{
    private String zip;
    //--Constructor--//

    public Barcode(String ZIP){
	if(ZIP.length() != 5){
	    throw new IllegalArgumentException();
	}
	for(int i =0;x <ZIP.length();i++){
	    if(!Character.isDigit(ZIP.charAt(i)){
		    throw new IllegalArgumentException();
		}
	zip = ZIP;
    }

    //--Accessors--//

    public String getZip(){
	return zip;
    }

    public String getCode(){
	return toCode(zip);
    }

    public String getBarcode(){
	return this.toBar();
    }

    //--Methods--//
    public static String toCode(String zip){
	
    }

    public static String toZip(String code){
	
    }
    
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
	    result += toBarcode(getZip().charAt(i));
	}
	result += toBarcode(checkSum()) + "|";
	return result;
    }

    private char checkSum(){
	int result = 0;
	for(int i = 0;i < zip.length(); i++){
	    result += Character.getNumericValue(getZip().charAt(i));
	}
	return (char)('0' + (result % 10));
    }

    private String toBarcode(char a){
	String[] key = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	return key[Character.getNumericValue(a)];
    }
}
