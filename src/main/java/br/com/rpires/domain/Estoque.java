package br.com.rpires.domain;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import br.com.rpires.dao.Persistente;

@Tabela("tb_estoque")
public class Estoque implements Persistente {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Integer quantidade;

    public Estoque(Produto produto, Integer quantidade){
        this.id = produto.getId();
        this.quantidade = quantidade;
    }
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
