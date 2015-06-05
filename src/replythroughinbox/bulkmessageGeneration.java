package replythroughinbox;

import java.util.Date;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class bulkmessageGeneration extends Maximumminreply {

	public static void generateConversation() throws MessagingException {

		try {

			System.out.println("Printing mail position to reply " + j);
			textArea.append("Printing mail position to reply " + j + "\n");
			Message message = folder.getMessage(j);
			String from = InternetAddress.toString(message.getFrom());
			if (from != null) {
				System.out.println("Message received from account: " + from);
				textArea.append("Message received from account: " + from + "\n");
			}

			String to = InternetAddress.toString(message
					.getRecipients(Message.RecipientType.TO));
			if (to != null) {
				System.out.println("Received message was sent To: " + to);
				textArea.append("Received message was sent To: " + to + "\n");
			}
			String subject = message.getSubject();
			if (subject != null) {
				System.out.println("Received mail subject: " + subject);
				textArea.append("Received mail subject: " + subject + "\n");
			}
			Date sent = message.getSentDate();
			if (sent != null) {
				System.out.println("Received mail sent date: " + sent);
				textArea.append("Received mail sent date: " + sent + "\n");
			}
			System.out.println("Displaying content " + message.getContent());

			Message message2 = new MimeMessage(session);
			message2 = (MimeMessage) message.reply(false);
			message2.setSubject("RE: " + message.getSubject());
			message2.setFrom(new InternetAddress(to));

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Oiginal message:\n\n");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setDataHandler(message.getDataHandler());
			multipart.addBodyPart(messageBodyPart);
			message2.setContent(multipart);
			Transport.send(message2);

			System.out.println("Mail thread has been replied");
			textArea.append("Mail thread has been replied" + "\n");

		} catch (Exception e) {
			textArea.append("Failed to reply mail in thread" + "\n");
			JOptionPane.showMessageDialog(frmConversationGenerator, e
					.fillInStackTrace().toString(),
					"Failed in generating thread",
					JOptionPane.INFORMATION_MESSAGE);
		} /*
		 * finally { props.clear(); store.close(); }
		 */
	}
}
