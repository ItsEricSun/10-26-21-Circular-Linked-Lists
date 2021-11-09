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
	
//	DoublyLinkedList<Employee> employees = new DoublyLinkedList<>();
	ListIterator<Player> itAR = awayReserve.iterator();
	ListIterator<Player> itHR = homeReserve.iterator();

//	ListIterator<Employee> itEdit = employees.iterator();
	JTextArea outputArea;
	JButton setRuleButton;
	JButton addHomeReserveButton;
	JButton addHomeBattingButton;
	JButton addAwayReserveButton;
	JButton addAwayBattingButton;
	JButton awayBatButton;
	JButton awayReplaceButton;
	JButton homeBatButton;
	JButton homeReplaceButton;
//	JButton removeButton;
//	JButton editButton;
//	JButton sortNameButton;
//	JButton sortSalaryButton;
//	JButton addEmployeeButton;
//	JButton removeEmployeeButton;
//	JButton editInfoButton;
//	JButton editEmployeeButton;
	JButton backAwayButton;
	JButton replaceAwayButton;
	JButton backHomeButton;
	JButton replaceHomeButton;
//	JTextField departmentField;
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

	static boolean adding = true;
//	Employee temp;

	public void GameRules() {
		JLabel reserveAmountLabel = addLabel("Max Reserve Player List Size (2-18)", 1,1,1,1);
		reserveAmountField = addIntegerField(2, 1,2,1,1);
		JLabel battingAmountLabel = addLabel("Max Batting Player List Size (6-9)", 2,1,1,1);
		battingAmountField = addIntegerField(6, 2,2,1,1);
		JLabel inningAmountLabel = addLabel("Innings (2-9)", 3,1,1,1);
		inningAmountField = addIntegerField(2, 3,2,1,1);
//		outputArea = addTextArea("", 1, 1, 1, 6);
		setRuleButton = addButton("Set", 3,1,2,1);
//		removeButton = addButton("Remove Employee", 8,1,1,1);
//		editButton = addButton("Edit Employee", 9,1,1,1);
//		sortNameButton = addButton("Sort by Name", 10,1,1,1);
//		sortSalaryButton = addButton("Sort by Salary", 11,1,1,1);
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
		field = new String[] {awayBatting.getCurData().toString(), "", "", ""};
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
		frm.setSize(250, 750);
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
		field = new String[] {homeBatting.getCurData().toString(), "", "", ""};
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

	public GUI() {
		GameRules();
		
		awayBatting.add(new Player("a"));
		awayBatting.add(new Player("b"));
		awayBatting.add(new Player("c"));
		awayBatting.add(new Player("d"));
		awayBatting.add(new Player("e"));
		awayBatting.add(new Player("f"));
		awayBatting.next();
		
		awayReserve.add(new Player("aaa"));
		awayReserve.add(new Player("bbb"));
		awayReserve.add(new Player("ccc"));
		awayReserve.add(new Player("ddd"));
		awayReserve.add(new Player("eee"));
		awayReserve.add(new Player("fff"));
		
		
		homeBatting.add(new Player("aa"));
		homeBatting.add(new Player("bb"));
		homeBatting.add(new Player("cc"));
		homeBatting.add(new Player("dd"));
		homeBatting.add(new Player("ee"));
		homeBatting.add(new Player("ff"));
		homeBatting.next();
//		field[0] = awayBatting.getCurData().toString();
		
//		updateList();

	}

	public void buttonClicked(JButton buttonObj){
//		if(buttonObj == backButton) {
//			mainMenu();
//			return;
//		} 
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
			awayField();
			return;
		} 
		else if(buttonObj == addHomeReserveButton) {
			String name = nameField.getText();
			if(name.equals("")) {
				messageBox("Error: Please Make Sure to Enter Name");
				return;
			}
			homeReserve.add(new Player(name));
			homeAll.add(new Player(name));
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
			homeBatting.add(new Player(name));
			homeAll.add(new Player(name));
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
			awayReserve.add(new Player(name));
			awayAll.add(new Player(name));
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
			awayBatting.add(new Player(name));
			awayAll.add(new Player(name));
			battingA--;
			if(battingA == 0) {
				awayBatting.next();
				awayField();
				return;
			}
			addAwayBatting();
			return;
		} 
		else if(buttonObj == awayBatButton) {
			int random = rand.nextInt(8);
			if(random <= 2) {
				awayBatting.getCurData().addOuts();
				messageBox(awayBatting.getCurData().toString() + ": Out");
				awayOuts++;
				if(awayOuts == 3) {
					messageBox("Home Team Enters Field");
					homeField();
					return;
				}
				awayBatting.next();
				field[0] = awayBatting.getCurData().toString();
				awayFieldUpdate();
			}
			else if(random == 3) {
				awayBatting.getCurData().addSingles();
				messageBox(awayBatting.getCurData().toString() + ": Single");
				if(!field[3].equals("")) awayScore++;
				field[3] = field[2];
				field[2] = field[1];
				field[1] = field[0];
				awayBatting.next();
				field[0] = awayBatting.getCurData().toString();
				awayFieldUpdate();
			}
			else if(random == 4) {
				awayBatting.getCurData().addDoubles();
				messageBox(awayBatting.getCurData().toString() + ": Double");
				if(!field[3].equals("")) awayScore++;
				if(!field[2].equals("")) awayScore++;
				field[3] = field[1];
				field[2] = field[0];
				field[1] = "";
				awayBatting.next();
				field[0] = awayBatting.getCurData().toString();
				awayFieldUpdate();
			}
			else if(random == 5) {
				awayBatting.getCurData().addTriples();
				messageBox(awayBatting.getCurData().toString() + ": Triple");
				if(!field[3].equals("")) awayScore++;
				if(!field[2].equals("")) awayScore++;
				if(!field[1].equals("")) awayScore++;
				field[3] = field[0];
				field[2] = "";
				field[1] = "";
				awayBatting.next();
				field[0] = awayBatting.getCurData().toString();
				awayFieldUpdate();
			}
			else if(random == 6) {
				awayBatting.getCurData().addWalks();
				messageBox(awayBatting.getCurData().toString() + ": Walk");
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
				awayBatting.next();
				field[0] = awayBatting.getCurData().toString();
				awayFieldUpdate();
			}
			else if(random == 7) {
				awayBatting.getCurData().addHomeruns();
				messageBox(awayBatting.getCurData().toString() + ": Homerun");
				if(!field[3].equals("")) awayScore++;
				if(!field[2].equals("")) awayScore++;
				if(!field[1].equals("")) awayScore++;
				awayScore++;
				field[3] = "";
				field[2] = "";
				field[1] = "";
				awayBatting.next();
				field[0] = awayBatting.getCurData().toString();
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
					awayBatting.setCur(s);
					field[0] = awayBatting.getCurData().toString();
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
				homeBatting.getCurData().addOuts();
				messageBox(homeBatting.getCurData().toString() + ": Out");
				homeOuts++;
				if(homeOuts == 3) {
					if(inning == innings) {
						System.out.println("Game Over");
						return;
					}
					inning++;
					messageBox("Next Inning: Away Team Enters Field");
					awayField();
					return;					
				}
				homeBatting.next();
				field[0] = homeBatting.getCurData().toString();
				homeFieldUpdate();
			}
			else if(random == 3) {
				homeBatting.getCurData().addSingles();
				messageBox(homeBatting.getCurData().toString() + ": Single");
				if(!field[3].equals("")) homeScore++;
				field[3] = field[2];
				field[2] = field[1];
				field[1] = field[0];
				homeBatting.next();
				field[0] = homeBatting.getCurData().toString();
				homeFieldUpdate();
			}
			else if(random == 4) {
				homeBatting.getCurData().addDoubles();
				messageBox(homeBatting.getCurData().toString() + ": Double");
				if(!field[3].equals("")) homeScore++;
				if(!field[2].equals("")) homeScore++;
				field[3] = field[1];
				field[2] = field[0];
				field[1] = "";
				homeBatting.next();
				field[0] = homeBatting.getCurData().toString();
				homeFieldUpdate();
			}
			else if(random == 5) {
				homeBatting.getCurData().addTriples();
				messageBox(homeBatting.getCurData().toString() + ": Triple");
				if(!field[3].equals("")) homeScore++;
				if(!field[2].equals("")) homeScore++;
				if(!field[1].equals("")) homeScore++;
				field[3] = field[0];
				field[2] = "";
				field[1] = "";
				homeBatting.next();
				field[0] = homeBatting.getCurData().toString();
				homeFieldUpdate();
			}
			else if(random == 6) {
				homeBatting.getCurData().addWalks();
				messageBox(homeBatting.getCurData().toString() + ": Walk");
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
				homeBatting.next();
				field[0] = homeBatting.getCurData().toString();
				homeFieldUpdate();
			}
			else if(random == 7) {
				homeBatting.getCurData().addHomeruns();
				messageBox(homeBatting.getCurData().toString() + ": Homerun");
				if(!field[3].equals("")) homeScore++;
				if(!field[2].equals("")) homeScore++;
				if(!field[1].equals("")) homeScore++;
				homeScore++;
				field[3] = "";
				field[2] = "";
				field[1] = "";
				homeBatting.next();
				field[0] = homeBatting.getCurData().toString();
				awayFieldUpdate();
			}
		}
		else if(buttonObj == homeReplaceButton) {
			
		}
//		else if(buttonObj == removeButton) {
//			if(employees.getHead() == null) {
//				messageBox("Error: No Employees");
//				return;
//			}
//			removeMenu();
//			return;
//		} 
	}

//	public void updateList() {
//		if(employees.getHead() == null) {
//			outputArea.append ("No Employees");
//		} else {
//			it = employees.iterator();
//			while(it.hasNext()) {
//				outputArea.append(it.next().toString());
//			}
//		}
//	}

	public static void main(String[] args) {
		frm = new GUI();
		frm.setTitle("Game Rules");
		frm.setSize(300, 250);
		frm.setVisible(true);
		
	}
}
