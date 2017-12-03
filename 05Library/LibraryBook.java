abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String writer, String name, String isbn, String callN){
	this.setAuthor(writer);
	this.setTitle(name);
	this.setISBN(isbn);
	this.setCallNum(callN);
    }

    public String getCallNum(){
	return callNumber;
    }

    public void setCallNum(String callN){
	callNumber = callN;
    }

    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus();

    public int compareTo(LibraryBook other){
	return getCallNum().compareTo(other.getCallNum());
    }

    public String toString(){
	return "" + this.getTitle() + " " + this.getAuthor() + " " + this.getISBN() + " " + this.getCallNum() + "";
    }
}
