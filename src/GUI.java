import javax.swing.*;
import BreezySwing.*;

import java.util.ListIterator;
import java.util.Random;

public class GUI extends GBFrame {

	static JFrame frm;
	LinkedList<Player> homeAll = new LinkedList<>();
	LinkedList<Player> awayAll = new LinkedList<>();
	LinkedList<Player> homeReserve = new LinkedList<>();
	LinkedList<Player> awayReserve = new LinkedList<>();
	CircularLinkedList<Player> homeBatting = new CircularLinkedList<>();
	CircularLinkedList<Player> awayBatting = new CircularLinkedList<>();
	String[] field = new String[] {"", "", "", ""};

	ListIterator<Player> itAR = awayReserve.iterator();
	ListIterator<Player> itHR = homeReserve.iterator();
	ListIterator<Player> itAB = awayBatting.iterator();
	ListIterator<Player> itHB = homeBatting.iterator();

	JTextArea outputArea;
	JTextArea outputArea2;
	JButton setRuleButton;
	JButton addHomeReserveButton;
	JButton addHomeBattingButton;
	JButton addAwayReserveButton;
	JButton addAwayBattingButton;
	JButton awayBatButton;
	JButton awayReplaceButton;
	JButton homeBatButton;
	JButton homeReplaceButton;
	JButton backAwayButton;
	JButton replaceAwayButton;
	JButton backHomeButton;
	JButton replaceHomeButton;
	IntegerField reserveAmountField;
	IntegerField battingAmountField;
	IntegerField inningAmountField;
	JTextField nameField;

	int reserveH;
	int battingH;
	int reserveA;
	int battingA;
	int innings;
	int homeScore;
	int awayScore;
	int inning = 1;
	int awayOuts;
	int homeOuts;
	Random rand = new Random();
	Player p;
	static boolean adding = true;

	public void GameRules() {
		JLabel reserveAmountLabel = addLabel("Max Reserve Player List Size (2-18)", 1,1,1,1);
		reserveAmountField = addIntegerField(2, 1,2,1,1);
		JLabel battingAmountLabel = addLabel("Max Batting Player List Size (6-9)", 2,1,1,1);
		battingAmountField = addIntegerField(6, 2,2,1,1);
		JLabel inningAmountLabel = addLabel("Innings (2-9)", 3,1,1,1);
		inningAmountField = addIntegerField(2, 3,2,1,1);
		setRuleButton = addButton("Set", 3,1,2,1);
	}

	public void addHomeReserve() {
		frm.getContentPane().removeAll();
		frm.setSize(300, 250);
		frm.setTitle("Home Team Reserve Player Add");
		frm.repaint();
		JLabel title = addLabel("Home Team Reserve Player (Space Left: " + reserveH + ")", 1,1,2,1);
		JLabel nameLabel = addLabel("Name", 2,1,1,1);
		nameField = addTextField("", 2,2,1,1);
		addHomeReserveButton = addButton("Add", 3,1,2,1);
		frm.validate();
	}

	public void addHomeBatting() {
		frm.getContentPane().removeAll();
		frm.setSize(300, 250);
		frm.setTitle("Home Team Batting Player Add");
		frm.repaint();
		JLabel title = addLabel("Home Team Batting Player (Space Left: " + battingH + ")", 1,1,2,1);
		JLabel nameLabel = addLabel("Name", 2,1,1,1);
		nameField = addTextField("", 2,2,1,1);
		addHomeBattingButton = addButton("Add", 3,1,2,1);
		frm.validate();
	}

	public void addAwayReserve() {
		frm.getContentPane().removeAll();
		frm.setSize(300, 250);
		frm.setTitle("Away Team Reserve Player Add");
		frm.repaint();
		JLabel title = addLabel("Away Team Reserve Player (Space Left: " + reserveA + ")", 1,1,2,1);
		JLabel nameLabel = addLabel("Name", 2,1,1,1);
		nameField = addTextField("", 2,2,1,1);
		addAwayReserveButton = addButton("Add", 3,1,2,1);
		frm.validate();
	}

	public void addAwayBatting() {
		frm.getContentPane().removeAll();
		frm.setSize(300, 250);
		frm.setTitle("Away Team Batting Player Add");
		frm.repaint();
		JLabel title = addLabel("Away Team Batting Player (Space Left: " + battingA + ")", 1,1,2,1);
		JLabel nameLabel = addLabel("Name", 2,1,1,1);
		nameField = addTextField("", 2,2,1,1);
		addAwayBattingButton = addButton("Add", 3,1,2,1);
		frm.validate();
	}

	public void awayField() {
		frm.getContentPane().removeAll();
		frm.setSize(750, 750);
		frm.setTitle("Baseball Field Away Batting");
		frm.repaint();
		awayOuts = 0;
		field = new String[] {itAB.next().toString(), "", "", ""};
		JLabel homeScoreLabel = addLabel("Home Score: " + homeScore, 1,1,2,1);
		JLabel awayScoreLabel = addLabel("Away Score: " + awayScore, 1,2,2,1);
		JLabel inningLabel = addLabel("Inning: " + inning, 1,3,2,1);
		JLabel outsLabel = addLabel("Outs: " + awayOuts, 1,4,2,1);
		JLabel spaceLabel = addLabel("", 2,1,1,1);
		JLabel homeBaseLabel = addLabel("Batting/Home Base", 3,1,1,1);
		JLabel firstBaseLabel = addLabel("First Base", 3,2,1,1);
		JLabel secondbaseLabel = addLabel("Second Base", 3,3,1,1);
		JLabel thirdBaseLabel = addLabel("Third Base", 3,4,1,1);
		JLabel homeBasePersonLabel = addLabel(field[0], 4,1,1,1);
		JLabel firstBasePersonLabel = addLabel(field[1], 4,2,1,1);
		JLabel secondbasePersonLabel = addLabel(field[2], 4,3,1,1);
		JLabel thirdBasePersonLabel = addLabel(field[3], 4,4,1,1);
		JLabel personBattingLabel = addLabel("Batting: " + field[0], 5,1,1,1);
		awayBatButton = addButton("Bat", 5,2,1,1);
		awayReplaceButton = addButton("Replace", 5,3,1,1);
		JLabel reservesLabel = addLabel("Reserves Amount: " + awayReserve.size() + " Player(s)", 5,4,1,1);
		frm.validate();
	}

	public void awayFieldUpdate() {
		frm.getContentPane().removeAll();
		frm.setSize(750, 750);
		frm.setTitle("Baseball Field Away Batting");
		frm.repaint();
		JLabel homeScoreLabel = addLabel("Home Score: " + homeScore, 1,1,2,1);
		JLabel awayScoreLabel = addLabel("Away Score: " + awayScore, 1,2,2,1);
		JLabel inningLabel = addLabel("Inning: " + inning, 1,3,2,1);
		JLabel outsLabel = addLabel("Outs: " + awayOuts, 1,4,2,1);
		JLabel spaceLabel = addLabel("", 2,1,1,1);
		JLabel homeBaseLabel = addLabel("Batting/Home Base", 3,1,1,1);
		JLabel firstBaseLabel = addLabel("First Base", 3,2,1,1);
		JLabel secondbaseLabel = addLabel("Second Base", 3,3,1,1);
		JLabel thirdBaseLabel = addLabel("Third Base", 3,4,1,1);
		JLabel homeBasePersonLabel = addLabel(field[0], 4,1,1,1);
		JLabel firstBasePersonLabel = addLabel(field[1], 4,2,1,1);
		JLabel secondbasePersonLabel = addLabel(field[2], 4,3,1,1);
		JLabel thirdBasePersonLabel = addLabel(field[3], 4,4,1,1);
		JLabel personBattingLabel = addLabel("Batting: " + field[0], 5,1,1,1);
		awayBatButton = addButton("Bat", 5,2,1,1);
		awayReplaceButton = addButton("Replace", 5,3,1,1);
		JLabel reservesLabel = addLabel("Reserves Amount: " + awayReserve.size() + " Player(s)", 5,4,1,1);
		frm.validate();
	}

	public void replaceAwayPlayer() {
		frm.getContentPane().removeAll();
		frm.setSize(500, 750);
		frm.setTitle("Replace Away Batting Player");
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField("", 7,2,1,1);
		backAwayButton = addButton("Back", 8,1,1,1);
		replaceAwayButton = addButton("Replace", 8,2,1,1);
		frm.validate();
		itAR = awayReserve.iterator();
		while(itAR.hasNext()) {
			outputArea.append(itAR.next().toString() + "\n");
		}
	}

	public void homeField() {
		frm.getContentPane().removeAll();
		frm.setSize(750, 750);
		frm.setTitle("Baseball Field Home Batting");
		frm.repaint();
		homeOuts = 0;
		field = new String[] {itHB.next().toString(), "", "", ""};
		JLabel homeScoreLabel = addLabel("Home Score: " + homeScore, 1,1,2,1);
		JLabel awayScoreLabel = addLabel("Away Score: " + awayScore, 1,2,2,1);
		JLabel inningLabel = addLabel("Inning: " + inning, 1,3,2,1);
		JLabel outsLabel = addLabel("Outs: " + homeOuts, 1,4,2,1);
		JLabel spaceLabel = addLabel("", 2,1,1,1);
		JLabel homeBaseLabel = addLabel("Batting/Home Base", 3,1,1,1);
		JLabel firstBaseLabel = addLabel("First Base", 3,2,1,1);
		JLabel secondbaseLabel = addLabel("Second Base", 3,3,1,1);
		JLabel thirdBaseLabel = addLabel("Third Base", 3,4,1,1);
		JLabel homeBasePersonLabel = addLabel(field[0], 4,1,1,1);
		JLabel firstBasePersonLabel = addLabel(field[1], 4,2,1,1);
		JLabel secondbasePersonLabel = addLabel(field[2], 4,3,1,1);
		JLabel thirdBasePersonLabel = addLabel(field[3], 4,4,1,1);
		JLabel personBattingLabel = addLabel("Batting: " + field[0], 5,1,1,1);
		homeBatButton = addButton("Bat", 5,2,1,1);
		homeReplaceButton = addButton("Replace", 5,3,1,1);
		JLabel reservesLabel = addLabel("Reserves Amount: " + homeReserve.size() + " Player(s)", 5,4,1,1);
		frm.validate();
	}

	public void homeFieldUpdate() {
		frm.getContentPane().removeAll();
		frm.setSize(750, 750);
		frm.setTitle("Baseball Field Home Batting");
		frm.repaint();
		JLabel homeScoreLabel = addLabel("Home Score: " + homeScore, 1,1,2,1);
		JLabel awayScoreLabel = addLabel("Away Score: " + awayScore, 1,2,2,1);
		JLabel inningLabel = addLabel("Inning: " + inning, 1,3,2,1);
		JLabel outsLabel = addLabel("Outs: " + homeOuts, 1,4,2,1);
		JLabel spaceLabel = addLabel("", 2,1,1,1);
		JLabel homeBaseLabel = addLabel("Batting/Home Base", 3,1,1,1);
		JLabel firstBaseLabel = addLabel("First Base", 3,2,1,1);
		JLabel secondbaseLabel = addLabel("Second Base", 3,3,1,1);
		JLabel thirdBaseLabel = addLabel("Third Base", 3,4,1,1);
		JLabel homeBasePersonLabel = addLabel(field[0], 4,1,1,1);
		JLabel firstBasePersonLabel = addLabel(field[1], 4,2,1,1);
		JLabel secondbasePersonLabel = addLabel(field[2], 4,3,1,1);
		JLabel thirdBasePersonLabel = addLabel(field[3], 4,4,1,1);
		JLabel personBattingLabel = addLabel("Batting: " + field[0], 5,1,1,1);
		homeBatButton = addButton("Bat", 5,2,1,1);
		homeReplaceButton = addButton("Replace", 5,3,1,1);
		JLabel reservesLabel = addLabel("Reserves Amount: " + homeReserve.size() + " Player(s)", 5,4,1,1);
		frm.validate();
	}

	public void replaceHomePlayer() {
		frm.getContentPane().removeAll();
		frm.setSize(500, 750);
		frm.setTitle("Replace Home Batting Player");
		frm.repaint();
		outputArea = addTextArea("", 1, 1, 2, 6);
		JLabel nameLabel = addLabel("Name", 7,1,1,1);
		nameField = addTextField("", 7,2,1,1);
		backHomeButton = addButton("Back", 8,1,1,1);
		replaceHomeButton = addButton("Replace", 8,2,1,1);
		frm.validate();
		itHR = homeReserve.iterator();
		while(itHR.hasNext()) {
			outputArea.append(itHR.next().toString() + "\n");
		}
	}

	public void results() {
		frm.getContentPane().removeAll();
		frm.setSize(500, 750);
		frm.setTitle("Results");
		frm.repaint();
		JLabel homeScoreLabel = addLabel("Home Score: " + homeScore, 1,1,1,1);
		JLabel awayScoreLabel = addLabel("Away Score: " + awayScore, 1,2,1,1);
		if(homeScore > awayScore) {
			JLabel homeWinnerLabel = addLabel("Winner: Home Team!", 2,1,2,1);
		}
		else if(homeScore < awayScore) {
			JLabel awayWinnerLabel = addLabel("Winner: Away Team!", 2,1,2,1);
		}
		else {
			JLabel tieWinnerLabel = addLabel("Its a Tie!", 2,1,2,1);
		}
		JLabel homeResultsLabel = addLabel("Home Team Results", 3,1,2,1);
		outputArea = addTextArea("", 4, 1, 2, 6);
		JLabel awayResultsLabel = addLabel("Away Team Results", 10,1,2,1);
		outputArea2 = addTextArea("", 11, 1, 2, 6);
		frm.validate();
		ListIterator<Player> it = homeAll.iterator();
		while(it.hasNext()) {
			outputArea.append(it.next().results() + "\n");
		}
		it = awayAll.iterator();
		while(it.hasNext()) {
			outputArea2.append(it.next().results() + "\n");
		}
	}

	public GUI() {
		GameRules();
	}

	public void buttonClicked(JButton buttonObj){
		if(buttonObj == setRuleButton) {
			int r = reserveAmountField.getNumber();
			int b = battingAmountField.getNumber();
			int i = inningAmountField.getNumber();
			if(!reserveAmountField.isValid()) {
				messageBox("Error: Please Make Sure Reserve Amount is a Number");
				return;
			} 
			if(!battingAmountField.isValid()) {
				messageBox("Error: Please Make Sure Batting Amount is a Number");
				return;
			} 
			if(!inningAmountField.isValid()) {
				messageBox("Error: Please Make Sure Inning Amount is a Number");
				return;
			} 
			if(r < 2 || r > 18) {
				messageBox("Error: Please Make Sure Reserve Amount is between 2 and 18");
				return;
			}
			if(b < 6 || b > 9) {
				messageBox("Error: Please Make Sure Batting Amount is between 2 and 9");
				return;
			}
			if(i < 2 || i > 9) {
				messageBox("Error: Please Make Sure Inning Count is between 2 and 9");
				return;
			}
			reserveH = r;
			reserveA = r;
			battingH = b;
			battingA = b;
			innings = i;
			addHomeReserve();
			return;
		} 
		else if(buttonObj == addHomeReserveButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Make Sure to Enter Name");
				return;
			}
			p = new Player(name);
			homeReserve.add(p);
			homeAll.add(p);
			reserveH--;
			if(reserveH == 0) {
				addHomeBatting();
				return;
			}
			addHomeReserve();
			return;
		} 
		else if(buttonObj == addHomeBattingButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Make Sure to Enter Name");
				return;
			}
			p = new Player(name);
			homeBatting.add(p);
			homeAll.add(p);
			battingH--;
			if(battingH == 0) {
				homeBatting.next();
				addAwayReserve();
				return;
			}
			addHomeBatting();
			return;
		} 
		else if(buttonObj == addAwayReserveButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Make Sure to Enter Name");
				return;
			}
			p = new Player(name);
			awayReserve.add(p);
			awayAll.add(p);
			reserveA--;
			if(reserveA == 0) {
				addAwayBatting();
				return;
			}
			addAwayReserve();
			return;
		} 
		else if(buttonObj == addAwayBattingButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Make Sure to Enter Name");
				return;
			}
			p = new Player(name);
			awayBatting.add(p);
			awayAll.add(p);
			battingA--;
			if(battingA == 0) {
				awayBatting.next();
				itAB = awayBatting.iterator();
				itHB = homeBatting.iterator();
				awayField();
				return;
			}
			addAwayBatting();
			return;
		} 
		else if(buttonObj == awayBatButton) {
			int random = rand.nextInt(8);
			if(random <= 2) {
				itAB.previous().addOuts();
				messageBox(itAB.previous().toString() + ": Out");
				awayOuts++;
				if(awayOuts == 3) {
					messageBox("Home Team Enters Field");
					homeField();
					return;
				}
				field[0] = itAB.next().toString();
				awayFieldUpdate();
			}
			else if(random == 3) {
				itAB.previous().addSingles();
				messageBox(itAB.previous().toString() + ": Single");
				if(!field[3].equals("")) awayScore++;
				field[3] = field[2];
				field[2] = field[1];
				field[1] = field[0];
				field[0] = itAB.next().toString();
				awayFieldUpdate();
			}
			else if(random == 4) {
				itAB.previous().addDoubles();
				messageBox(itAB.previous().toString() + ": Double");
				if(!field[3].equals("")) awayScore++;
				if(!field[2].equals("")) awayScore++;
				field[3] = field[1];
				field[2] = field[0];
				field[1] = "";
				field[0] = itAB.next().toString();
				awayFieldUpdate();
			}
			else if(random == 5) {
				itAB.previous().addTriples();
				messageBox(itAB.previous().toString() + ": Triple");
				if(!field[3].equals("")) awayScore++;
				if(!field[2].equals("")) awayScore++;
				if(!field[1].equals("")) awayScore++;
				field[3] = field[0];
				field[2] = "";
				field[1] = "";
				field[0] = itAB.next().toString();
				awayFieldUpdate();
			}
			else if(random == 6) {
				itAB.previous().addWalks();
				messageBox(itAB.previous().toString() + ": Walk");
				if(field[1].equals("")) {
					field[1] = field[0];
				}
				else if(field[2].equals("")) {
					field[2] = field[1];
					field[1] = field[0];
				}
				else if(field[3].equals("")) {
					field[3] = field[2];
					field[2] = field[1];
					field[1] = field[0];
				}
				else {
					field[3] = field[2];
					field[2] = field[1];
					field[1] = field[0];
					awayScore++;
				}
				field[0] = itAB.next().toString();
				awayFieldUpdate();
			}
			else if(random == 7) {
				itAB.previous().addHomeruns();
				messageBox(itAB.previous().toString() + ": Homerun");
				if(!field[3].equals("")) awayScore++;
				if(!field[2].equals("")) awayScore++;
				if(!field[1].equals("")) awayScore++;
				awayScore++;
				field[3] = "";
				field[2] = "";
				field[1] = "";
				field[0] = itAB.next().toString();
				awayFieldUpdate();
			}
		}
		else if(buttonObj == awayReplaceButton) {
			if(awayReserve.size() == 0) {
				messageBox("No Reserves");
				return;
			}
			replaceAwayPlayer();
		}
		else if(buttonObj == backAwayButton) {
			awayFieldUpdate();
		}
		else if(buttonObj == replaceAwayButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} 
			itAR = awayReserve.iterator();
			while(itAR.hasNext()) {
				Player s = itAR.next();
				if(s.getName().equals(name)) {
					itAB.set(s);
					field[0] = itAB.previous().toString();
					itAR.remove();
					awayFieldUpdate();
					return;
				}
			}
			messageBox("Error: Player Not Found");
			return;
		}
		else if(buttonObj == homeBatButton) {
			int random = rand.nextInt(8);
			if(random <= 2) {
				itHB.previous().addOuts();
				messageBox(itHB.previous().toString() + ": Out");
				homeOuts++;
				if(homeOuts == 3) {
					if(inning == innings) {
						messageBox("Game Over");
						results();
						return;
					}
					inning++;
					messageBox("Next Inning: Away Team Enters Field");
					awayField();
					return;					
				}
				field[0] = itHB.next().toString();
				homeFieldUpdate();
			}
			else if(random == 3) {
				itHB.previous().addSingles();
				messageBox(itHB.previous().toString() + ": Single");
				if(!field[3].equals("")) homeScore++;
				field[3] = field[2];
				field[2] = field[1];
				field[1] = field[0];
				field[0] = itHB.next().toString();
				homeFieldUpdate();
			}
			else if(random == 4) {
				itHB.previous().addDoubles();
				messageBox(itHB.previous().toString() + ": Double");
				if(!field[3].equals("")) homeScore++;
				if(!field[2].equals("")) homeScore++;
				field[3] = field[1];
				field[2] = field[0];
				field[1] = "";
				field[0] = itHB.next().toString();
				homeFieldUpdate();
			}
			else if(random == 5) {
				itHB.previous().addTriples();
				messageBox(itHB.previous().toString() + ": Triple");
				if(!field[3].equals("")) homeScore++;
				if(!field[2].equals("")) homeScore++;
				if(!field[1].equals("")) homeScore++;
				field[3] = field[0];
				field[2] = "";
				field[1] = "";
				field[0] = itHB.next().toString();
				homeFieldUpdate();
			}
			else if(random == 6) {
				itHB.previous().addWalks();
				messageBox(itHB.previous().toString() + ": Walk");
				if(field[1].equals("")) {
					field[1] = field[0];
				}
				else if(field[2].equals("")) {
					field[2] = field[1];
					field[1] = field[0];
				}
				else if(field[3].equals("")) {
					field[3] = field[2];
					field[2] = field[1];
					field[1] = field[0];
				}
				else {
					field[3] = field[2];
					field[2] = field[1];
					field[1] = field[0];
					homeScore++;
				}
				field[0] = itHB.next().toString();
				homeFieldUpdate();
			}
			else if(random == 7) {
				itHB.previous().addHomeruns();
				messageBox(itHB.previous().toString() + ": Homerun");
				if(!field[3].equals("")) homeScore++;
				if(!field[2].equals("")) homeScore++;
				if(!field[1].equals("")) homeScore++;
				homeScore++;
				field[3] = "";
				field[2] = "";
				field[1] = "";
				field[0] = itHB.next().toString();
				homeFieldUpdate();
			}
		}
		else if(buttonObj == homeReplaceButton) {
			if(homeReserve.size() == 0) {
				messageBox("No Reserves");
				return;
			}
			replaceHomePlayer();
		}
		else if(buttonObj == backHomeButton) {
			homeFieldUpdate();
		}
		else if(buttonObj == replaceHomeButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Enter Name");
				return;
			} 
			itHR = homeReserve.iterator();
			while(itHR.hasNext()) {
				Player s = itHR.next();
				if(s.getName().equals(name)) {
					itHB.set(s);
					field[0] = itHB.previous().toString();
					itHR.remove();
					homeFieldUpdate();
					return;
				}
			}
			messageBox("Error: Player Not Found");
			return;
		}
	}

	public static void main(String[] args) {
		frm = new GUI();
		frm.setTitle("Game Rules");
		frm.setSize(300, 250);
		frm.setVisible(true);
	}
}