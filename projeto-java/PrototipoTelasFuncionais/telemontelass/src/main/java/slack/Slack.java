package slack;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import log.Log;




public class Slack {
    private String URL = "https://hooks.slack.com/services/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2"; //apagar o ultimo digito
    
    public void sendMessage(JSONObject message){
        try {
            URL obj = new URL(URL);
            
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(message.toString());
            
            wr.flush();
            wr.close();
            
            int responseCode = con.getResponseCode();
            
            System.out.println("Sending 'POST' request to URL: " + URL);
            System.out.println("POST parameters: " + message.toString());
            System.out.println("Response Code: " + responseCode);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            String inputLine;
            
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);                
            }
            
            reader.close();
            
            System.out.println("Success.");
        } catch (Exception e) {
            Log log = new Log("Fail_request_slack", e.toString(), "Erro");
            log.logCriation();
        }
    }
}
