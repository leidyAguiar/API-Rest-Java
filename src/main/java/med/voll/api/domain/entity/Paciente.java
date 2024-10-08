package med.voll.api.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.dto.DadosAtualizacaoPacienteDTO;
import med.voll.api.domain.dto.DadosCadastroPacienteDTO;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Paciente(DadosCadastroPacienteDTO dadosPacienteDTO) {
        this.nome = dadosPacienteDTO.nome();
        this.email = dadosPacienteDTO.email();
        this.telefone = dadosPacienteDTO.telefone();
        this.cpf = dadosPacienteDTO.cpf();
        this.endereco = new Endereco(dadosPacienteDTO.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoPacienteDTO dadosAtualizacaoPacienteDTO) {
        if (dadosAtualizacaoPacienteDTO.nome() != null) {
            this.nome = dadosAtualizacaoPacienteDTO.nome();
        }
        if (dadosAtualizacaoPacienteDTO.telefone() != null) {
            this.telefone = dadosAtualizacaoPacienteDTO.telefone();
        }
        if (dadosAtualizacaoPacienteDTO.dadosEnderecoDTO() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizacaoPacienteDTO.dadosEnderecoDTO());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}