/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.GrupoTratamentoDAO;
import br.com.intranet.cenopservicoscwb.entity.GrupoTratamento;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class GrupoTratamentoBean extends CrudBean<GrupoTratamento, GrupoTratamentoDAO> {

    private GrupoTratamentoDAO grupoTratamentoDAO;

    @PostConstruct

    public void init() {
        buscar();
    }

    @Override
    public GrupoTratamentoDAO getDao() {

        if (grupoTratamentoDAO == null) {
            grupoTratamentoDAO = new GrupoTratamentoDAO();
        }
        return grupoTratamentoDAO;
    }

    @Override
    public GrupoTratamento criarNovaEntidade() {
        return new GrupoTratamento();
    }

}
