public class Player {
	private String name;
	private int singles = 0;
	private int doubles = 0;
	private int triples = 0;
	private int homeruns = 0;
	private int walks = 0;
	private int outs = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public String results() {
		return "Name: " + name + "\nSingles: " + singles + "\nDoubles: " + doubles + "\nTriples: " + triples + "\nHomeruns: " + homeruns + "\nWalks: " + walks + "\nOuts: " + outs + "\n";
	}
	
	public boolean equals(String name) {
		return this.name.equalsIgnoreCase(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSingles() {
		return singles;
	}

	public void setSingles(int singles) {
		this.singles = singles;
	}
	
	public void addSingles() {
		singles++;
	}

	public int getDoubles() {
		return doubles;
	}

	public void setDoubles(int doubles) {
		this.doubles = doubles;
	}
	
	public void addDoubles() {
		doubles++;
	}

	public int getTriples() {
		return triples;
	}

	public void setTriples(int triples) {
		this.triples = triples;
	}
	
	public void addTriples() {
		triples++;
	}

	public int getHomeruns() {
		return homeruns;
	}

	public void setHomeruns(int homeruns) {
		this.homeruns = homeruns;
	}
	
	public void addHomeruns() {
		homeruns++;
	}

	public int getWalks() {
		return walks;
	}

	public void setWalks(int walks) {
		this.walks = walks;
	}
	
	public void addWalks() {
		walks++;
	}

	public int getOuts() {
		return outs;
	}

	public void setOuts(int outs) {
		this.outs = outs;
	}
	
	public void addOuts() {
		outs++;
	}
}
