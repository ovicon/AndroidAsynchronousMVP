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
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 1/2/17.
 */
public class FirstPresenterTest {

    private FirstPresenter presenter;
    private FirstView view;

    @Before
    public void setUp() {
        view = mock(FirstView.class);
        presenter = new FirstPresenterImpl(view);
    }

    @After
    public void tearDown() {
        presenter = null;
        view = null;
    }

    @Test
    public void testRequestLoginWithValidUser() {
        presenter.requestLogin(new User("admin", "admin"));
        verify(view, atLeast(1)).doLogin();
    }

    @Test
    public void testRequestLoginWithInvalidUser() {
        presenter.requestLogin(new User("adminaa", "admin"));
        verify(view, atLeast(1)).showLoginError();
    }


    @Test
    public void testRequestMessage() {
        presenter.requestMessage();
        verify(view, atLeast(1)).postMessage(anyString());
    }

    @Test
    public void testSetScreen() {
        // Al least it tests that the method exists in the presenter
        // Assures interface consistency
        presenter.setView(view);
    }

    @Test
    public void testGetUuid() {
        // Al least it tests that the method exists in the presenter
        // Assures interface consistency
        presenter.getUuid();
    }
}