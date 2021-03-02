/*Max Dizy
December 11, 2020
ICS4U
Mr. Hofstatter
verification
JAVA class to verify user inputs*/
import java.util.*;

public class verification{
/*varifies user input is a name
  Pre: user input
  Post: returns boolean value if the input is valid or not*/
  public static boolean checkName(String name){
    boolean confirmed = false;
    boolean ifString = false;
    char[] nameArray = name.toCharArray();
    char[] alph = "abcdefghijklmnopqrstuvwrxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    for (char digit : nameArray){
      confirmed = false;
      for (char letter : alph){
        if (digit == letter){
          confirmed = true;
        }
      }
      if (confirmed == false){
        System.out.println("Sorry I don\'t understand, Please only use letters and try again... ");
        return false;
      }
    }
    return true;
  }

/*varifies if user input is in the list of possible entries
  Pre: list of String values
  Post: returns boolean value if the input is valid or not*/
  public static boolean inPossibleStringEntries(String guess, List <String> list){
    boolean confirmed = false;
    for (String valid : list){
      confirmed = false;
        if (guess.equals(valid)){
          return true;
        }
      }
    if (confirmed == false){
      System.out.println("Invalid input, Please try again from the options above.");
      return false;
    }
      return false;
    }

/*varifies if user input is a integer
  Pre: user input
  Post: returns boolean value if the input is valid or not*/
  public static boolean checkInt(String num){
    try{
      int number = Integer.parseInt(num);
      return true;
      }
    catch(Exception e){
      System.out.print("invalid response. please enter a whole number, and try again:\n");
      return false;
    }
  }

  /*varifies if user input is a double
    Pre: user input
    Post: returns boolean value if the input is valid or not*/
    public static boolean checkDouble(String num){
      try{
        double number = Double.parseDouble(num);
        return true;
        }
      catch(Exception e){
        System.out.print("invalid response. please enter a number, and try again:\n");
        return false;
      }
    }

  /*varifies if user input is a integer
    Pre: user input
    Post: returns boolean value if the input is valid or not*/
    public static boolean checkIntBetween(int num, int min, int max){
      int[] numbers = {1,2,3,4,5,6,7,8,9,0};
      for (int digit : numbers){
        if (num == digit){
          if (digit >= min){
            if (digit <= max){
              return true;
            }
          }
        }
      }
      System.out.println("\ninvalid response. please enter a whole number between " + min + " and " + max + ", and try again: ");
      return false;
    }
}
