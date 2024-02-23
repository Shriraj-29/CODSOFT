import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONObject;

public class Codsoft_04 {
    private static final String API_KEY = "fca_live_ot88U7lsrbon5SMeqqNjBIS2pMvvgZJ57Yphavgw";
    private static final String API_BASE_URL = "https://api.freecurrencyapi.com/v1/latest?apikey=";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter the base currency (e.g., INR): ");
            String baseCurrency = reader.readLine().toUpperCase();

            System.out.print("Enter the target currency (e.g., USD, EUR): ");
            String targetCurrency = reader.readLine().toUpperCase();

            System.out.print("Enter the amount to convert: ");
            double amount = Double.parseDouble(reader.readLine());

            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;

            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        try {
            URI uri = new URI(API_BASE_URL + API_KEY + "&currencies=" + targetCurrency + "&base_currency=" + baseCurrency);
            URL url = uri.toURL();

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONObject rates = jsonResponse.getJSONObject("data");
                return rates.getDouble(targetCurrency);
            } else {
                System.out.println("Failed to fetch exchange rate. Response code: " + responseCode);
                return 0.0;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
