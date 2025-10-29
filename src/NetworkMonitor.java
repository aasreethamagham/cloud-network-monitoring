import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NetworkMonitor {

    public static void main(String[] args) {
        String server = "8.8.8.8"; // Google DNS server

        try {
            System.out.println("Pinging server: " + server);

            Process process = Runtime.getRuntime().exec("ping -c 3 " + server);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            boolean networkOK = false;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);

                if (line.contains("0% packet loss")) {
                    networkOK = true;
                }
            }

            if (networkOK) {
                System.out.println("✅ Network is healthy!");
            } else {
                System.out.println("⚠️ High Packet Loss Detected!");
            }

        } catch (Exception e) {
            System.out.println("Error monitoring network: " + e.getMessage());
        }
    }
}
