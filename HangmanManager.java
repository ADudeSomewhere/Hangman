import java.util.*;

public class HangmanManager
{
	private static HashSet<Character> letter; //for guesses
	private static String pattern;// for pattern
	private static HashMap<String, ArrayList<String>> temp;//for record
	private static List<String> Richard;// for dictionary
	private static int maxguesses;
	private static int wrongguessesmade;
	public HangmanManager( List<String> dictionary, int length, int max ){
		if(dictionary.size()>=1&&max>=0&& length>=1) {
		letter = new HashSet<Character>();
		pattern = "";
		Richard= new ArrayList<String>();
		maxguesses=max;
		wrongguessesmade=0;
		for(int i=0;i<length;i++) {
			pattern+="-";
		}
		for(int i=0;i<dictionary.size();i++) {
			if(dictionary.get(i).length()==length);
			Richard.add(dictionary.get(i));
		}
		}
		else
			throw new IllegalArgumentException("The Dictionary(input 1) must have at least one word, length(input 2) must be 1 or greater, and the number of wrong guesses allowed must be 1 or greater");
	}
	
	public List<String> words()
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
		return "pattern";
	}
	
	public int record( char guess )
	{
		if(maxguesses-wrongguessesmade<1||Richard.size()==0) {
			if(!letter.contains(guess)) {
				temp = new HashMap<String, ArrayList<String>>();
				letter.add(guess); // adds a guess to letter
				for(int x = 0; x<Richard.size(); x++){ //goes through Richard to sort all options
					String m = String.valueOf(guess);
					String t = Richard.get(x);
					for(int y = 0; y<t.length();y++){ //creates key for each option
						if(!t.substring(y, y+1).equals(m) && y!=t.length()-1)
							t= t.substring(0, y) + "-" + t.substring(y+1);
						else if(!t.substring(y, y+1).equals(m))
							t = t.substring(0, y) + "-";
					}	
					if(temp.get(t)==null) { //adds option to family in temp
						ArrayList<String> temper = new ArrayList<String>();
						temper.add(Richard.get(x));
						temp.put(t, temper);
					}
					else{
						ArrayList<String> ab = temp.get(t);
						ab.add(Richard.get(x));
						temp.put(t, ab);
					}
				}
				ArrayList<Integer> fLength = new ArrayList<Integer>();
				for(String s : temp.keySet()){ //goes through map and finds biggest family
					int cnt=temp.get(s).size();
					fLength.add(cnt);
				}
				int pos = -1;//place holder
				int min = Integer.MIN_VALUE;
				for(int x = 0; x<fLength.size(); x++){
					if(fLength.get(x)>min){
						pos = x;
						min = fLength.get(x);
					}
				}
				ArrayList<String> xxx=new ArrayList<String>();
				for(String s:temp.keySet()) {
					xxx.add(s);	
				}
				String zzz = xxx.get(pos);
				Richard = new ArrayList<String>();
				for(int x = 0; x<temp.get(zzz).size(); x++){
					Richard.add(temp.get(zzz).get(x));
				}
				pattern=zzz;
				int cnt=0;
				for(int x=0;x<pattern.length();x++) {
					if(pattern.substring(x,x+1).equals(String.valueOf(guess)))
						cnt++;
				}
				return cnt;
			}
			else {throw new IllegalArgumentException("letter has already been guessed");}
		}
		else{throw new IllegalStateException("out of guesses/out of options");}
	}// increment wrongguessesmade 1 higher for every wrong guess 
}
