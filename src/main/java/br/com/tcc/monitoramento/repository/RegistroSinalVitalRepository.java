package br.com.tcc.monitoramento.repository;


import br.com.tcc.monitoramento.model.RegistroSinalVital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegistroSinalVitalRepository extends JpaRepository<RegistroSinalVital, Long> {
    List<RegistroSinalVital> findByPacienteId(Long pacienteId);



}
