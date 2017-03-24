package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor.SecondPresenterImpl;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view.SecondView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 1/2/17.
 */
public class SecondPresenterTest {

    private SecondView screen;
    private SecondPresenterImpl presenter;

    @Before
    public void setUp() {
        screen = mock(SecondView.class);
        presenter = mock(SecondPresenterImpl.class);
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
        doNothing().when(presenter).setView(any(Screen.class));
        presenter.setView(screen);
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
