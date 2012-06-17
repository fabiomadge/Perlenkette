import java.io.Console;

public class UI{

	private Perlenkette kette;
	private Console c;

	public UI(String s){
		c = System.console();
		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		}
                try {
                        int i = Integer.parseInt(s);
                        if (i < 0){
                                System.out.println("Sorry, but I have to say goodbye.");
                                quit();
                        }
                        kette = new Perlenkette(Integer.parseInt(s));
                        interact();
                }
                catch (NumberFormatException e){
                        greet();
                }
        }

	public void interact(){
		System.out.println("");
		char [] cs;
		cs = toCAr(c.readLine());
		char ch;
		if(cs.length == 0)ch = 'x';
		else ch = cs[0];
		switch(ch){
			case 'c': colour(); break;
			case 'r': radius(); break;
			case 'h': help(); break;
			case 'q': quit(); break;
			case 'd': debug(); break;
			default:  help(); break;
		}
	}

	public void colour(){
		int s = sphere();
		System.out.print("Please provide your desired colour: ");
		String co = c.readLine();
		try {
			kette.farbeSetzen(s, co);
		}
		catch (Exception e) {
			System.out.println("\nSorry, but I can't do that. Please try again.\n");
			colour();
		}
		interact();
	}

	public void radius(){
		System.out.println("");
		int s = sphere();
		int m = readInt("Please provide your desired radius: ");
		try {
			kette.groesseSetzen(s, m);
		}
		catch (Exception e) {
			System.out.println("\nSorry, but I can't do that. Please try again.");
			radius();
		}
		interact();
	}

	public void quit(){
		System.exit(0);
	}

	public void debug(){
		System.out.println(kette);
		interact();
	}

	public void help(){
		System.out.println("\nYou seamingly don't know what to do. I'll help you:\n");
		System.out.println("	(c)olour");
		System.out.println("	(r)adius");
		System.out.println("	(h)elp");
		System.out.println("	(q)uit");
		System.out.println("	(d)ebug");
		System.out.println("\nJust type the right capital letter.");
		interact();
	}

	public int sphere(){
		int i = readInt("Please provide your desired sphere: ");
		return i;
	}

	public void greet(){
		int i;
		System.out.println("\nPerlenkette\n");
		i = readInt("Please start by entering your desired length: ");
		if (i < 0){
			System.out.println("Sorry, but I have to say goodbye.");
			quit();
		}
		kette = new Perlenkette(i);
		interact();
	}

	public int readInt(String m){
		int i;
		System.out.print(m);
		String s = c.readLine();
		if(s.equals("all")){
			s = "-1";
		}
		try {
			i = Integer.parseInt(s);
		}
		catch (Exception e) {
			i = readInt(m);
		}
		return i;
	}
	
	public char[] toCAr(String s){
		char [] cse = new char [s.length()];
		for(int i = 0; i < s.length(); i++){
			cse[i] = s.charAt(i);
		}
		return cse;
	}
}
