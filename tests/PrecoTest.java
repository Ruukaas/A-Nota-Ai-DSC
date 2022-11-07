/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Preco;
import com.mycompany.dscproject.model.Produto;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author Inspiron 15 5566
 */
public class PrecoTest {
    @Test
    public void PrecoWriteTest(){
        Preco preco = new Preco();
        Produto produto = new Produto();
        Date dataDeRegistro = null;
        Item item = null;
        
        preco.setDataDeRegistro(dataDeRegistro);
        preco.setItem(item);
        preco.setProduto(produto);
        preco.setValor(324);

                ManagerDao.getCurrentInstance().insert(preco);
    };
}
