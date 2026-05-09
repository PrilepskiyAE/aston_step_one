package homework_three.adapter;

public class SMSService {
    public void sendSMS(String phone, String message) {
        System.out.println("SMS отправлено на " + phone + ": " + message);
    }
}
