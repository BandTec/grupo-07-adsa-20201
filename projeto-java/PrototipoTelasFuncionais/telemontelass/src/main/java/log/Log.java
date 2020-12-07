package log;

import Banco.Registro;
import ColetaDados.Maquina;
import Entities.AlertHardware;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    Maquina maquina = new Maquina();
    Registro reg = new Registro();

    private String nomeLog;
    private String descLog;
    private String nivelLog;
    private String usuarioLog;

    public Log(String nomeLog, String descLog, String nivelLog) {
        this.nomeLog = nomeLog;
        this.descLog = descLog;
        this.nivelLog = nivelLog;
        this.usuarioLog = maquina.getUsers();
    }

//    FileNotFoundException, IOException
    public void logCriation() {
        try {
            //PARA A EC2, ABAIXO:
            RandomAccessFile logErro = new RandomAccessFile(".\\logs\\" + maquina.getHostname() + reg.getDataFormatada() + ".txt", "rw");
            
            //PARA WINDOWS, ABAIXO:
//            RandomAccessFile logErro = new RandomAccessFile(".\\logs\\" + maquina.getHostname() + reg.getDataFormatada() + ".txt", "rw");
            logErro.seek(logErro.length()); // posiciona o ponteiro de posição no final do arquivo

            gravarString(logErro, String.format("Hora: %s\nNome: %s\nDescrição: %s\nNível: %s\nUsuário: %s\n=======================\n", LocalTime.now(), this.nomeLog, this.descLog, this.nivelLog, this.usuarioLog));

            logErro.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void gravarString(RandomAccessFile arq, String arg) throws IOException {
        StringBuilder result = new StringBuilder(arg);
        arq.writeBytes(result.toString());

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
