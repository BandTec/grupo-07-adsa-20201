/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import log.Log;

/**
 *
 * @author Pai
 */
public class TesteLog {
    
    public static void main(String[] args) throws IOException {
        Log teste = new Log("Teste", "Este log é somente um teste", "Alerta de Teste");
        
        teste.logCriation();
    }
}
