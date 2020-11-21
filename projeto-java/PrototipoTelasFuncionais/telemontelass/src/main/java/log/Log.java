package log;

import Banco.Registro;
import ColetaDados.Maquina;
import Entities.AlertHardware;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Log {

    Maquina maquinaLog = new Maquina();
    private String nomeLog = "Hardware";
    private String descLog = "Quebrou hardware";
    private String nivelLog = "Aviso";

    Maquina maquina = new Maquina();
    Registro reg = new Registro();
    
    public void logCriation() throws FileNotFoundException, IOException {
        String nome, descLog, nivelLog;
        
        RandomAccessFile logErro = new RandomAccessFile(".\\logs\\" + maquina.getHostname() + reg.getDataFormatada() + reg.getHoraFormatada() + ".txt", "rw");
        logErro.seek(logErro.length()); // posiciona o ponteiro de posição no final do arquivo
        
        nome = "NOME: " + this.nomeLog + "\n";
        descLog = "DESCRIÇÃO: " + this.descLog + "\n";
        nivelLog = "NIVEL:" + this.nivelLog + "\n";
        gravarString(logErro, nome);
        gravarString(logErro, descLog);
        gravarString(logErro, nivelLog);
        logErro.close();
    }
    
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