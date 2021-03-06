import java.util.Arrays;
public class Sorts{
    public static String name(){
    return "10.Jiang.Dahong"; 
  }

  //--Driver--//
   public static void main(String[]args){
        int[] randish = new int[15];
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(randish));
        bubbleSort(randish);
        System.out.println(Arrays.toString(randish));
 }

  //--Helper--//
      public static boolean isSorted(int[]ary){
        for(int i = 0; i < ary.length - 1 ; i++){ 
            if(ary[i] > ary[i+1]){
                return false;
            } 
        }
        return true;
    }

      private static void swap(int[]ary,int a, int b){
        int c =ary[a];
        ary[a] = ary[b];
        ary[b] = c;
    }

  //--Sorts--//


  public static void selectionSort(int[] ary){
    for (int i =0; i < ary.length; i++){
      int smallest = ary[i];
      int index = i;
      for (int j = i; j< ary.length; j++){
        if (ary[j] < smallest){
          smallest = ary[j];
          index = j;
        }
      }
      swap(ary,i,index);
    }
  }

  public static void insertionSort(int[] ary){
    for(int i = 0;i<ary.length;i++){
      int temp = ary[i];
      int j = i - 1;
      while(j >= 0 && temp < ary[j]){
        ary[j+1] = ary[j];
        j--;
      }
      ary[j+1] = temp;
    }
  }

  public static void bubbleSort(int[] ary){
    for(int i = 0; i < ary.length - 1; i++){
      for(int j = 0; j < ary.length - i - 1; j++){
        if(ary[j]>ary[j+1]){
          swap(ary,j,j+1);
        }
      }
    }
  }


}
