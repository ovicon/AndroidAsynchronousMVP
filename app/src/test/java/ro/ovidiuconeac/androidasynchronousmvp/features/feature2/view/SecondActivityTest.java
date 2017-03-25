package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view;

import android.content.Context;
import android.graphics.Bitmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public class SecondActivityTest {

    private SecondActivity view;

    @Before
    public void setUp() {
        view = mock(SecondActivity.class);
    }

    @After
    public void tearDown() {
        view = null;
    }

    @Test
    public void testRequestName() {
        doNothing().when(view).requestName();
        view.requestName();
    }

    @Test
    public void testPostName() {
        doNothing().when(view).postName(anyString());
        view.postName(anyString());
    }

    @Test
    public void testRequestAge() {
        doNothing().when(view).requestAge();
        view.requestAge();
    }

    @Test
    public void testPostAge() {
        doNothing().when(view).postAge(anyInt());
        view.postAge(anyInt());
    }

    @Test
    public void testRequestImage() {
        doNothing().when(view).requestImage();
        view.requestImage();
    }

    @Test
    public void testPostImage() {
        doNothing().when(view).postImage(any(Bitmap.class));
        view.postImage(any(Bitmap.class));
    }

    @Test
    public void testGetContext() {
        Context context = mock(Context.class);
        when(view.getContext()).thenReturn(context);
        Context result = view.getContext();
        assertNotNull(result);
        assertEquals(context, result);
    }
}