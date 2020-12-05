
import Banco.Insertbd;
import Banco.Registro;
import ColetaDados.Componente;
import ColetaDados.Cpu;
import ColetaDados.Disco;
import ColetaDados.Maquina;
import ColetaDados.Mem;
import ColetaDados.Processos;
import ColetaDados.Sessao;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.hardware.CentralProcessor;

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
        Maquina maquina = new Maquina();
        Insertbd banco = new Insertbd();
        
        System.out.println(maquina.getCpuUsage());
//        banco.inserirPrograma("");
//
//        System.out.println(cpu.getComp());
//        System.out.println(mem.getComp());
//        System.out.println(disco.getComp());

//           System.out.println(banco.selectProgramas());

////        List x = new ArrayList();
////
////        x.add("java");
////        x.add("firefox");
////        x.add("netbeans64");
//
////        for (Object elem : x) {
////            System.out.println(elem);
////            System.out.println(inserir.selectProgramas());
////            System.out.println(!inserir.selectProgramas().contains(elem));
////        }

//        System.out.println(new Registro().getDataFormatada() + new Registro().getHoraFormatada());

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
  
