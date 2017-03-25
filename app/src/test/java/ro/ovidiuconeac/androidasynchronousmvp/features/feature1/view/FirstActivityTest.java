package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view;

import android.graphics.Bitmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public class FirstActivityTest {

    private FirstActivity view;

    @Before
    public void setUp() {
        view = mock(FirstActivity.class);
    }

    @After
    public void tearDown() {
        view = null;
    }

    @Test
    public void testRequestLogin() {
        doNothing().when(view).requestLogin();
        view.requestLogin();
    }

    @Test
    public void testDoLogin() {
        doNothing().when(view).doLogin();
        view.doLogin();
    }

    @Test
    public void testShowLoginError() {
        doNothing().when(view).showLoginError();
        view.showLoginError();
    }

    @Test
    public void testRequestMessage() {
        doNothing().when(view).requestMessage();
        view.requestMessage();
    }

    @Test
    public void testPostMessage() {
        doNothing().when(view).postMessage(anyString());
        view.postMessage(anyString());
    }
}