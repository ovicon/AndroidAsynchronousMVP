package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter.FirstPresenter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ovidiu on 1/2/17.
 */

public class FirstModelTest {

    private FirstPresenter firstPresenter;
    private FirstModel firstModel;

    @Before
    public void setUp() {
        firstPresenter = mock(FirstPresenter.class);
        firstModel = new FirstModel(firstPresenter);
    }

    @After
    public void tearDown() {
        firstModel = null;
    }

    @Test
    public void testRequestLoginWithValidUser() {
        firstModel.requestLogin(new User("admin", "admin"));
        verify(firstPresenter, atLeast(1)).doLogin();
    }

    @Test
    public void testRequestLoginWithInvalidUser() {
        firstModel.requestLogin(new User("admina", "admin"));
        verify(firstPresenter, atLeast(1)).showLoginError();
    }

    @Test
    public void requestMessage() {
        firstModel.requestMessage();
        verify(firstPresenter, atLeast(1)).postMessage(any(Message.class));
    }
}