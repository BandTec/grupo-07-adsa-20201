package Entities;

import java.util.concurrent.ThreadLocalRandom;

public class Alerts {
    private Integer idAlerta = ThreadLocalRandom.current().nextInt();
    private String tipoAlerta;
    private String mensagemAlerta;

    public Alerts() {
        this.idAlerta = idAlerta;
        this.tipoAlerta = tipoAlerta;
        this.mensagemAlerta = mensagemAlerta;
    }    
    

    public Integer getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getMensagemAlerta() {
        return mensagemAlerta;
    }

    public void setMensagemAlerta(String mensagemAlerta) {
        this.mensagemAlerta = mensagemAlerta;
    }     
    
}

