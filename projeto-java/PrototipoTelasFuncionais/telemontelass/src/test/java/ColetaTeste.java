
import ColetaDados.Componente;
import ColetaDados.Cpu;
import ColetaDados.Disco;
import ColetaDados.Maquina;
import ColetaDados.Mem;
import ColetaDados.Processos;
import ColetaDados.Sessao;
import java.awt.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Markz
 */
public class ColetaTeste {

    public static void main(String[] args) throws InterruptedException {

        Cpu cpu = new Cpu("cpu");
//        Mem mem = new Mem("ram");
//        Disco disco = new Disco();
          Sessao session = new Sessao();
//        
//        System.out.println(cpu.getComp());
//        System.out.println(mem.getComp());
//        System.out.println(disco.getComp());
        Maquina maquina = new Maquina();
        while(true){
        System.out.println(session.getLoginTime(2));
            System.out.println(maquina.getTimeUp());
                    Thread.sleep(1000);
    }
//        ColetaDados dados = new ColetaDados();
//        
//        dados.getCpuUsage();
//        dados.getMemUsage();
//        dados.getOsProcesses();
//        dados.getOsUpTime();
//        
//        System.out.println(dados);
//        Sistema sistema = new Sistema();
//        SistemaOperacional os = new SistemaOperacional();
//        Componente comp = new Componente();
//        Cpu cpu = new Cpu();
//        Mem mem = new Mem();
//        Disco disco = new Disco();
//        Users users = new Users();
//        Processos procs = new Processos();
//        
//        cpu.getCpuUsage();
//        mem.getMemUsage();
//        procs.getOsProcesses();
//        os.getOsUpTime();
//        
//        System.out.println(sistema);
//        System.out.println(os);
//        System.out.println(cpu);
//        System.out.println(mem);
//        System.out.println(disco);
//        System.out.println(users);
//        System.out.println(procs);
    }
}
