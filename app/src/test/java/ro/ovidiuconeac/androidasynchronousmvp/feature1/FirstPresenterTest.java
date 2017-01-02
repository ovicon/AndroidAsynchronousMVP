package ro.ovidiuconeac.androidasynchronousmvp.feature1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.presenter.FirstPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.view.FirstScreen;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ovidiu on 1/2/17.
 */

public class FirstPresenterTest {

    private FirstPresenter presenter;
    private FirstScreen screen;

    @Before
    public void setUp() {
        presenter = new FirstPresenter();
        screen = mock(FirstScreen.class);
    }

    @After
    public void tearDown() {
        presenter = null;
        screen = null;
    }

    @Test
    public void testPresenterNotNull() {
        assertNotNull(presenter);
    }

    @Test
    public void testScreenNotNull() {
        assertNotNull(screen);
    }

    @Test
    public void testRequestSuccessfulLogin() {
        presenter.requestLogin(screen, new User("admin", "admin"));
        verify(screen).doLogin();
    }

    @Test
    public void testRequestUnsuccessfulLogin() {
        presenter.requestLogin(screen, new User("", ""));
        verify(screen).showLoginError();
    }

    @Test
    public void requestMessage() {
        presenter.requestMessage(screen);
        verify(screen).postMessage(any(String.class));
    }
}
