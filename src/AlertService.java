public class AlertService {

    public static void sendAlert(String message) {
        // In real-time cloud systems, this can be Email, SMS or Slack notification
        System.out.println("🚨 ALERT: " + message);
    }

    public static void main(String[] args) {
        String alertMessage = "High network latency detected!";
        sendAlert(alertMessage);
    }
}
