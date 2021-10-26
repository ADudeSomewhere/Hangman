import java.util.*;

public class HangmanManager
{
	private static HashSet<Character> letter; //for guesses
	private static String pattern;// for pattern
	private static HashMap<String, HashSet<String>> temp;//for record
	private static HashSet<String> Richard;// for dictionary
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		letter = new HashSet<Character>();
		for(int i=0;i<length;i++) {
			pattern+="_";
		}	
		
	}
	
	public Set<String> words()
	{
		return letter;
	}	
	
	public int guessesLeft()
	{
		return 0;
	}
		
	public Set<Character> guesses()
	{
		return Richard;
	}
	
	public String pattern()
	{
		return "";
	}
	
	public int record( char guess )
	{
		letter.add(guess);
		for(int x = 0; x<Richard.size(); x++){
			String t = R
		}
	}
}
