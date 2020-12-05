package Banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Registro {

    LocalDateTime agora;

    public LocalDateTime getAgora() {
        agora = LocalDateTime.now();
        return agora;
    }

    public DateTimeFormatter getFormatterData() {
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuuMMdd");
        return formatterData;
    }

    public DateTimeFormatter getFormatterHora() {
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HHmmss");
        return formatterHora;
    }

    public String getDataFormatada() {
        String dataFormatada = getFormatterData().format(getAgora());
        return dataFormatada;
    }
     
    public String getHoraFormatada() {
        String horaFormatada = getFormatterHora().format(getAgora());
        return horaFormatada;
    }

    public String getDataHora() {
        String dataHora = String.format("%s %s", getDataFormatada(), getHoraFormatada());
        return dataHora;
    }

    public String getHoraPlus1hr() {
        String horaPlus1Hr = getFormatterHora().format(getAgora().plusMinutes(2));
        return horaPlus1Hr;
    }

    public String getHoraPlus7hr() {
        String horaPlus7Hr = getFormatterHora().format(getAgora().plusMinutes(4));
        return horaPlus7Hr;
    }

}
