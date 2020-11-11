/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import java.util.List;
import oshi.software.os.OSSession;

/**
 *
 * @author Markz
 */
public class Users {
    
    private SistemaOperacional os = new SistemaOperacional();
    private List<OSSession> usersList = os.getOs().getSessions();

    public SistemaOperacional getOs() {
        return os;
    }

    public List<OSSession> getUsersList() {
        return usersList;
    }
    
}
