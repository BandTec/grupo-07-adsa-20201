package log;

import Banco.Registro;
import ColetaDados.Maquina;
import Entities.AlertHardware;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    Maquina maquinaLog = new Maquina();
    private String nomeLog = "Hardware";
    private String descLog = "Quebrou hardware";
    private String nivelLog = "Aviso";

    Maquina maquina = new Maquina();
    Registro reg = new Registro();
//    FileNotFoundException, IOException
    
    public void logCriation()  {
        String nome, descLog, nivelLog;
        try {
            RandomAccessFile logErro = new RandomAccessFile(".\\logs\\" + maquina.getHostname() + reg.getDataFormatada() + reg.getHoraFormatada() + ".txt", "rw");
        logErro.seek(logErro.length()); // posiciona o ponteiro de posição no final do arquivo
        
        nome = "NOME: " + this.nomeLog + "\n";
        descLog = "DESCRIÇÃO: " + this.descLog + "\n";
        nivelLog = "NIVEL:" + this.nivelLog + "\n";
        gravarString(logErro, nome);
        gravarString(logErro, descLog);
        gravarString(logErro, nivelLog);
        logErro.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }    
       catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
    private static void gravarString(RandomAccessFile arq, String arg) throws IOException {
        StringBuilder result = new StringBuilder(arg);
        arq.writeChars(result.toString());

    }
    public void setNomeLog(String nomeLog) {
        this.nomeLog = nomeLog;
    }

    public void setDescLog(String descLog) {
        this.descLog = descLog;
    }

    public void setNivelLog(String nivelLog) {
        this.nivelLog = nivelLog;
    }
}