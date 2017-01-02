package ro.ovidiuconeac.androidasynchronousmvp.feature2;

import android.graphics.Bitmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ovidiuconeac.androidasynchronousmvp.feature2.presentor.SecondPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.feature2.view.SecondScreen;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ovidiu on 1/2/17.
 */

public class SecondPresenterTest {

    private SecondScreen screen;
    private SecondPresenter presenter;

    @Before
    public void setUp() {
        screen = mock(SecondScreen.class);
        presenter = new SecondPresenter();
    }

    @After
    public void after() {
        screen = null;
        presenter = null;
    }

    @Test
    public void testScreenNotNull() {
        assertNotNull(screen);
    }

    @Test
    public void testPresenterNotNull() {
        assertNotNull(presenter);
    }

    @Test
    public void testRequestAge() {
        presenter.requestAge(screen);
        verify(screen).postAge(anyInt());
    }

    @Test
    public void testRequestImage() {
        // TODO - hot to test?
    }

    @Test
    public void testRequestName() {
        presenter.requestName(screen);
        verify(screen).postName(anyString());
    }
}
