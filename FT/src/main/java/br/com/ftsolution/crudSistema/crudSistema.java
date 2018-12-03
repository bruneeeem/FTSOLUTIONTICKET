/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.crudSistema;

import br.com.ftsolution.model.Tickets;
import java.sql.SQLException;

/**
 *
 * @author Bruno
 * @param <T>
 */
public interface crudSistema<T> {
    
    void alterar(T obj) throws SQLException, Exception;
    void cadastrar (T obj) throws SQLException, Exception;
    T pesquisar (Integer id) throws SQLException, Exception;
}
