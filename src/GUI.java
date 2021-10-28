import javax.swing.*;
import BreezySwing.*;

public class GUI extends GBFrame {

	static JFrame frm;
	LinkedList<Player> homeAll = new LinkedList<>();
	LinkedList<Player> awayAll = new LinkedList<>();
	LinkedList<Player> homeReserve = new LinkedList<>();
	LinkedList<Player> awayReserve = new LinkedList<>();
	CircularLinkedList<Player> homeBatting = new CircularLinkedList<>();
	CircularLinkedList<Player> awayBatting = new CircularLinkedList<>();
	
//	DoublyLinkedList<Employee> employees = new DoublyLinkedList<>();
//	ListIterator<Employee> it = employees.iterator();
//	ListIterator<Employee> itEdit = employees.iterator();
//	JTextArea outputArea;
	JButton setRuleButton;
	JButton addHomeReserveButton;
	JButton addHomeBattingButton;
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
	JTextField nameField;

	int reserveH;
	int battingH;
	int reserveA;
	int battingA;
	
	static boolean adding = true;
//	Employee temp;

	public void GameRules() {
		JLabel reserveAmountLabel = addLabel("Max Reserve Player List Size (2-18)", 1,1,1,1);
		reserveAmountField = addIntegerField(2, 1,2,1,1);
		JLabel battingAmountLabel = addLabel("Max Batting Player List Size (2-9)", 2,1,1,1);
		battingAmountField = addIntegerField(2, 2,2,1,1);
		
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
			if(!reserveAmountField.isValid()) {
				messageBox("Error: Please Make Sure Reserve Amount is a Number");
				return;
			} 
			if(!battingAmountField.isValid()) {
				messageBox("Error: Please Make Sure Batting Amount is a Number");
				return;
			} 
			if(r < 2 || r > 18) {
				messageBox("Error: Please Make Sure Reserve Amount is between 2 and 18");
				return;
			}
			if(b < 2 || b > 9) {
				messageBox("Error: Please Make Sure Reserve Amount is between 2 and 9");
				return;
			}
			reserveH = r;
			reserveA = r;
			battingH = b;
			battingA = b;
			addHomeReserve();
			return;
		} 
		else if(buttonObj == addHomeReserveButton) {
			homeReserve.add(new Player(nameField.getText()));
			reserveH--;
			if(reserveH == 0) {
				addHomeBatting();
				return;
			}
			addHomeReserve();
			return;
		} 
		else if(buttonObj == addHomeBattingButton) {
			homeReserve.add(new Player(nameField.getText()));
			battingH--;
			if(battingH == 0) {
//				addHomeBatting();
				return;
			}
			addHomeBatting();
			return;
		} 
//		else if(buttonObj == removeButton) {
//			if(employees.getHead() == null) {
//				messageBox("Error: No Employees");
//				return;
//			}
//			removeMenu();
//			return;
//		} else if(buttonObj == editButton) {
//			if(employees.getHead() == null) {
//				messageBox("Error: No Employees");
//				return;
//			}
//			editMenu();
//			return;
//		}
//		else if (buttonObj == addEmployeeButton) {
//			String name = nameField.getText();
//			String department = departmentField.getText();
//			int salary = salaryField.getNumber();
//			if(name.equals("")) {
//				messageBox("Error: Please Enter Name");
//				return;
//			} else if(department.equals("")) {
//				messageBox("Error: Please Enter Department");
//				return;
//			} else if(!salaryField.isValid()) {
//				messageBox("Error: Please Make Sure Salary is Number");
//				return;
//			} 
//			Employee s = new Employee(name, department, salary);
//			employees.add(s);
//			mainMenu();
//			return;
//		} else if (buttonObj == removeEmployeeButton) {
//			String name = nameField.getText();
//			if(name.equals("")) {
//				messageBox("Error: Please Enter Name");
//				return;
//			} 
//			it = employees.iterator();
//			while(it.hasNext()) {
//				Employee s = it.next();
//				if(s.getName().equals(name)) {
//					it.remove();
//					mainMenu();
//					return;
//				}
//			}
//			messageBox("Error: Employee Not Found");
//			return;
//		} else if (buttonObj == editInfoButton) {
//			String name = nameField.getText();
//			if(name.equals("")) {
//				messageBox("Error: Please Enter Name");
//				return;
//			} 
//			itEdit = employees.iterator();
//			while(itEdit.hasNext()) {
//				Employee s = itEdit.next();
//				if(s.getName().equals(name)) {
//					editEmployeeMenu(s);
//					return;
//				}
//			}
//			messageBox("Error: Employee Not Found");
//			return;
//		} else if (buttonObj == editEmployeeButton) {
//			String name = nameField.getText();
//			String department = departmentField.getText();
//			int salary = salaryField.getNumber();
//			if(name.equals("")) {
//				messageBox("Error: Please Enter Name");
//				return;
//			} else if(department.equals("")) {
//				messageBox("Error: Please Enter Department");
//				return;
//			} else if(!salaryField.isValid()) {
//				messageBox("Error: Please Make Sure Salary is Number");
//				return;
//			} 
//			Employee temp = new Employee(name, department, salary);
//			itEdit.set(temp);
//			mainMenu();
//			return;
//		} else if (buttonObj == sortNameButton) {
//			if(employees.getHead() == null) {
//				return;
//			} else if(employees.size() == 1) {
//				return;
//			}
//			it = employees.iterator();
//			it.next();
//			for(int i = 1; i < employees.size(); i++) {
//				while(it.hasPrevious()) {
//					it.previous();
//				}
//				for(int j = 0; j < i - 1; j++) {
//					it.next();
//				}
//				Employee key = it.next();
//				Employee temp = it.previous();
//				while(it.hasPrevious() && temp.getName().compareTo(key.getName()) > 0) {
//					it.next();
//					it.set(temp);
//					it.previous();
//					temp = it.previous();
//				}
//				it.next();
//				it.set(key);
//			}
//			it = employees.iterator();
//			Employee key = it.next();
//			while(it.hasNext()) {
//				Employee temp =  it.next();
//				if(temp.getName().compareTo(key.getName()) < 0) {
//					it.previous();
//					it.set(temp);
//					it.next();
//				} else {
//					it.previous();
//					it.set(key);
//					mainMenu();
//					return;
//				}
//			}
//			it.set(key);
//			mainMenu();
//		} else if (buttonObj == sortSalaryButton) {
//			if(employees.getHead() == null) {
//				return;
//			} else if(employees.size() == 1) {
//				return;
//			}
//			it = employees.iterator();
//			it.next();
//			for(int i = 1; i < employees.size(); i++) {
//				while(it.hasPrevious()) {
//					it.previous();
//				}
//				for(int j = 0; j < i - 1; j++) {
//					it.next();
//				}
//				Employee key = it.next();
//				Employee temp = it.previous();
//				while(it.hasPrevious() && temp.getSalary() > key.getSalary()) {
//					it.next();
//					it.set(temp);
//					it.previous();
//					temp = it.previous();
//				}
//				it.next();
//				it.set(key);
//			}
//			it = employees.iterator();
//			Employee key = it.next();
//			while(it.hasNext()) {
//				Employee temp =  it.next();
//				if(key.getSalary() > temp.getSalary()) {
//					it.previous();
//					it.set(temp);
//					it.next();
//				} else {
//					it.previous();
//					it.set(key);
//					mainMenu();
//					return;
//				}
//			}
//			it.set(key);
//			mainMenu();
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
