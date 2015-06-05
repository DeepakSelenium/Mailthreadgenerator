package replythroughinbox;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JOptionPane;

public class imapConnectiontest extends Singlereply {

	public static void getConnectstatus() throws MessagingException {

		props = new Properties();
		props.setProperty("mail.smtp.host", "mobdev1.zimbra.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.port", "465");
		/*
		 * final String username = "tiwari@mobdev1.zimbra.com"; final String
		 * password = "test123";
		 */
		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, String.valueOf(password));
			}
		});
		session.setDebug(true);
		try {

			store = session.getStore("imaps");
			store.connect("mobdev1.zimbra.com", username, String.valueOf(password));
			/*
			 * folder = store.getFolder("Inbox"); folder.open(Folder.READ_ONLY);
			 * int messageCount = folder.getMessageCount(); inboxCount =
			 * Integer.toString(messageCount);
			 */
			System.out.println("Connection established successfully");
			textArea.append("Connection established successfully"+"\n");
			JOptionPane.showMessageDialog(frmConversationGenerator,
					"Connection established ", "Task completed",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println("Failed to connect");
			textArea.append("Failed to connect"+"\n");
			JOptionPane.showMessageDialog(frmConversationGenerator,
					e.fillInStackTrace().toString(), "Failed to connect",
					JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		} finally {
			props.clear();
			store.close();
			// folder.close(true);

		}

	}
}
