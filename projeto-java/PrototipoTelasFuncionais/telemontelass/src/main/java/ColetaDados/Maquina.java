package ColetaDados;

import Banco.Insertbd;
import Banco.Registro;
import java.util.ArrayList;
import java.util.List;
import oshi.software.os.OSProcess;

public class Maquina {

    private SistemaOperacional os = new SistemaOperacional();
    private Cpu cpu = new Cpu("cpu");
    private Mem mem = new Mem("ram");
    private Disco disco = new Disco("disco");
    private Sessao sessao = new Sessao();
    private Processos processos = new Processos();
    Insertbd insert = new Insertbd();

    private long timeUp;
    private String osMaquina;
    private String hostname;

    public Maquina() {
        this.osMaquina = os.getOs().toString();
        this.timeUp = Integer.valueOf(new Registro().getHoraFormatada());
    }

    public String getOsMaquina() {
        return osMaquina;
    }
    
    public String getUsers(){
        return sessao.getUser(0);
    }
    
    public String getHostname(){
        return sessao.getHostname(0);
    }

    public long getTimeUp() {
        return timeUp;
    }
    
    public double getCpuUsage() {
        return cpu.getCpuUsage();
    }

    public double getMemUsage() {
        return mem.getMemUsage();
    }

    public double getMemTotal() {
        return mem.getMemTotal();
    }

    public List<String> getDisks() {
        List<String> allDisks = new ArrayList();
        for (int i = 0; i <= disco.quantidadeDisco(); i++) {
            allDisks.add(disco.diskName(i));
        }
        return allDisks;
    }

    public Disco getDisco() {
        return disco;
    }
    
    public List<String> getProcessesName(){
        List<String> listProcs = new ArrayList();
        for (int i = 0; i < processos.getOsProcesses().size(); i++) {

                OSProcess p = processos.getOsProcesses().get(i);

                listProcs.add(String.format("%s\n", p.getName()));
                
                insert.InserirProcessos(p.getName(), 
                        p.getProcessCpuLoadBetweenTicks(p) / cpu.getCpu().getLogicalProcessorCount(), 
                        p.getResidentSetSize(), 
                        this.getHostname());
    }
        return listProcs;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Mem getMem() {
        return mem;
    }
    
}
