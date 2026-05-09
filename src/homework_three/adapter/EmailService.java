package homework_three.adapter;

public class EmailService {
    public void sendEmail(String email, String subject, String body) {
        System.out.println("Email отправлено на " + email + " с темой '" + subject + "': " + body);
    }
}
