import java.util.*;

public class HangmanManager
{
	private static HashSet<String> letter;
	private static  String pattern;
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		letter = new HashSet<String>();
		patter = "";
	}
	
	public Set<String> words()
	{
		return null;
	}	
	
	public int guessesLeft()
	{
		return 0;
	}
		
	public Set<Character> guesses()
	{
		return null;
	}
	
	public String pattern()
	{
		return "";
	}
	
	public int record( char guess )
	{
		return 0;
	}
}
