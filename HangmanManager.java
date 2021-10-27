import java.util.*;

public class HangmanManager
{
	private static HashSet<Character> letter; //for guesses
	private static String pattern;// for pattern
	private static HashMap<String, ArrayList<String>> temp;//for record
	private static HashSet<String> Richard;// for dictionary
	private static int maxguesses;
	private static int wrongguessesmade;
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		letter = new HashSet<Character>();
		for(int i=0;i<length;i++) {
			pattern+="_";
		}	
		Richard= dictionary;
		maxguesses=max;
		
	}
	
	public Set<String> words()
	{
		return Richard;
	}	
	
	public int guessesLeft()
	{
		return maxguesses-wrongguessesmade;
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
		ArrayList<String> Carl= (ArrayList<String>)Richard.stream().collect(Collectors.toList());
		letter.add(guess);
		for(int x = 0; x<Carl.size(); x++){
			String m = String.valueOf(guess);
			String t = Carl.get(x);
			for(int y = 0; y<t.length();y++){
				if(!t.substring(y, y+1).equals(m) && y!=t.length-1)
					t= t.substring(0, y) + "_" + t.substring(y+1);
				else if(!t.substring(y, y+1).equals(m))
					t = t.substring(0, y) + "_";
			}
			if(temp.get(t)==null)
				temp.put(t, new List<String>);
			else{
				ArrayList<String> ab = temp.get(t);
				ab.add(Carl.get(x));
				temp.put(t, ab);
			}
		}
		ArrayList<Integer> fLength = new ArrayList<Integer>();
	}// increment wrongguessesmade 1 higher for every wrong guess 
}
