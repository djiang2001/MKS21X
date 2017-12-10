public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
    }

    public Book(String writer, String name, String isbn){
	author = writer;
	title = name;
	ISBN = isbn;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public void setAuthor(String writer){
	author = writer;
    }

    public void setTitle(String name){
	title = name;
    }

    public void setISBN(String isbn){
	ISBN = isbn;
    }

    public String toString(){
	return "" + title + " " + author + " " +  ISBN + "" ;
    }
    
}
