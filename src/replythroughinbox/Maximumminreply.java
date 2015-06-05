package replythroughinbox;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JOptionPane;

public class Maximumminreply extends Singlereply {

	public static void generateMaxConversation() throws MessagingException {

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
				return new PasswordAuthentication(username, String
						.valueOf(password));
			}
		});
		session.setDebug(true);
		try {

			store = session.getStore("imaps");
			store.connect("mobdev1.zimbra.com", username,
					String.valueOf(password));
			folder = store.getFolder("Inbox");
			folder.open(Folder.READ_ONLY);
			// Message[] messages = folder.getMessages();
			int maxpositionvariable = Integer.parseInt(mailPosition);
			int minpositionvariable = Integer.parseInt(tillCount);
			replyCounter = Integer.parseInt(replycount);

			for (j = maxpositionvariable; j >= minpositionvariable; j--) {

				System.out.println("Inside outer loop");
				int i = 1;
				while (i <= replyCounter) {
					try {
						System.out.println("Inside inner loop");
						bulkmessageGeneration.generateConversation();
						Thread.sleep(3000l);
						System.out.println("Mail replied " + i + " times ");
						textArea.append("Mail replied " + i + " times " + "\n");
						i++;
					} catch (MessagingException e) {
						textArea.append(" Failed attempt " + i
								+ "to reply to mail" + "\n");
						JOptionPane.showMessageDialog(frmConversationGenerator,
								e.fillInStackTrace().toString(),
								"Failed in reply attempt"+i,
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}

		} catch (Exception e) {
			textArea.append("Failed in mail position based reply" + "\n");
			JOptionPane.showMessageDialog(frmConversationGenerator, e
					.fillInStackTrace().toString(),
					"Failed in mail position based reply",
					JOptionPane.INFORMATION_MESSAGE);
		} /*
		 * finally { props.clear(); store.close(); }
		 */
	}
}
