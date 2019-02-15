/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.EfetivacaoDAO;
import br.com.intranet.cenopservicoscwb.entity.Efetivacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author f5078775
 */
@ManagedBean
@SessionScoped
public class EfetivacaoBean extends CrudBean<Efetivacao, EfetivacaoDAO> {

    private EfetivacaoDAO efetivacaoDAO;

    @PostConstruct
    public void init() {
        novo();
    }

    @Override
    public EfetivacaoDAO getDao() {
        if (efetivacaoDAO == null) {
            efetivacaoDAO = new EfetivacaoDAO();
        }
        return efetivacaoDAO;

    }

    @Override
    public Efetivacao criarNovaEntidade() {
        return new Efetivacao();

    }

}
