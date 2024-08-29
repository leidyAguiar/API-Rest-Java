package med.voll.api.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.dto.DadosEnderecoDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEnderecoDTO dadosEnderecoDTO) {
        this.logradouro = dadosEnderecoDTO.logradouro();
        this.bairro = dadosEnderecoDTO.bairro();
        this.cep = dadosEnderecoDTO.cep();
        this.numero = dadosEnderecoDTO.numero();
        this.complemento = dadosEnderecoDTO.complemento();
        this.cidade = dadosEnderecoDTO.cidade();
        this.uf = dadosEnderecoDTO.uf();
    }

    public void atualizarInformacoes(DadosEnderecoDTO dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }
}