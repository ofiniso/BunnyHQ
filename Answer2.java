
public class Answer2{
	
	public static String[] answer(String[] l) {
		return sort(l);
	}
	
	public static String[] sort(String[] l){
		while (!(isSorted(l))){
			for (int i = 0; i < (l.length - 1); i++){
				if (compare(l[i], l[i+1]) == -1){
					String hold = l[i];
					l[i] = l[i+1];
					l[i+1]= hold;
				}
			}
		}
		return l;
	}
	
	public static boolean isSorted(String[] l){
		for (int i = 0; i < (l.length - 1); i++){
			if (compare(l[i], l[i+1]) == -1){
				return false;
			}
		}
		return true;
	}
	
	public static int compare(String r, String s){
		if (major(r) > major(s)){
			return -1;}
		if (major(r) < major(s)){
			return 1;}
		if (minor(r) > minor(s)){
			return -1;
		}
		if (minor(r) < minor(s)){
			return 1;
		}
		if (revision(r) > revision(s)){
			return -1;
		}
		if (revision(r) < revision(s)){
			return 1;
		}
		return 1;
	}
	
	public static int major(String s){
		if (hasMinor(s)){
			return Integer.parseInt(s.substring(0, findMinorStart(s)));
		}
		return Integer.parseInt(s);
	}
	
	public static int minor(String s){
		if (hasMinor(s)){
			if (hasRevision(s)){
				return Integer.parseInt(s.substring(findMinorStart(s) + 1, findRevisionStart(s)));
			}
			return Integer.parseInt(s.substring(findMinorStart(s) + 1));
		}
		return -1;
	}
	
	public static int revision(String s){
		if (hasRevision(s)){
			return Integer.parseInt(s.substring(findRevisionStart(s)+1));
		}
		return -1;
	}
	
	public static int findMinorStart(String s){
		int minorStart = -1;
		for ( int i = 0; i < s.length(); i++) {
			if ((s.substring(i,  i+1)).equals(".")){
				minorStart = i;
				break;
			}
		}
		return minorStart;
	}
	
	public static int findRevisionStart(String s){
		if (!hasMinor(s)) {return -1;}
		int revisionStart = -1;
		for ( int i = findMinorStart(s) + 1; i < s.length(); i++) {
			if ((s.substring(i,  i+1)).equals(".")){
				revisionStart = i;
				break;
			}
		}
		return revisionStart;
	}
	
	public static boolean hasMinor(String s){
		return (!(findMinorStart(s) == -1));
	}
	
	public static boolean hasRevision(String s){
		return (!(findRevisionStart(s) == -1));
	}
   

	public static void main(String[] args) {
		String[] l = new String[100];
		for (int i = 0; i < l.length; i++){
			if (i % 2 == 0) {
				l[i] = "1";}
			else {l[i] = "2";}
		}
		for (int i = 0; i < l.length; i++){
	    	System.out.println(l[i]);}
		l = (answer(l));
	    for (int i = 0; i < l.length; i++){
	    	System.out.println(l[i]); // expected {"1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"};
	    }
	}
}


