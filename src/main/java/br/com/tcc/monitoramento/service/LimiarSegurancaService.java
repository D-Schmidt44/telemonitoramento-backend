package br.com.tcc.monitoramento.service;

import br.com.tcc.monitoramento.model.Cuidador;
import br.com.tcc.monitoramento.model.LimiarSeguranca;
import br.com.tcc.monitoramento.model.Paciente;
import br.com.tcc.monitoramento.repository.CuidadorRepository;
import br.com.tcc.monitoramento.repository.LimiarSegurancaRepository;
import br.com.tcc.monitoramento.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LimiarSegurancaService {

    private final LimiarSegurancaRepository limiarSegurancaRepository;
    private final PacienteRepository pacienteRepository;
    private final CuidadorRepository cuidadorRepository;

    public LimiarSegurancaService(LimiarSegurancaRepository limiarSegurancaRepository,
                                  PacienteRepository pacienteRepository,
                                  CuidadorRepository cuidadorRepository) {
        this.limiarSegurancaRepository = limiarSegurancaRepository;
        this.pacienteRepository = pacienteRepository;
        this.cuidadorRepository = cuidadorRepository;
    }

    public LimiarSeguranca salvar(LimiarSeguranca limiarSeguranca) {
        // Validação do tipo de sinal vital
        if (limiarSeguranca.getTipoSinalVital() == null) {
            throw new IllegalArgumentException("O tipo do sinal vital é obrigatório!");
        }

        // Validação do paciente
        if (limiarSeguranca.getPaciente() == null || limiarSeguranca.getPaciente().getId() == null) {
            throw new IllegalArgumentException("O paciente é obrigatório para cadastrar o limiar!");
        }

        Long pacienteId = limiarSeguranca.getPaciente().getId();

        LimiarSeguranca existente = limiarSegurancaRepository.findByPacienteIdAndTipoSinalVital(pacienteId, limiarSeguranca.getTipoSinalVital());

        if (existente != null) {
            throw new IllegalStateException("Já existe um limiar cadastrado!");
        }

        // Se passar por todas as validações, salva com segurança
        return limiarSegurancaRepository.save(limiarSeguranca);
    }
}