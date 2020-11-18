
package Entities;

import javax.swing.JOptionPane;

public class AlertRelatorio extends Alerts{
    
    public void enviarAlertRelatorio(Alerts alertaRelatorio){
        alertaRelatorio.setTipoAlerta("Relatório");
        alertaRelatorio.setMensagemAlerta("Relatório enviado para o gestor!");
        JOptionPane.showMessageDialog(null, alertaRelatorio.getMensagemAlerta(), alertaRelatorio.getTipoAlerta(), JOptionPane.OK_OPTION);
    }
    
}
