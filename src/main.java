import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args){

        String filepath="/home/peter/IdeaProjects/MyATM/HangGam/src/words.txt";
        ArrayList<String> words = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());

            }

        }
        catch(FileNotFoundException e){
            System.out.println("Could not find file");

        }
        catch(IOException e){
            System.out.println("something went wrong");
        }
        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));

        Scanner s = new Scanner(System.in);
        ArrayList<Character> wordstate = new ArrayList<>();
        int wrongGuesses = 0;

        for(int i =0; i< word.length(); i++){
            wordstate.add('_');
        }
        System.out.println("*************************");
        System.out.println("Welcome to Java HangGam!");
        System.out.println("*************************");

    while(wrongGuesses < 6){
        System.out.println(getArts(wrongGuesses));
        System.out.print("word: ");
        for(char c: wordstate){
            System.out.print(c + " ");
        }
        System.out.println( );
        System.out.print("Enter a guess letter: ");
        char guess = s.next().toLowerCase().charAt(0);

        if(word.indexOf(guess)>=0){
            System.out.println("Correct guess!\n");

            for(int i= 0;i< word.length();i++ ){
                if(word.charAt(i) == guess){
                    wordstate.set(i, guess);
                }
            }
            if(!wordstate.contains('_')){
                System.out.println(getArts(wrongGuesses));
                System.out.println("You win!");
                System.out.println("The word was " + word);

                break;

            }

        }
        else{
            wrongGuesses++;
            System.out.println("Wrong guess!");
        }



    }
    if(wrongGuesses >= 6){
        System.out.println(getArts(wrongGuesses));
        System.out.println("Game Over!");
        System.out.println("The word is:" + word);
    }
        s.close();

    }
    static String getArts(int wrongGuesses){
        return switch (wrongGuesses){
            case 0 -> """
                    
                    
                    
                    """;
            case 1 -> """
                     o
                    
                    
                    """;
            case 2 -> """
                     o
                     |
                    
                    """;
            case 3 -> """
                     o
                    /|
                    
                    """;
            case 4 -> """
                     o
                    /|\\
                    
                    """;
            case 5 -> """
                     o
                   /|\\
                   /
                    """;
            case 6 -> """
                     o
                   /|\\
                   / \\
                    """;
            default -> " ";
        };

    }
}
