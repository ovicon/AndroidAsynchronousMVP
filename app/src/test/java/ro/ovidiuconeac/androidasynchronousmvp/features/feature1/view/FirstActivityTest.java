package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class FirstActivityTest {

    @Mock
    private FirstActivity view;

    @Test
    public void testRequestLogin() {
        // Al least it tests that the method exists in the presenter
        // Assures interface consistency
        doNothing().when(view).requestLogin();
        view.requestLogin();
    }

    @Test
    public void testDoLogin() {
        // Al least it tests that the method exists in the presenter
        // Assures interface consistency
        doNothing().when(view).doLogin();
        view.doLogin();
    }

    @Test
    public void testShowLoginError() {
        // Al least it tests that the method exists in the presenter
        // Assures interface consistency
        doNothing().when(view).showLoginError();
        view.showLoginError();
    }

    @Test
    public void testRequestMessage() {
        // Al least it tests that the method exists in the presenter
        // Assures interface consistency
        doNothing().when(view).requestMessage();
        view.requestMessage();
    }

    @Test
    public void testPostMessage() {
        // Al least it tests that the method exists in the presenter
        // Assures interface consistency
        doNothing().when(view).postMessage(anyString());
        view.postMessage(anyString());
    }
}