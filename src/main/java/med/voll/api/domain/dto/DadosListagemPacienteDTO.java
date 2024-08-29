package med.voll.api.domain.dto;

import med.voll.api.domain.entity.Paciente;

public record DadosListagemPacienteDTO(
        String nome,
        String email,
        String cpf) {

    public DadosListagemPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}