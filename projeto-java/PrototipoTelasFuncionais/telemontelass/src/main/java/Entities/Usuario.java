package Entities;

public class Usuario {
    
    private Integer codigo = 0;
    private String nome = "";
    private String login = "";
    private String senha = "";
    private String tipoUsuario = "";

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    public Usuario(String login, String senha, String tipoUsuario) {
        this.codigo = 1;
        this.nome = login;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
       
    }
    
    public Usuario(){
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String fazerLogin(){
        if(this.login.equals("victoria") && this.senha.equals("321") && this.tipoUsuario.equals("Funcionario")){
            return "Funcionario";
        }
        else {
            return "";
        }
    }
    
}
