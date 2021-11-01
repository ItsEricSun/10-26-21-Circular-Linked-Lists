import javax.swing.*;
import BreezySwing.*;
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
//	ListIterator<Employee> it = employees.iterator();
//	ListIterator<Employee> itEdit = employees.iterator();
	JTextArea outputArea;
	JButton setRuleButton;
	JButton addHomeReserveButton;
	JButton addHomeBattingButton;
	JButton addAwayReserveButton;
	JButton addAwayBattingButton;
	JButton awayBatButton;
	JButton awayReplaceButton;
//	JButton removeButton;
//	JButton editButton;
//	JButton sortNameButton;
//	JButton sortSalaryButton;
//	JButton addEmployeeButton;
//	JButton removeEmployeeButton;
//	JButton editInfoButton;
//	JButton editEmployeeButton;
//	JButton backButton;
//	JButton backEditButton;
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
	int inning;
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
		JLabel awarScoreLabel = addLabel("Away Score: " + awayScore, 1,2,2,1);
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
		JLabel awarScoreLabel = addLabel("Away Score: " + awayScore, 1,2,2,1);
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

//	public void addMenu() {
//		frm.getContentPane().removeAll();
//		frm.setSize(250, 750);
//		frm.repaint();
//		outputArea = addTextArea("", 1, 1, 2, 6);
//		JLabel nameLabel = addLabel("Name", 7,1,1,1);
//		nameField = addTextField("", 7,2,1,1);
//		JLabel departmentLabel = addLabel("Department", 8,1,1,1);
//		departmentField = addTextField("", 8,2,1,1);
//		JLabel salaryLabel = addLabel("Salary", 9,1,1,1);
//		salaryField = addIntegerField(0, 9,2,1,1);
//		backButton = addButton("Back", 11,1,1,1);
//		addEmployeeButton = addButton("Add Employee", 11,2,1,1);
//		frm.validate();
//		updateList();
//	}

//	public void removeMenu() {
//		frm.getContentPane().removeAll();
//		frm.setSize(250, 750);
//		frm.repaint();
//		outputArea = addTextArea("", 1, 1, 2, 6);
//		JLabel nameLabel = addLabel("Name", 7,1,1,1);
//		nameField = addTextField("", 7,2,1,1);
//		backButton = addButton("Back", 8,1,1,1);
//		removeEmployeeButton = addButton("Remove Employee", 8,2,1,1);
//		frm.validate();
//		updateList();
//	}

//	public void editMenu() {
//		frm.getContentPane().removeAll();
//		frm.setSize(250, 750);
//		frm.repaint();
//		outputArea = addTextArea("", 1, 1, 2, 6);
//		JLabel nameLabel = addLabel("Name", 7,1,1,1);
//		nameField = addTextField("", 7,2,1,1);
//		backButton = addButton("Back", 8,1,1,1);
//		editInfoButton = addButton("Edit Employee", 8,2,1,1);
//		frm.validate();
//		updateList();
//	}

//	public void editEmployeeMenu(Employee s) {
//		frm.getContentPane().removeAll();
//		frm.setSize(250, 750);
//		frm.repaint();
//		outputArea = addTextArea("", 1, 1, 2, 6);
//		JLabel nameLabel = addLabel("Name", 7,1,1,1);
//		nameField = addTextField(s.getName(), 7,2,1,1);
//		JLabel departmentLabel = addLabel("Department", 8,1,1,1);
//		departmentField = addTextField(s.getDepartment(), 8,2,1,1);
//		JLabel salaryLabel = addLabel("Salary", 9,1,1,1);
//		salaryField = addIntegerField(s.getSalary(), 9,2,1,1);
//		backEditButton = addButton("Back", 11,1,1,1);
//		editEmployeeButton = addButton("Edit Employee", 11,2,1,1);
//		frm.validate();
//		updateList();
//	}

	public GUI() {
//		employees.add(new Employee("e", "math", 2500));
//		employees.add(new Employee("a", "english", 200));
//		employees.add(new Employee("n", "science", 60));
//		employees.add(new Employee("b", "english", 2000));
//		employees.add(new Employee("c", "science", 600));
		GameRules();
		awayBatting.add(new Player("a"));
		awayBatting.add(new Player("b"));
		awayBatting.add(new Player("c"));
		awayBatting.add(new Player("d"));
		awayBatting.add(new Player("e"));
		awayBatting.add(new Player("f"));
		awayBatting.next();
		field[0] = awayBatting.getCurData().toString();
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
			int random = rand.nextInt(6);
			if(random == 0) {
				messageBox(awayBatting.getCurData().toString() + ": Out");
				awayOuts++;
				if(awayOuts == 3) {
//					awayFieldEnd();
				}
				awayBatting.next();
				field[0] = awayBatting.getCurData().toString();
				awayFieldUpdate();
			}
			else if(random == 1) {
				messageBox(awayBatting.getCurData().toString() + ": Single");
				if(!field[3].equals("")) awayScore++;
				field[3] = field[2];
				field[2] = field[1];
				field[1] = field[0];
				awayBatting.next();
				field[0] = awayBatting.getCurData().toString();
				awayFieldUpdate();
			}
			else if(random == 2) {
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
			else if(random == 3) {
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
			else if(random == 4) {
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
			else if(random == 5) {
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
