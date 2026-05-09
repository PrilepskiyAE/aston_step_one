package homework_three.adapter;

public class SMSAdapter implements Notification {
    private SMSService smsService;
    private String phoneNumber;

    public SMSAdapter(SMSService smsService, String phoneNumber) {
        this.smsService = smsService;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        smsService.sendSMS(phoneNumber, message);
    }
}
