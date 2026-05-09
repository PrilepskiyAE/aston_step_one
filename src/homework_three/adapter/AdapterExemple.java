package homework_three.adapter;

public class AdapterExemple {
    public static void invoke(){
        SMSService smsService = new SMSService();
        EmailService emailService = new EmailService();

        Notification smsNotification = new SMSAdapter(smsService, "+79991234567");
        Notification emailNotification = new EmailAdapter(emailService, "Prilepskiy_AE@example.com");

        System.out.println("=== Отправка уведомлений ===");
        smsNotification.send("Ваше бронирование подтверждено!");
        emailNotification.send("Напоминание о встрече завтра в 10:00");
    }
}
