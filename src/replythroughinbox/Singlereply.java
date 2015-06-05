package replythroughinbox;

import java.awt.EventQueue;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Singlereply {

	public static Properties props = null;
	public static Session session = null;
	public static Store store = null;
	public static Folder folder = null;
	public static int messageCount = 0;
	public static String inboxCount;
	public static String mailSelection = null;
	public static String replycount;
	public static String tillCount = null;
	public static int replyCounter;
	public static JFrame frmConversationGenerator;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField;
	public static JLabel lblNewLabel;
	public static String mailPosition = null;
	public static int exactmailPosition = 0;
	public static JTextArea textArea;
	public static String username;
	public static char[] password;
	public static JPasswordField passwordField;
	public static JTextField textField_1;
	public static int j;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Singlereply window = new Singlereply();
					window.frmConversationGenerator.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frmConversationGenerator, e
							.fillInStackTrace().toString(),
							"Failed to render UI",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Singlereply() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversationGenerator = new JFrame();
		frmConversationGenerator.setTitle("Zimbra conversation generator");
		frmConversationGenerator.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Singlereply.class.getResource("/images/oggy.jpg")));
		frmConversationGenerator.setResizable(false);
		frmConversationGenerator.setBounds(55, 10, 800, 550);
		frmConversationGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversationGenerator.getContentPane().setLayout(null);

		textArea = new JTextArea("Logger :-" + "\n");
		textArea.setFont(new Font("Calibri", Font.BOLD, 16));
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		textArea.setLineWrap(false);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(326, 25, 340, 374);
		frmConversationGenerator.getContentPane().add(textArea);

		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 11));
		textField.setBounds(128, 27, 163, 20);
		frmConversationGenerator.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblUserName = new JLabel("Email id");
		lblUserName.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblUserName.setBounds(25, 30, 76, 14);
		frmConversationGenerator.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblPassword.setBounds(25, 82, 61, 14);
		frmConversationGenerator.getContentPane().add(lblPassword);

		JButton btnNewButton = new JButton("Imap connection test");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				username = textField.getText().trim();
				password = passwordField.getPassword();
				try {
					textArea.append("Trying to connect to mobdev1 server"
							+ "\n");
					imapConnectiontest.getConnectstatus();
				} catch (MessagingException e) {
					textArea.append("Failed to connect to mobdev1 server"
							+ "\n");
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton.setBounds(128, 141, 163, 23);
		frmConversationGenerator.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Inbox mail count");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				username = textField.getText().trim();
				password = passwordField.getPassword();
				try {
					textArea.append("Trying to fetch the count" + "\n");
					InboxCount.getinboxcount();
					lblNewLabel.setText(inboxCount);
				} catch (MessagingException e) {
					textArea.append("Failed to fetch the count" + "\n");
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_1.setBounds(128, 215, 163, 23);
		frmConversationGenerator.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Max. mail index range");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmConversationGenerator,
							"Maximum reply count is not there",
							"Please provide maximum reply count",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					mailPosition = textField_2.getText().trim();
					System.out.println("Mail reply position " + mailPosition);
					textArea.append("Provided maximum reply count is "
							+ mailPosition + "\n");
					JOptionPane.showMessageDialog(frmConversationGenerator,
							mailPosition, "Task completed",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_2.setBounds(128, 289, 163, 23);
		frmConversationGenerator.getContentPane().add(btnNewButton_2);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		textField_2.setBounds(25, 290, 76, 20);
		frmConversationGenerator.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		textField_3.setBounds(25, 352, 76, 20);
		frmConversationGenerator.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton_3 = new JButton("Thread count");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmConversationGenerator,
							"Thread count is not there",
							"Please provide thread count",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					textArea.append("Provided thread count is " + replycount
							+ "\n");
					replycount = textField_1.getText().trim();
					JOptionPane.showMessageDialog(frmConversationGenerator,
							replycount, "Provided thread count",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnNewButton_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_3.setBounds(128, 408, 163, 23);
		frmConversationGenerator.getContentPane().add(btnNewButton_3);

		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(400, 20, 350, 400);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		frmConversationGenerator.getContentPane().add(sp);

		lblNewLabel = new JLabel("");
		lblNewLabel.setText(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 220, 76, 14);
		frmConversationGenerator.getContentPane().add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(128, 80, 163, 20);
		frmConversationGenerator.getContentPane().add(passwordField);

		JButton btnNewButton_4 = new JButton("Min mail index range");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textField_3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmConversationGenerator,
							"Minimum reply count is not there",
							"Please provide minimum reply count",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					tillCount = textField_3.getText().trim();
					textArea.append("Provided minimum reply count is "
							+ tillCount + "\n");
					JOptionPane.showMessageDialog(frmConversationGenerator,
							tillCount, "Task completed",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_4.setBounds(128, 351, 163, 23);
		frmConversationGenerator.getContentPane().add(btnNewButton_4);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		textField_1.setBounds(25, 409, 76, 20);
		frmConversationGenerator.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_5 = new JButton("Generate conversation");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textField_3.getText().isEmpty()
						|| textField_2.getText().isEmpty()
						|| textField_1.getText().isEmpty()
						|| textField.getText().trim().isEmpty()
						|| passwordField.getPassword().toString().isEmpty()) {
					JOptionPane.showMessageDialog(frmConversationGenerator,
							"Please check the fields and provide data",
							"Task not completed",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					replycount = textField_1.getText().trim();
					mailPosition = textField_2.getText().trim();
					tillCount = textField_3.getText().trim();
					username = textField.getText().trim();
					password = passwordField.getPassword();
					try {
						Maximumminreply.generateMaxConversation();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						props.clear();
						try {
							folder.close(true);
						} catch (MessagingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							store.close();
							JOptionPane.showMessageDialog(frmConversationGenerator,
									"Conversation generated",
									"Task  completed",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(frmConversationGenerator,
									e.fillInStackTrace().toString(),
									"Task  failed",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		btnNewButton_5.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_5.setBounds(128, 471, 163, 23);
		frmConversationGenerator.getContentPane().add(btnNewButton_5);
	}
}
