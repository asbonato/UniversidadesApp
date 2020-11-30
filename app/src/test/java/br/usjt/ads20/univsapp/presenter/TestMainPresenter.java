package br.usjt.ads20.univsapp.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import br.usjt.ads20.univsapp.model.Universidade;
import br.usjt.ads20.univsapp.view.MainView;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestMainPresenter {
    MainPresenter presenter;
    Universidade universidade;
    Universidade[] universidades;
    String url;

    @Mock
    private MainView view;

    @Before
    public void setup(){
        when(view.estaConectado()).thenReturn(true);
        presenter = new MainPresenter(view);
        universidade = new Universidade("Universidade São Judas Tadeu");
        universidades = new Universidade[1];
        universidades[0] = universidade;
        url = "http://universities.hipolabs.com/search?name=judas";
    }

    @Test
    public void testaBuscarUniversidades(){
        presenter.getUniversidades(url);
        when(view.getUniversidades()).thenReturn(universidades);
        System.out.println("TestMainPresenter: view "+ view.getUniversidades()[0].toString());
        System.out.println("TestMainPresenter: presenter "+ presenter.getUnivs()[0].toString());
        assertEquals(0, view.getUniversidades()[0].compareTo(presenter.getUnivs()[0]));
    }
}
