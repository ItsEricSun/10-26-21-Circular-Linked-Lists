
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
		singles = singles++;
	}

	public int getDoubles() {
		return doubles;
	}

	public void setDoubles(int doubles) {
		this.doubles = doubles;
	}
	
	public void addDoubles() {
		doubles = doubles++;
	}

	public int getTriples() {
		return triples;
	}

	public void setTriples(int triples) {
		this.triples = triples;
	}
	
	public void addTriples() {
		triples = triples++;
	}

	public int getHomeruns() {
		return homeruns;
	}

	public void setHomeruns(int homeruns) {
		this.homeruns = homeruns;
	}
	
	public void addHomeruns() {
		homeruns = homeruns++;
	}

	public int getWalks() {
		return walks;
	}

	public void setWalks(int walks) {
		this.walks = walks;
	}
	
	public void adWalks() {
		walks = walks++;
	}

	public int getOuts() {
		return outs;
	}

	public void setOuts(int outs) {
		this.outs = outs;
	}
	
	public void addOuts() {
		outs = outs++;
	}
}
