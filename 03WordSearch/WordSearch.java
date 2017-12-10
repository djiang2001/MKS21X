import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
  private char[][]data;
  private Random randgen;
  private ArrayList<String>wordsToAdd = new ArrayList<String>();
  private ArrayList<String>wordsAdded = new ArrayList<String>();
  private char[][] key;
  private boolean keyselect = false;

  //--CONSTRUCTORS--//
  
  public WordSearch(int rows, int cols, String filename){
    data = new char[rows][cols];
    this.key = new char[rows][cols];//creates a key with same size
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){//checks if there are any words next
        wordsToAdd.add(in.next().toUpperCase());//adds the next word
      }
    }catch(FileNotFoundException e){ //catches if file doesn't exist
      System.out.println("File not found: " + filename); //tells user that file doesn't exist
      System.exit(1);//terminates the program
    }
    for (int i = 0; i < data.length; i++){ 
      for (int j = 0; j < data[i].length; j++){
        data[i][j] = '_'; //sets all index to "_"
      }
    }
    randgen = new Random();
    addAllWords();
    System.out.println("Bank: " + "\n" + wordsAdded);
    System.out.println("Seed: " + randgen.nextInt()); //prints the random generated seed
  }


  public WordSearch(int rows,int cols,String filename,int randseed){
    data = new char[rows][cols];
    this.key = new char[rows][cols]; //creates a key with same size
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){//checks if there are any words next
        wordsToAdd.add(in.next().toUpperCase());//adds the next word and converts to uppercase
      }
    }catch(FileNotFoundException e){ //catches if file doesn't exist
      System.out.println("File not found: " + filename); //tells user that file doesn't exist
      System.exit(1);//terminates the program
    }
    for(int i = 0; i < data.length; i++){ 
      for(int j = 0; j < data[i].length; j++){
        data[i][j] = '_'; //sets all index to "_"
      }
    }
    randgen = new Random(randseed);
    addAllWords();
    System.out.println("Bank \n" + wordsAdded);
    System.out.println("Seed: " + randseed); //prints the numbers with seed
  }

  public WordSearch(int rows, int cols, String filename, int randSeed, boolean keyselect){
    data = new char[rows][cols];
    this.key = new char[rows][cols];//creates a key with same size
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){ //checks next word
        wordsToAdd.add(in.next().toUpperCase()); //adds the next word and converts to uppercase
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      System.exit(1);
    }
    randgen = new Random(randSeed);
     addAllWords();
    if(keyselect){
      this.keyselect = keyselect;
      System.out.println("Key:" + "\n" +  keyToString()); //if the key is true, print the key
    }
    System.out.println("Seed: " + randSeed);
    System.out.println("Bank: " + "\n" + wordsAdded);
  }

  //--METHODS--//
  private void clear(){
    for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
        data[i][j] = '_'; // sets all parts of the puzzle to '_'
	    }
    }
  }

  public String toString(){ //runs through and converts to String
    String a = "";
    for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
        a = a + "[" + data[i][j]+"]";
	    }
	    a += "\n";
    }
    return a;
  }

  public String keyToString(){//runs through and converts to String
    String a = "";
    for (int i = 0; i < key.length; i++){
      for (int j = 0; j < key[i].length; j++){
        a += "[" + key[i][j] + "]";
      }
      a += '\n';
    }
    return a;
  }
  
  private void toFill(){
    char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; // These are the letters to be used to fill
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data.length; j++){
        if(data[i][j] == '_'){
          data[i][j]=letters[randgen.nextInt(26)];
        }
      }
    }
  }

  private boolean addWord(int r, int c, String word, int rowIncrement, int colIncrement){
    int rows = r, cols = c;// creates variables that will be used to check conditions without affecting the actual variable
    if (colIncrement == 0 && rowIncrement == 0){ // if inc is 0 for both there is no change
      return false;
    }
    try{
      for (int i =0; i < word.length(); i++){
        if (data[rows][cols] != '_' && data[rows][cols] != word.charAt(i)){ //if the letter overlaps a different char or not a blank space, then it doesnt get added
          return false;
        }
        rows += rowIncrement;//runs through the inc
        cols += colIncrement;
      }
    }catch(IndexOutOfBoundsException e){//if there is an exception don't add word
      return false;
    }
    
    for (int i = 0; i < word.length(); i++){//adds in the word
      data[r][c] = word.charAt(i);
      r+= rowIncrement;
      c+= colIncrement;
    }
    wordsToAdd.remove(word);
    wordsAdded.add(word);
    return true;
  }

private boolean addAllWords(){
  clear();// resets the puzzle
    
  for (int i = 0; i < 1000; i++){ 
      if (wordsToAdd.size() == 0){
        for (int r = 0; r < data.length; r++){
          for (int c = 0; c < data.length; c++){
            key[r][c] = data[r][c]; // fills the answer key with the random letters since there are no words to add
          }
        }
        toFill(); // fills in random letters
        return true;
      }
      
      addWord(randgen.nextInt(data.length), //calls on the addword to repeatedly add words to puzzle
              randgen.nextInt(data[0].length),
              wordsToAdd.get(randgen.nextInt(wordsToAdd.size())),
              randgen.nextInt(3)-1,
              randgen.nextInt(3)-1);
    }
  
  for (int i = 0; i < data.length; i++){ //creates the key with the current puzzle
      for (int j = 0; j < data.length; j++){
        key[i][j] = data[i][j];
      }
    }
  toFill(); // fills in remaining space
    return false;
  }

  //--MAIN--//

   public static void main(String[] args){
    boolean  key = false;
    if (args.length < 3){
      System.out.println("REQUIRE PARAMETERS: ROWS COLUMNS FILENAME"); // if there are less than 3 parameters call this for rows columns and filename
      System.out.println("OPTIONAL PARAMETERS: SEED KEY");
      System.exit(1);
    }
    if (args.length == 3){
      WordSearch game = new WordSearch( Integer.parseInt(args[0]), Integer.parseInt(args[1]),args[2]);// checks first, second, and third paremeters, parses required into int and runs WordSearch
      System.out.println(game);
    }
    if (args.length == 4){
      WordSearch game = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));// checks the parameters and runs it into the fitting WOrdSearch
      System.out.println(game);
    }
    if (args.length == 5){
      if (args[4].equals("true")){// if parameter calls for key, set key to true
        key = true;
      }
      WordSearch game = new WordSearch( Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2], Integer.parseInt(args[3]),key); //prints out puzzle with key
      System.out.println(game);
    }

  }



  /*
    public boolean addWordHorizontal(String word,int row, int col){
    boolean result = false;
    if(word.length() < data[row].length){
      for(int i = 0; i <word.length(); i++){
        if(data[row][col + i] == word.charAt(i) || data[row][col+i] == '_'){
          data[row][col + i] = word.charAt(i);
          result = true;
        }
      }
    }
    return result;
  }

  public boolean addWordVertical(String word,int row, int col){
    boolean result = false;
    if(word.length() < data.length){
	    for(int i = 0; i <word.length(); i++){
        if(data[row + i][col] == word.charAt(i) || data[row+i][col] == '_'){
          data[row + i][col] = word.charAt(i); 
          result = true;
        }
	    }
    }
    return result;
  }

  public boolean addWordDiagonal(String word,int row, int col){
    boolean result = false;
    if(word.length() < data.length && word.length() < data[1].length){
      for(int i = 0; i < word.length(); i++){
        if(data[row + i][col + i] == word.charAt(i) || data[row+i][col+i] == '_'){
          data[row + i][col + i] = word.charAt(i);
          result = true;
        }
      }
    }
    return result;
  }
  */
  
}

/*import java.util.*;
public class rerandom{
    public static void main(String[]args){
	int seed = (int)(Math.random()*100000);
	//seed = 17127;

        //change this to any seed you want.
	System.out.println("This is your seed: "+seed);
	Random randgen = new Random(seed);

	for(int i=0;i<10;i++){
	    System.out.println(randgen.nextInt());
	}
    }
}

public class Driver{
  public static void main(String[]args){
    WordSearch test = new WordSearch(10,10,JavaFruit.txt);
  }
  }
*/
