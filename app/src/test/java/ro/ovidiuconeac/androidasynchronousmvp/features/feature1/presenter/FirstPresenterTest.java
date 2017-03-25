package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view.FirstView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 1/2/17.
 */
public class FirstPresenterTest {

    private FirstPresenterImpl presenter;
    private FirstView screen;

    @Before
    public void setUp() {
        screen = mock(FirstView.class);
        presenter = mock(FirstPresenterImpl.class);
    }

    @After
    public void tearDown() {
        presenter = null;
        screen = null;
    }

    @Test
    public void testRequestLogin() {
        doNothing().when(presenter).requestLogin(any(User.class));
        presenter.requestLogin(new User("admin", "admin"));
    }

    @Test
    public void testRequestMessage() {
        doNothing().when(presenter).requestMessage(any(FirstView.class));
        presenter.requestMessage(screen);
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