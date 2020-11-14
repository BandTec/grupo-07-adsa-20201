package log;

import ColetaDados.Maquina;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExemploLog_GabrielCerval {

    Maquina maquinaLog = new Maquina();
    private String nomeTeste = "Gulherme-Lindo";
    private String descTeste = "Quebrou hardware";
    private String nivelTeste = "Informação";
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuuMMdd");
    String dataFormatada = formatterData.format(agora);
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HHmmss");
    String horaFormatada = formatterHora.format(agora);

    public void logCriation() throws FileNotFoundException, IOException {
        String nome, descLog, nivelLog;

        long registro;

        RandomAccessFile logErro = new RandomAccessFile(".\\logs\\GABRIEL" + dataFormatada + horaFormatada + ".txt", "rw");
        logErro.seek(logErro.length()); // posiciona o ponteiro de posição no final do arquivo
        registro = (logErro.length() / 56) + 1; // número do novo registro

        descLog = "DESCRIÇÃO: " + descTeste + "\n";
        nome = "NOME: " + nomeTeste + "\n";
        nivelLog = "NIVEL: " + nivelTeste + "\n";

        gravarString(logErro, nome);
        gravarString(logErro, descLog);
        gravarString(logErro, nivelLog);

        logErro.close();

    }

    private static void gravarString(RandomAccessFile arq, String arg) throws IOException {
        StringBuilder result = new StringBuilder(arg);
        arq.writeChars(result.toString());

    }

}
