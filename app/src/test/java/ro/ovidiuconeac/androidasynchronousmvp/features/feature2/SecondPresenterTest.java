package ro.ovidiuconeac.androidasynchronousmvp.features.feature2;

import android.graphics.Bitmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor.SecondPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view.SecondScreen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 1/2/17.
 */
public class SecondPresenterTest {

    private SecondScreen screen;
    private SecondPresenter presenter;

    @Before
    public void setUp() {
        screen = mock(SecondScreen.class);
        presenter = mock(SecondPresenter.class);
    }

    @After
    public void after() {
        screen = null;
        presenter = null;
    }

    @Test
    public void testRequestName() {
        doNothing().when(presenter).requestName();
        presenter.requestName();
    }

    @Test
    public void testRequestAge() {
        doNothing().when(presenter).requestAge();
        presenter.requestAge();
    }

    @Test
    public void testRequestImage() {
        doNothing().when(presenter).requestImage();
        presenter.requestImage();
    }

    @Test
    public void testSetScreen() {
        doNothing().when(presenter).setScreen(any(Screen.class));
        presenter.setScreen(screen);
    }

    @Test
    public void testGetUuid() {
        UUID uuid = UUID.randomUUID();
        when(presenter.getUuid()).thenReturn(uuid);
        UUID result = presenter.getUuid();
        assertNotNull(result);
        assertEquals(uuid, result);
    }
}
