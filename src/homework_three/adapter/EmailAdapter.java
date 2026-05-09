package homework_three.adapter;

public class EmailAdapter implements Notification {
    private EmailService emailService;
    private String emailAddress;

    public EmailAdapter(EmailService emailService, String emailAddress) {
        this.emailService = emailService;
        this.emailAddress = emailAddress;
    }

    @Override
    public void send(String message) {
        emailService.sendEmail(emailAddress, "Уведомление", message);
    }
}

