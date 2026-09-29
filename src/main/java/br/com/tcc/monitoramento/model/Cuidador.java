package br.com.tcc.monitoramento.model;

import java.util.ArrayList;
import java.util.List;

// atributos
public class Cuidador {

    private String nome;
    private int idade;
    private String telefone;
    private List<Paciente> pacientes = new ArrayList<>();


    //Construtor
    public Cuidador(String nome, int idade, String telefone, Paciente pacientes) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.pacientes.add(pacientes);
    }


    //Métodos

    public void definirLimiarPaciente(Paciente paciente, LimiarSeguranca limiarSeguranca) {
        paciente.adicionarAListaLimiarSegurancaPaciente(limiarSeguranca);

    }

    public void checarRegistroPaciente(Paciente paciente) {
        paciente.AnalisarRegistros();
    }

}


