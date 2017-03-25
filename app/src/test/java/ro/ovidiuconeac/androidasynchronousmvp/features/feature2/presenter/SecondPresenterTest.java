package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presenter;

import android.graphics.Bitmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor.SecondPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor.SecondPresenterImpl;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view.SecondView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 1/2/17.
 */
public class SecondPresenterTest {

    private SecondView view;
    private SecondPresenter presenter;

    @Before
    public void setUp() {
        view = mock(SecondView.class);
        presenter = new SecondPresenterImpl(view);
    }

    @After
    public void after() {
        view = null;
        presenter = null;
    }

    @Test
    public void testRequestName() {
        presenter.requestName();
        verify(view, atLeast(1)).postName(anyString());
    }

    @Test
    public void testRequestAge() {
        presenter.requestAge();
        verify(view, atLeast(1)).postAge(anyInt());
    }

    @Test
    @Ignore
    public void testRequestImage() {
        // Application context is null, how to test?
        presenter.requestImage();
        verify(view, atLeast(1)).postImage(any(Bitmap.class));
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
