package Entities;


/**
 *
 * @author Larissa
 */
public class DadoConexaoMaquina {
    
    private String descricao = "";
    private Integer codigo = 0;
    private MaquinaDeprecado maquina;
    private String vistoPorUltimo = "";
    
    
    public DadoConexaoMaquina(){
        
    }
    
    public DadoConexaoMaquina(Integer codigo, String descricao, MaquinaDeprecado maquina, String vistoPorUltimo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.maquina = maquina;
        this.vistoPorUltimo = vistoPorUltimo;
    }

    public String getVistoPorUltimo() {
        return vistoPorUltimo;
    }

    public void setVistoPorUltimo(String vistoPorUltimo) {
        this.vistoPorUltimo = vistoPorUltimo;
    }
    


    public MaquinaDeprecado getMaquina() {
        return maquina;
    }

    public void setMaquina(MaquinaDeprecado maquina) {
        this.maquina = maquina;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
   
    
}
