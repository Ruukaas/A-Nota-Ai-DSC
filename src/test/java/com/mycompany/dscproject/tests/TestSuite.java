package com.mycompany.dscproject.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    com.mycompany.dscproject.tests.ItemTeste.class,
    com.mycompany.dscproject.tests.LojaTeste.class,
    com.mycompany.dscproject.tests.NotaFiscalTeste.class,
    com.mycompany.dscproject.tests.PrecoTeste.class,
    com.mycompany.dscproject.tests.ProdutoTeste.class,
    com.mycompany.dscproject.tests.VendedorTeste.class,
    com.mycompany.dscproject.tests.ClienteTeste.class,
    com.mycompany.dscproject.tests.ItemJPQL.class,
    com.mycompany.dscproject.tests.LojaJPQL.class,
    com.mycompany.dscproject.tests.NotaFiscalJPQL.class,
    com.mycompany.dscproject.tests.PrecoJPQL.class,
    com.mycompany.dscproject.tests.ProdutoJPQL.class,
    com.mycompany.dscproject.tests.VendedorJPQL.class,
    com.mycompany.dscproject.tests.ClienteJPQL.class
})
public class TestSuite {}
