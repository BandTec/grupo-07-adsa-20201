/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slack;
 import com.fasterxml.jackson.databind.ObjectMapper;
 import org.apache.http.client.methods.HttpPost;
 import org.apache.http.entity.StringEntity;
 import org.apache.http.impl.client.CloseableHttpClient;
 import org.apache.http.impl.client.HttpClients;
  
 import java.io.IOException;

/**
 *
 * @author Pichau
 */
public class SlackUtils {
      private static String slackWebhookUrl = "https://hooks.slack.com/services/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2";
  
      public static void sendMessage(SlackMessage message) {
          CloseableHttpClient client = HttpClients.createDefault();
          HttpPost httpPost = new HttpPost(slackWebhookUrl);
  
          try {
              ObjectMapper objectMapper = new ObjectMapper();
              String json = objectMapper.writeValueAsString(message);
  
              StringEntity entity = new StringEntity(json);
              httpPost.setEntity(entity);
              httpPost.setHeader("Accept", "application/json");
              httpPost.setHeader("Content-type", "application/json");
  
              client.execute(httpPost);
              client.close();
          } catch (IOException e) {
             e.printStackTrace();
          }
      }
  }
