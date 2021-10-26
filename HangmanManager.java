import java.util.*;

public class HangmanManager
{
	private static HashSet<Character> letter; //for guesses
	private static String pattern;// for pattern
	private static HashMap<String, HashSet<String>> temp;//for record
	private static HashSet<String> Richard;// for dictionary
	private static int maxguesses;
	private static int guessesmade;
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		letter = new HashSet<Character>();
		for(int i=0;i<length;i++) {
			pattern+="_";
		}	
		Richard=(HashSet<String>) dictionary;
		maxguesses=max;
		
	}
	
	public Set<String> words()
	{
		return Richard;
	}	
	
	public int guessesLeft()
	{
		return maxguesses-guessesmade;
	}
		
	public Set<Character> guesses()
	{
		return letter;
	}
	
	public String pattern()
	{
		return "";
	}
	
	public int record( char guess )
	{
		letter.add(guess);
		for(int x = 0; x<Richard.size(); x++){
			String m = String.valueOf(guess)
			String t = Richard.replaceAll(^m);
		}
	}// increment guessesmade 1 higher for every wrong guess 
}
