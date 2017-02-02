package ro.ovidiuconeac.androidasynchronousmvp.features.feature1;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter.FirstPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view.FirstScreen;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ovidiu on 1/2/17.
 */
@Ignore
public class FirstPresenterTest {

    private FirstPresenter presenter;
    private FirstScreen screen;

    @Before
    public void setUp() {
        screen = mock(FirstScreen.class);
        presenter = new FirstPresenter(screen);
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
        presenter.requestLogin(new User("admin", "admin"));
        verify(screen).doLogin();
    }

    @Test
    public void testRequestUnsuccessfulLogin() {
        presenter.requestLogin(new User("", ""));
        verify(screen).showLoginError();
    }

    @Test
    public void requestMessage() {
        presenter.requestMessage(screen);
        verify(screen).postMessage(any(String.class));
    }
}
