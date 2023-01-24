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
    com.mycompany.dscproject.tests.ClienteTeste.class
})
public class TestSuite {}
