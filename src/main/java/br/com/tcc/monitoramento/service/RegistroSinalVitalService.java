package br.com.tcc.monitoramento.service;

import br.com.tcc.monitoramento.model.LimiarSeguranca;
import br.com.tcc.monitoramento.model.RegistroSinalVital;
import br.com.tcc.monitoramento.repository.LimiarSegurancaRepository;
import br.com.tcc.monitoramento.repository.PacienteRepository;
import br.com.tcc.monitoramento.repository.RegistroSinalVitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroSinalVitalService {

    private final RegistroSinalVitalRepository registroSinalVitalRepository;
    private final PacienteRepository pacienteRepository;
    private final LimiarSegurancaRepository limiarSegurancaRepository;
    private final MotorRegraService motorRegraService;



    @Autowired
    public RegistroSinalVitalService(RegistroSinalVitalRepository registroSinalVitalRepository, PacienteRepository pacienteRepository, LimiarSegurancaRepository limiarSegurancaRepository, MotorRegraService motorRegraService) {
        this.registroSinalVitalRepository = registroSinalVitalRepository;
        this.pacienteRepository = pacienteRepository;
        this.limiarSegurancaRepository = limiarSegurancaRepository;
        this.motorRegraService = motorRegraService;
    }


    public RegistroSinalVital salvar(RegistroSinalVital registroSinalVital){

        if (registroSinalVital.getPaciente() == null)
            throw new RuntimeException("Paciente não encontrado, ou não cadastrado");

        //salvar no banco
        RegistroSinalVital salvo = registroSinalVitalRepository.save(registroSinalVital);

        //busca limiar
        LimiarSeguranca limiarSeguranca = limiarSegurancaRepository.findByTipoSinalVitalAndPaciente(
                salvo.getTipoSinalVital(),
                salvo.getPaciente()
        );

        if (limiarSeguranca != null) {
            motorRegraService.analisarRegistro(limiarSeguranca, salvo);
        }

        return salvo;

    }

// listar registros do paciente
    public List<RegistroSinalVital> listarPorPaciente(Long pacienteId) {
        return registroSinalVitalRepository.findByPacienteId(pacienteId);
    }


}
