package med.voll.api.domain.dto;

import med.voll.api.domain.entity.Endereco;
import med.voll.api.domain.entity.Paciente;

public record DadosDetalhamentoPacienteDTO(String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}