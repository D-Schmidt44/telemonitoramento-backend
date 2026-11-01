package br.com.tcc.monitoramento.repository;

import br.com.tcc.monitoramento.model.LimiarSeguranca;
import br.com.tcc.monitoramento.model.Paciente;
import br.com.tcc.monitoramento.model.RegistroSinalVital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiarSegurancaRepository extends JpaRepository<LimiarSeguranca, Long> {

    LimiarSeguranca findByPacienteIdAndTipoSinalVital(Long pacienteId, RegistroSinalVital.TipoSinalVital tipoSinalVital);

    LimiarSeguranca findByTipoSinalVitalAndPaciente(RegistroSinalVital.TipoSinalVital tipoSinalVital, Paciente paciente);
}
