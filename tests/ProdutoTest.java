/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dscproject.tests;

import com.mycompany.dscproject.dao.ManagerDao;
import com.mycompany.dscproject.model.Item;
import com.mycompany.dscproject.model.Loja;
import com.mycompany.dscproject.model.NotaFiscal;
import com.mycompany.dscproject.model.Preco;
import com.mycompany.dscproject.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class ProdutoTest {
    @Test
    public void ItemWriteTest() {
        Produto produto = new Produto();
        List<Item> item = new ArrayList<Item>();
        List<Loja> loja = new ArrayList<Loja>();
        List<Preco> preco = new ArrayList<Preco>();

        
        produto.setNome("picole");
   
        ManagerDao.getCurrentInstance().insert(item); 
    
    };    
}
