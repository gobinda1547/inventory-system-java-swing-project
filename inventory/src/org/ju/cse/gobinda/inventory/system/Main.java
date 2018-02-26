package org.ju.cse.gobinda.inventory.system;

public class Main {

	public static int SCREEN_WIDTH = 900;
	public static int SCREEN_HEIGHT = 600;

	public static void main(String[] args) {
		Dao.createItemTable();
		Dao.createCustomerTable();
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		//DeleteDbFiles.execute(".", "dbfile", true);
	}

}
