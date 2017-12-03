class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String writer,String name,String isbn,String callN){
	super(writer,name,isbn,callN);
	currentHolder = null;
	dueDate = null;
    }



  public String getCurrentHolder(){
    return currentHolder;
  }

  public String getDueDate(){
    return dueDate;
  }

  public void setCurrentHolder(String name){
    currentHolder = name;
  }

  public void setDueDate(String date){
    dueDate = date;
  }
    

  public void checkout(String name, String due){
    setCurrentHolder(name);
    setDueDate(due);
  }

  public void returned(){
    currentHolder = null;
    dueDate = null;
  }

  public String circulationStatus(){
      if(this.getDueDate() != null){
	return "" + this.getCurrentHolder() + " " + this.getDueDate() + "";
    } else{
	return "Book available on shelf";
    }
  }

  public String toString(){
      return "" + this.getTitle() + " " + this.getAuthor() + " " + this.getISBN() + " " + this.getCallNum() + " " + this.getCurrentHolder() + " " + this.getDueDate() + "";
  }

}
