/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slack;

import org.json.JSONObject;
import slack.Slack;


/**
 *
 * @author Gabriel
 */
public class TesteSlack {
    
    public static void main(String[] args) {
        
    Slack slack = new Slack();  
    JSONObject json = new JSONObject();
    json.put("text", "Queridos companheiros, gostaria de anunciar que o bot da empresa Telemon esta oficialmente Online!");
    slack.sendMessage(json);
    }   
}
