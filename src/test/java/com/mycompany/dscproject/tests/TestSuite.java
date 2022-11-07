package com.mycompany.dscproject.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    com.mycompany.dscproject.tests.ItemTestes.class,
    com.mycompany.dscproject.tests.LojaTestes.class,
    com.mycompany.dscproject.tests.NotaFiscalTestes.class,
    com.mycompany.dscproject.tests.PrecoTestes.class,
    com.mycompany.dscproject.tests.ProdutoTestes.class,
    com.mycompany.dscproject.tests.UsuarioTestes.class
})
public class TestSuite {}
