package br.com.rpires.dao;

import br.com.rpires.dao.IEstoqueDAO;
import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Estoque;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO {
    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setId(entity.getId());
        entityCadastrado.setQuantidade(entity.getQuantidade());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_ESTOQUE ");
        sb.append("(id, quantidade)");
        sb.append("VALUES (?,?)");
        return sb.toString();
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE ID = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_CLIENTE ");
        sb.append("SET QUANTIDADE = ?");
        sb.append(" WHERE ID = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1,entity.getId());
        stmInsert.setInt(2, entity.getQuantidade());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long valor) throws SQLException {
        stmDelete.setLong(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setInt(1, entity.getQuantidade());
        stmUpdate.setLong(2, entity.getId());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmUpdate, Long valor) throws SQLException {
        stmUpdate.setLong(1, valor);
    }
}
