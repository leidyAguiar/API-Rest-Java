package med.voll.api.domain.dto;

import med.voll.api.domain.entity.Medico;
import med.voll.api.enums.Especialidade;

public record DadosListagemMedicoDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DadosListagemMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}