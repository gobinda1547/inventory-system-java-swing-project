package org.ju.cse.gobinda.inventory.system;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private static CardLayout cardLayout;

	private JList<String> customerListInOperation;
	private JList<String> itemListInOperation;

	private static Font fontForMenu = new Font("Kalpurush", Font.PLAIN, 20);
	private static Font fontForMenuItem = new Font("Kalpurush", Font.PLAIN, 20);
	private static Font fontForUserInputText = new Font("Kalpurush", Font.PLAIN, 20);
	private static Font fontForShowTable = new Font("Kalpurush", Font.PLAIN, 20);

	private JTextField customerNameInputTextField;
	private JTextField customerMobileInputTextField;
	private JTextField itemNameInputTextField;
	private JTextField itemAmountInputTextField;
	private JTable showAllItemJtable;
	private JTable showAllCustomerJtable;
	private JTextField tfCustomerName;
	private JTextField tfCustomerMobileNumber;
	private JTextField tfCustomerDueBill;
	private JTextField tfCustomerAgainDueBill;
	private JTextField tfCustomerPaidDueBill;

	private JTextArea taCustomerDetails;
	private JTextField tfItemNameShow;
	private JTextField tfItemAmountShow;
	private JTextField tfItemUnitShow;
	private JTextField tfItemAmountAddFiled;
	private JTextField tfItemAmountMinusFiled;

	public MainFrame() {
		super();

		cardLayout = new CardLayout();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("হিসাব করুন");
		mnNewMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		mnNewMenu.setFont(fontForMenu);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("বাকির হিসাব");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateCustomerListInCustomerOperation();
				showThisPanelInCard("customerOperationJpanel");
			}
		});
		mntmNewMenuItem.setFont(fontForMenuItem);
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("মালামালের হিসাব");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateItemListInItemOperation();
				showThisPanelInCard("itemOperationJpanel");
			}

		});
		mntmNewMenuItem_3.setFont(fontForMenuItem);
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("যোগ করুন");
		mnNewMenu_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		mnNewMenu_1.setFont(fontForMenu);
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("নতুন আইটেম যোগ করুন");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showThisPanelInCard("addItemJpanel");
			}
		});
		mntmNewMenuItem_5.setFont(fontForMenuItem);
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("নতুন কাস্টমার যোগ করুন");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showThisPanelInCard("addCustomerJpanel");
			}
		});
		mntmNewMenuItem_6.setFont(fontForMenuItem);
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenu mnNewMenu_4 = new JMenu("সকল ডাটা দেখুন");
		mnNewMenu_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		mnNewMenu_4.setFont(fontForMenu);
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("সকল আইটেম দেখুন");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateItemTable();
				showThisPanelInCard("showAllItemsJpanel");
			}
		});
		mntmNewMenuItem_12.setFont(fontForMenuItem);
		mnNewMenu_4.add(mntmNewMenuItem_12);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("সকল কাস্টমারকে দেখুন");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateCustomerTable();
				showThisPanelInCard("showAllCustomerJpanel");
			}
		});
		mntmNewMenuItem_11.setFont(fontForMenuItem);
		mnNewMenu_4.add(mntmNewMenuItem_11);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);

		JPanel addCustomerJpanel = new JPanel();
		contentPane.add(addCustomerJpanel, "addCustomerJpanel");
		addCustomerJpanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("নতুন কাস্টমার যোগ করুন");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(fontForUserInputText);
		lblNewLabel.setBounds(92, 62, 700, 32);
		addCustomerJpanel.add(lblNewLabel);

		JLabel label = new JLabel("কাস্টমার এর নাম লিখুনঃ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(fontForUserInputText);
		label.setBounds(92, 113, 288, 32);
		addCustomerJpanel.add(label);

		customerNameInputTextField = new JTextField();
		customerNameInputTextField.setFont(fontForUserInputText);
		customerNameInputTextField.setBounds(395, 113, 397, 32);
		addCustomerJpanel.add(customerNameInputTextField);
		customerNameInputTextField.setColumns(10);

		JLabel label_1 = new JLabel("কাস্টমার এর মোবাইল নম্বর লিখুনঃ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(fontForUserInputText);
		label_1.setBounds(92, 151, 288, 32);
		addCustomerJpanel.add(label_1);

		customerMobileInputTextField = new JTextField();
		customerMobileInputTextField.setFont(fontForUserInputText);
		customerMobileInputTextField.setColumns(10);
		customerMobileInputTextField.setBounds(395, 151, 397, 32);
		addCustomerJpanel.add(customerMobileInputTextField);

		JLabel label_2 = new JLabel("কাস্টমার এর বর্ণনা লিখুনঃ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(fontForUserInputText);
		label_2.setBounds(92, 189, 288, 32);
		addCustomerJpanel.add(label_2);

		JPanel panel = new JPanel();
		panel.setBounds(395, 189, 397, 168);
		addCustomerJpanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		JTextArea customerDetailsINputTextArea = new JTextArea();
		customerDetailsINputTextArea.setFont(fontForUserInputText);
		scrollPane.setViewportView(customerDetailsINputTextArea);

		JButton btnNewButton = new JButton("সংরক্ষন করুন ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String customerName = customerNameInputTextField.getText().trim();
				String customerMobileNumber = customerMobileInputTextField.getText().trim();
				String customerDetails = customerDetailsINputTextArea.getText().trim();
				String customerDueBill = "০";

				System.out.println(customerMobileNumber);

				if (customerName.length() == 0) {
					JOptionPane.showMessageDialog(null, "customer name Invalid!", "Message", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Customer customer = new Customer(customerName, customerMobileNumber, customerDetails, customerDueBill);
				boolean tof = Dao.insertCustomer(customer);
				if (tof == false) {
					JOptionPane.showMessageDialog(null, "Can not added new customer.", "Message",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null, "Successfully added new customer.", "Message",
						JOptionPane.INFORMATION_MESSAGE);

				customerDetailsINputTextArea.setText("");
				customerMobileInputTextField.setText("");
				customerNameInputTextField.setText("");

			}
		});
		btnNewButton.setFont(fontForUserInputText);
		btnNewButton.setBounds(599, 379, 193, 40);
		addCustomerJpanel.add(btnNewButton);

		JButton button = new JButton("মুছে ফেলুন ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDetailsINputTextArea.setText("");
				customerMobileInputTextField.setText("");
				customerNameInputTextField.setText("");
			}
		});
		button.setFont(fontForUserInputText);
		button.setBounds(395, 379, 194, 40);
		addCustomerJpanel.add(button);

		JPanel addItemJpanel = new JPanel();
		contentPane.add(addItemJpanel, "addItemJpanel");
		addItemJpanel.setLayout(null);

		JLabel label_3 = new JLabel("নতুন আইটেম যোগ করুন");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(fontForUserInputText);
		label_3.setBounds(90, 86, 700, 32);
		addItemJpanel.add(label_3);

		JLabel label_4 = new JLabel("আইটেম এর নাম লিখুনঃ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(fontForUserInputText);
		label_4.setBounds(90, 137, 288, 32);
		addItemJpanel.add(label_4);

		itemNameInputTextField = new JTextField();
		itemNameInputTextField.setFont(fontForUserInputText);
		itemNameInputTextField.setColumns(10);
		itemNameInputTextField.setBounds(393, 137, 397, 32);
		addItemJpanel.add(itemNameInputTextField);

		JLabel label_5 = new JLabel("আইটেম কতটুকু আছে লিখুনঃ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(fontForUserInputText);
		label_5.setBounds(90, 175, 288, 32);
		addItemJpanel.add(label_5);

		itemAmountInputTextField = new JTextField();
		itemAmountInputTextField.setFont(fontForUserInputText);
		itemAmountInputTextField.setColumns(10);
		itemAmountInputTextField.setBounds(393, 175, 397, 32);
		addItemJpanel.add(itemAmountInputTextField);

		JLabel label_6 = new JLabel("আইটেম এর পরিমাপক লিখুনঃ");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(fontForUserInputText);
		label_6.setBounds(90, 213, 288, 32);
		addItemJpanel.add(label_6);

		String[] str = { "কেজি", "পিস", "বস্তা " };
		JComboBox<String> itemUnitInputComboBox = new JComboBox<>();
		for (String s : str) {
			itemUnitInputComboBox.addItem(s);
		}
		itemUnitInputComboBox.setFont(fontForShowTable);
		itemUnitInputComboBox.setBounds(393, 213, 397, 32);
		addItemJpanel.add(itemUnitInputComboBox);

		JButton button_1 = new JButton("সংরক্ষন করুন ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String itemName = itemNameInputTextField.getText().trim();
				String itemAmount = itemAmountInputTextField.getText().trim();
				System.out.println("=" + NumberConverter.convertBanglaNumberToEnglish(itemAmount) + "=");
				String itemUnitName = itemUnitInputComboBox.getSelectedItem().toString();

				if (itemName.length() == 0) {
					JOptionPane.showMessageDialog(null, "Item name Invalid!", "Message", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (itemAmount.length() == 0) {
					JOptionPane.showMessageDialog(null, "Item amount Invalid! 1", "Message", JOptionPane.ERROR_MESSAGE);
					return;
				}
				char[] ch = itemAmount.toCharArray();
				for (int i = 0; i < ch.length; i++) {
					if (ch[i] < '০' && '৯' < ch[i]) {
						JOptionPane.showMessageDialog(null, "Item amount Invalid! 2", "Message",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				Item item = new Item(itemName, itemAmount, itemUnitName);
				boolean tof = Dao.insertItem(item);
				if (tof == false) {
					JOptionPane.showMessageDialog(null, "Can not added new item.", "Message",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null, "Successfully added new item.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				itemNameInputTextField.setText("");
				itemAmountInputTextField.setText("");

			}
		});
		button_1.setFont(fontForUserInputText);
		button_1.setBounds(597, 300, 193, 40);
		addItemJpanel.add(button_1);

		JButton button_2 = new JButton("মুছে ফেলুন ");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				itemNameInputTextField.setText("");
				itemAmountInputTextField.setText("");
			}
		});
		button_2.setFont(fontForUserInputText);
		button_2.setBounds(393, 300, 194, 40);
		addItemJpanel.add(button_2);

		JPanel showAllItemsJpanel = new JPanel();
		contentPane.add(showAllItemsJpanel, "showAllItemsJpanel");
		showAllItemsJpanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		showAllItemsJpanel.add(scrollPane_1, BorderLayout.CENTER);

		showAllItemJtable = new JTable();
		showAllItemJtable.setEnabled(false);
		showAllItemJtable.setRowHeight(40);
		showAllItemJtable.getTableHeader().setFont(fontForShowTable);
		showAllItemJtable.setFont(fontForShowTable);
		scrollPane_1.setViewportView(showAllItemJtable);

		JPanel showAllCustomerJpanel = new JPanel();
		contentPane.add(showAllCustomerJpanel, "showAllCustomerJpanel");
		showAllCustomerJpanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		showAllCustomerJpanel.add(scrollPane_2, BorderLayout.CENTER);

		showAllCustomerJtable = new JTable();
		showAllCustomerJtable.setEnabled(false);
		showAllCustomerJtable.setRowHeight(40);
		showAllCustomerJtable.setFont(fontForShowTable);
		showAllCustomerJtable.getTableHeader().setFont(fontForShowTable);
		scrollPane_2.setViewportView(showAllCustomerJtable);

		JPanel customerOperationJpanel = new JPanel();
		contentPane.add(customerOperationJpanel, "customerOperationJpanel");
		customerOperationJpanel.setLayout(null);

		JLabel label_7 = new JLabel("কাস্টমারের ডাটা পরিবর্তন করুন");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(fontForUserInputText);
		label_7.setBounds(10, 11, 864, 32);
		customerOperationJpanel.add(label_7);

		JLabel label_8 = new JLabel("কাস্টমার লিস্ট");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(fontForUserInputText);
		label_8.setBounds(10, 54, 219, 32);
		customerOperationJpanel.add(label_8);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 97, 219, 417);
		customerOperationJpanel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_5.add(scrollPane_3, BorderLayout.CENTER);

		customerListInOperation = new JList<>();
		customerListInOperation.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (e.getValueIsAdjusting()) {
					String getName = customerListInOperation.getSelectedValue();
					Customer customer = Dao.getCustomerAccordingToName(getName);
					if (customer == null) {
						JOptionPane.showMessageDialog(null, "Invalid customer name!", "Message",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					tfCustomerName.setText(customer.getCustomerName());
					tfCustomerMobileNumber.setText(customer.getCustomerMobileNumber());
					taCustomerDetails.setText(customer.getCustomerDetails());
					tfCustomerDueBill.setText(customer.getCustomerDueBill());
					// + " টাকা"
				}
			}
		});
		customerListInOperation.setFont(fontForShowTable);
		customerListInOperation.setFixedCellHeight(40);
		scrollPane_3.setViewportView(customerListInOperation);

		tfCustomerName = new JTextField();
		tfCustomerName.setEditable(false);
		tfCustomerName.setFont(fontForUserInputText);
		tfCustomerName.setColumns(10);
		tfCustomerName.setBounds(477, 97, 397, 32);
		customerOperationJpanel.add(tfCustomerName);

		JLabel label_9 = new JLabel("কাস্টমার এর নামঃ");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(fontForUserInputText);
		label_9.setBounds(239, 97, 228, 32);
		customerOperationJpanel.add(label_9);

		JLabel label_10 = new JLabel("কাস্টমার এর মোবাইল নম্বরঃ");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(fontForUserInputText);
		label_10.setBounds(239, 140, 228, 32);
		customerOperationJpanel.add(label_10);

		tfCustomerMobileNumber = new JTextField();
		tfCustomerMobileNumber.setEditable(false);
		tfCustomerMobileNumber.setFont(fontForUserInputText);
		tfCustomerMobileNumber.setBounds(477, 140, 397, 32);
		customerOperationJpanel.add(tfCustomerMobileNumber);

		JLabel label_11 = new JLabel("কাস্টমার এর বর্ণনাঃ");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(fontForUserInputText);
		label_11.setBounds(239, 183, 228, 32);
		customerOperationJpanel.add(label_11);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(477, 183, 397, 121);
		customerOperationJpanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_4 = new JScrollPane();
		panel_1.add(scrollPane_4, BorderLayout.CENTER);

		taCustomerDetails = new JTextArea();
		taCustomerDetails.setEditable(false);
		taCustomerDetails.setFont(fontForUserInputText);
		scrollPane_4.setViewportView(taCustomerDetails);

		JLabel label_12 = new JLabel("আগের বাকিঃ");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(fontForUserInputText);
		label_12.setBounds(239, 315, 228, 32);
		customerOperationJpanel.add(label_12);

		tfCustomerDueBill = new JTextField();
		tfCustomerDueBill.setEditable(false);
		tfCustomerDueBill.setFont(fontForUserInputText);
		tfCustomerDueBill.setColumns(10);
		tfCustomerDueBill.setBounds(477, 315, 397, 32);
		customerOperationJpanel.add(tfCustomerDueBill);

		JLabel label_13 = new JLabel("আরও বাকি নিল নাকি?");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(fontForUserInputText);
		label_13.setBounds(239, 358, 228, 32);
		customerOperationJpanel.add(label_13);

		tfCustomerAgainDueBill = new JTextField();
		tfCustomerAgainDueBill.setFont(fontForUserInputText);
		tfCustomerAgainDueBill.setColumns(10);
		tfCustomerAgainDueBill.setBounds(477, 358, 397, 32);
		customerOperationJpanel.add(tfCustomerAgainDueBill);

		JLabel label_14 = new JLabel("বাকি টাকা জমা দিল নাকি?");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(fontForUserInputText);
		label_14.setBounds(239, 401, 228, 32);
		customerOperationJpanel.add(label_14);

		tfCustomerPaidDueBill = new JTextField();
		tfCustomerPaidDueBill.setFont(fontForUserInputText);
		tfCustomerPaidDueBill.setColumns(10);
		tfCustomerPaidDueBill.setBounds(477, 401, 397, 32);
		customerOperationJpanel.add(tfCustomerPaidDueBill);

		JButton btnNewButton_1 = new JButton("সংরক্ষন করুন");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int agerBaki = 0, bortomanBaki = 0, bortomanPorisodh = 0;

					if (tfCustomerDueBill.getText().trim().length() != 0) {
						agerBaki = Integer
								.parseInt(NumberConverter.convertBanglaNumberToEnglish(tfCustomerDueBill.getText()));
					}
					if (tfCustomerAgainDueBill.getText().trim().length() != 0) {
						bortomanBaki = Integer.parseInt(
								NumberConverter.convertBanglaNumberToEnglish(tfCustomerAgainDueBill.getText().trim()));
					}
					if (tfCustomerPaidDueBill.getText().trim().length() != 0) {
						bortomanPorisodh = Integer.parseInt(
								NumberConverter.convertBanglaNumberToEnglish(tfCustomerPaidDueBill.getText().trim()));
					}

					if (bortomanBaki < 0) {
						JOptionPane.showMessageDialog(null, "Value can not be negative!");
						return;
					}
					if (bortomanPorisodh < 0) {
						JOptionPane.showMessageDialog(null, "Value can not be negative!");
						return;
					}

					int newBill = agerBaki + bortomanBaki - bortomanPorisodh;
					if (newBill < 0) {
						JOptionPane.showMessageDialog(null, "Due value can not be negative!");
						return;
					}
					System.out.println("new bill: " + newBill);
					System.out.println("tfCustomerName.getText()" + tfCustomerName.getText());
					System.out.println("taCustomerDetails.getText()" + taCustomerDetails.getText());
					System.out.println("tfCustomerMobileNumber.getText() = " + tfCustomerMobileNumber.getText());
					System.out.println("bil: " + NumberConverter.convertEnglishNumberToBangla(String.valueOf(newBill)));

					if (Dao.updateCustomerDueBillWhereNameIs(tfCustomerName.getText(),
							NumberConverter.convertEnglishNumberToBangla(String.valueOf(newBill)))) {
						Customer customer = Dao.getCustomerAccordingToName(tfCustomerName.getText());

						tfCustomerName.setText(customer.getCustomerName());
						tfCustomerMobileNumber.setText(customer.getCustomerMobileNumber());
						taCustomerDetails.setText(customer.getCustomerDetails());
						tfCustomerDueBill.setText(customer.getCustomerDueBill());

						tfCustomerAgainDueBill.setText("");
						tfCustomerPaidDueBill.setText("");

						JOptionPane.showMessageDialog(null, "Successfully updated the customer information!");
						return;
					} else {
						JOptionPane.showMessageDialog(null, "can not update database!");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "number format exception occurs!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "exception occurs while updating customer details!");
				}

			}
		});
		btnNewButton_1.setFont(fontForUserInputText);
		btnNewButton_1.setBounds(682, 470, 192, 44);
		customerOperationJpanel.add(btnNewButton_1);

		JButton button_3 = new JButton("মুছে ফেলুন");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCustomerAgainDueBill.setText("");
				tfCustomerPaidDueBill.setText("");
			}
		});
		button_3.setFont(fontForUserInputText);
		button_3.setBounds(477, 470, 195, 44);
		customerOperationJpanel.add(button_3);

		JButton button_4 = new JButton("কাস্টমারকে মুছে ফেলুন");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerName = tfCustomerName.getText().trim();
				if (customerName.length() == 0) {
					JOptionPane.showMessageDialog(null, "select customer first!");
					return;
				}

				int response = JOptionPane.showConfirmDialog(null, "Confirm pls");
				System.out.println(response);
				if (response != 0) {
					return;
				}

				if (Dao.deleteThisCustomer(customerName)) {
					updateCustomerListInCustomerOperation();
					tfCustomerName.setText("");
					tfCustomerMobileNumber.setText("");
					taCustomerDetails.setText("");
					tfCustomerDueBill.setText("");
					tfCustomerAgainDueBill.setText("");
					tfCustomerPaidDueBill.setText("");
					JOptionPane.showMessageDialog(null, "Customer Deleted Successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Can not delete customer! problem occurs!");
				}

			}
		});
		button_4.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		button_4.setBounds(256, 470, 211, 44);
		customerOperationJpanel.add(button_4);

		JPanel itemOperationJpanel = new JPanel();
		contentPane.add(itemOperationJpanel, "itemOperationJpanel");
		itemOperationJpanel.setLayout(null);

		JLabel label_15 = new JLabel("আইটেমের ডাটা পরিবর্তন করুন");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		label_15.setBounds(10, 11, 864, 32);
		itemOperationJpanel.add(label_15);

		JLabel label_16 = new JLabel("আইটেম লিস্ট");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		label_16.setBounds(10, 54, 219, 32);
		itemOperationJpanel.add(label_16);

		JLabel label_17 = new JLabel("আইটেমের নামঃ");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		label_17.setBounds(239, 97, 228, 32);
		itemOperationJpanel.add(label_17);

		tfItemNameShow = new JTextField();
		tfItemNameShow.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		tfItemNameShow.setEditable(false);
		tfItemNameShow.setColumns(10);
		tfItemNameShow.setBounds(477, 97, 397, 32);
		itemOperationJpanel.add(tfItemNameShow);

		JLabel label_18 = new JLabel("আইটেম এখন কতটুকু আছেঃ");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		label_18.setBounds(239, 140, 228, 32);
		itemOperationJpanel.add(label_18);

		tfItemAmountShow = new JTextField();
		tfItemAmountShow.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		tfItemAmountShow.setEditable(false);
		tfItemAmountShow.setBounds(477, 140, 397, 32);
		itemOperationJpanel.add(tfItemAmountShow);

		JLabel label_19 = new JLabel("আইটেম পরিমাপকঃ");
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		label_19.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		label_19.setBounds(239, 183, 228, 32);
		itemOperationJpanel.add(label_19);

		tfItemUnitShow = new JTextField();
		tfItemUnitShow.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		tfItemUnitShow.setEditable(false);
		tfItemUnitShow.setColumns(10);
		tfItemUnitShow.setBounds(477, 183, 397, 32);
		itemOperationJpanel.add(tfItemUnitShow);

		JLabel label_20 = new JLabel("আরও কিনলেন নাকি?");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		label_20.setBounds(239, 226, 228, 32);
		itemOperationJpanel.add(label_20);

		tfItemAmountAddFiled = new JTextField();
		tfItemAmountAddFiled.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		tfItemAmountAddFiled.setBounds(477, 226, 397, 32);
		itemOperationJpanel.add(tfItemAmountAddFiled);

		JLabel label_21 = new JLabel("বিক্রি করলেন নাকি?");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		label_21.setBounds(239, 269, 228, 32);
		itemOperationJpanel.add(label_21);

		tfItemAmountMinusFiled = new JTextField();
		tfItemAmountMinusFiled.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		tfItemAmountMinusFiled.setColumns(10);
		tfItemAmountMinusFiled.setBounds(477, 269, 397, 32);
		itemOperationJpanel.add(tfItemAmountMinusFiled);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 97, 219, 417);
		itemOperationJpanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_5 = new JScrollPane();
		panel_2.add(scrollPane_5, BorderLayout.CENTER);

		itemListInOperation = new JList<>();
		itemListInOperation.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					String itemName = itemListInOperation.getSelectedValue();
					Item item = Dao.getItemAccordingToName(itemName);
					tfItemNameShow.setText(item.getItemName());
					tfItemAmountShow.setText(item.getItemAmount());
					tfItemUnitShow.setText(item.getItemUnit());
				}

			}
		});
		itemListInOperation.setFont(fontForShowTable);
		itemListInOperation.setFixedCellHeight(40);
		scrollPane_5.setViewportView(itemListInOperation);

		JButton button_5 = new JButton("আইটেমকে মুছে ফেলুন");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String itemName = tfItemNameShow.getText().trim();
				if (itemName.length() == 0) {
					JOptionPane.showMessageDialog(null, "select item first!");
					return;
				}

				int response = JOptionPane.showConfirmDialog(null, "Confirm pls");
				if (response != 0) {
					return;
				}

				if (Dao.deleteThisItem(itemName)) {
					updateItemListInItemOperation();
					tfItemNameShow.setText("");
					tfItemAmountShow.setText("");
					tfItemUnitShow.setText("");
					tfItemAmountAddFiled.setText("");
					tfItemAmountMinusFiled.setText("");
					JOptionPane.showMessageDialog(null, "Item Deleted Successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Can not delete Item! problem occurs!");
				}

			}
		});
		button_5.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		button_5.setBounds(256, 346, 211, 44);
		itemOperationJpanel.add(button_5);

		JButton button_6 = new JButton("মুছে ফেলুন");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfItemAmountAddFiled.setText("");
				tfItemAmountMinusFiled.setText("");
			}
		});
		button_6.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		button_6.setBounds(477, 346, 195, 44);
		itemOperationJpanel.add(button_6);

		JButton button_7 = new JButton("সংরক্ষন করুন");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				try {
					int agerCilo = 0, bortomaneKinlam = 0, bortomaneBikriKorlam = 0;

					if (tfItemAmountShow.getText().trim().length() != 0) {
						agerCilo = Integer.parseInt(
								NumberConverter.convertBanglaNumberToEnglish(tfItemAmountShow.getText().trim()));
					}
					if (tfItemAmountAddFiled.getText().trim().length() != 0) {
						bortomaneKinlam = Integer.parseInt(
								NumberConverter.convertBanglaNumberToEnglish(tfItemAmountAddFiled.getText().trim()));
					}
					if (tfItemAmountMinusFiled.getText().trim().length() != 0) {
						bortomaneBikriKorlam = Integer.parseInt(
								NumberConverter.convertBanglaNumberToEnglish(tfItemAmountMinusFiled.getText().trim()));
					}

					int newAmount = agerCilo + bortomaneKinlam - bortomaneBikriKorlam;
					if (newAmount < 0) {
						JOptionPane.showMessageDialog(null, "You Dont have so much item!");
						return;
					}
					System.out.println("new bill: " + newAmount);
					if (Dao.updateThisItem(tfItemNameShow.getText(),
							NumberConverter.convertEnglishNumberToBangla(String.valueOf(newAmount)))) {

						Item item = Dao.getItemAccordingToName(tfItemNameShow.getText());
						tfItemNameShow.setText(item.getItemName());
						tfItemAmountShow.setText(item.getItemAmount());
						tfItemUnitShow.setText(item.getItemUnit());

						tfItemAmountAddFiled.setText("");
						tfItemAmountMinusFiled.setText("");

						JOptionPane.showMessageDialog(null, "Successfully updated the item information!");
						return;
					} else {
						JOptionPane.showMessageDialog(null, "can not update item information!");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "number format exception occurs!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "exception occurs while updating item details!");
				}

			}
		});
		button_7.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		button_7.setBounds(682, 346, 192, 44);
		itemOperationJpanel.add(button_7);
	}

	public void updateItemTable() {

		String[] cols = new String[] { "নাম", "পরিমান ", "পরিমাপক " };
		DefaultTableModel dtm = new DefaultTableModel(cols, 0);
		ArrayList<Item> itemList = Dao.getAllItems();
		for (Item item : itemList) {
			cols[0] = item.getItemName();
			cols[1] = item.getItemAmount();
			cols[2] = item.getItemUnit();
			dtm.addRow(cols);
		}
		showAllItemJtable.setModel(dtm);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		int len = showAllItemJtable.getColumnCount();
		for (int x = 0; x < len; x++) {
			showAllItemJtable.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
		}
	}

	public void updateCustomerTable() {

		String[] cols = new String[] { "নাম", "মোবাইল নম্বর ", "বর্ণনা ", "মোট বাকি আছে" };
		DefaultTableModel dtm = new DefaultTableModel(cols, 0);
		ArrayList<Customer> customerList = Dao.getAllCustomers();
		for (Customer customer : customerList) {
			cols[0] = customer.getCustomerName();
			cols[1] = customer.getCustomerMobileNumber();
			cols[2] = (customer.getCustomerDetails().length() <= 25) ? customer.getCustomerDetails()
					: customer.getCustomerDetails().substring(0, 25) + "..";
			cols[3] = customer.getCustomerDueBill() + "  টাকা";
			dtm.addRow(cols);
		}
		showAllCustomerJtable.setModel(dtm);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		int len = showAllCustomerJtable.getColumnCount();
		for (int x = 0; x < len; x++) {
			showAllCustomerJtable.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
		}
	}

	public void showThisPanelInCard(String panelName) {
		cardLayout.show(contentPane, panelName);
	}

	public void updateCustomerListInCustomerOperation() {
		DefaultListModel<String> dlm = new DefaultListModel<>();
		ArrayList<Customer> customerList = Dao.getAllCustomers();
		for (Customer customer : customerList) {
			dlm.addElement(customer.getCustomerName());
		}
		customerListInOperation.setModel(dlm);
	}

	public void updateItemListInItemOperation() {
		DefaultListModel<String> dlm = new DefaultListModel<>();
		ArrayList<Item> itemList = Dao.getAllItems();
		for (Item item : itemList) {
			dlm.addElement(item.getItemName());
		}
		itemListInOperation.setModel(dlm);
	}
}
