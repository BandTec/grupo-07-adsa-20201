package Services;



import Entities.DadoConexaoMaquina;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    
    //aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
    private String colunas[] = {"ID", "MAQUINA", "STATUS", "VISTO"};
    private DadoConexaoMaquina dcm = new DadoConexaoMaquina();
    private ArrayList<DadoConexaoMaquina> conexoes;
    private final int COLUNA_ID = 0;
    private final int COLUNA_MAQUINA = 1;
    private final int COLUNA_STATUS = 2;
    private final int COLUNA_VISTO = 3;
    
        public TableModel(ArrayList<DadoConexaoMaquina> conexoes) {
        this.conexoes = conexoes;
    }
        
        //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
        //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return conexoes.size();
    }
    
        //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
        //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }
    
    
        //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUNA_ID:
                return Integer.class;
            case COLUNA_MAQUINA:
                return String.class;
            case COLUNA_STATUS:
                return String.class;
            case COLUNA_VISTO:
                return String.class;
            default:
                return String.class;
        }
    }
    
        //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DadoConexaoMaquina dcm = this.conexoes.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_ID:
                return dcm.getCodigo();
            case COLUNA_MAQUINA:
                return dcm.getMaquina().getNome();
            case COLUNA_STATUS:
                return dcm.getDescricao();
            case COLUNA_VISTO:
                return dcm.getVistoPorUltimo();
        }
        return null;
    }
    
    public Object getDadoConexaoMaquina(int rowIndex) {
	DadoConexaoMaquina dcm = this.conexoes.get(rowIndex);
        return dcm;
}    
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        DadoConexaoMaquina dcm = this.conexoes.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case COLUNA_ID:
                dcm.setCodigo((int) aValue);
                break;
            case COLUNA_MAQUINA:
                dcm.getMaquina().setNome(String.valueOf(aValue));
                break;
            case COLUNA_STATUS:
                dcm.setDescricao(String.valueOf(aValue));
                break;
                
            case COLUNA_VISTO:
                dcm.setVistoPorUltimo(String.valueOf(aValue));
                break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
    

    
}
