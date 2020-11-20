/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author markz
 */
public class Registro {
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuuMMdd");
    String dataFormatada = formatterData.format(agora);
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HHmmss");
    String horaFormatada = formatterHora.format(agora);

    public LocalDateTime getAgora() {
        return agora;
    }

    public DateTimeFormatter getFormatterData() {
        return formatterData;
    }

    public String getDataFormatada() {
        return dataFormatada;
    }

    public DateTimeFormatter getFormatterHora() {
        return formatterHora;
    }

    public String getHoraFormatada() {
        return horaFormatada;
    }
    
    
}
