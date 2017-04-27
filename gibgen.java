import java.util.Scanner;
import java.io.*;


public class gibgen {
   public static void main(String[] args) {
    String str="";
    String newText=""; 

    // checking command line arguments for the name of the file
    if (args.length == 0) {
            System.out.println("no arguments were given.");
        }
//testing to see if the command lind input is the name of a file or just some string
    String input= args[0];
    if (input.substring(input.length() - 3,input.length() ).equals("txt")){
    // reading the file         
        try(BufferedReader br = new BufferedReader(new FileReader(input))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
          str = sb.toString();
        }
                catch(Exception e){
                  System.out.println( input+ " file not found");
                }
              }
    else{          
     str= input;}


//splitting the string at whitespace and punctuation
String[] splitArray = str.split("\\s+|(?=\\p{Punct})|(?<=\\p{Punct})");

 for (String word : splitArray) {

//three is the base case to scramble the string, also checking if word is a number or the word is all uppercase  
    if((word.length()> 3) && (!word.matches(".*\\d+.*"))  && (!word.toUpperCase().equals(word))) {
      //calling the shuffle function
      word=shuffle(word);
    }

       newText= (newText + " "+ word);
      }
      //getting rid of the extra white space before the punctuation
      newText = newText.replaceAll("\\s+(?=\\p{Punct})", "");

      System.out.println(newText);

  }


public static String shuffle(String word){
//storing the first and last letters of the word
String firstLetter = word.substring(0, 1);
String lastLetter=word.substring(word.length() - 1);

//substring contains remaining words to be scrambled 
String remaining =word.substring(1, word.length() - 1);

//scrambling the remaining character in the array
char[] characters =word.substring(1, word.length() - 1).toCharArray();

    for (int i =0; i < characters.length; i++) {
        int randomIndex = (int)(Math.random() * characters.length);

        char temp = characters[i];
        characters[i] = characters[randomIndex];
        characters[randomIndex] = temp;
    }
    //concatinating the first and last word with the scrambled bits to create the readable scrambled word
    String newWord= (firstLetter+ new String(characters) + lastLetter);
    //checking to make sure that the word has been scrambled because random sort of sucks, checks if remaining substring is a palendrome
    //since palendromes cant ve scrambled
    if ((newWord.equals(word)) &&(!remaining.equals(new StringBuilder(remaining).reverse().toString()) )) {

      newWord=shuffle(word);

}
    return new String(newWord);

}

}   
