package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model;

import android.content.Context;
import android.graphics.Bitmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor.SecondPresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 1/2/17.
 */

public class SecondModelTest {

    private SecondPresenter presenter;
    private SecondModel model;

    @Before
    public void setUp() {
        presenter = mock(SecondPresenter.class);
        model = new SecondModel(presenter);
    }

    @After
    public void tearDown() {
        model = null;
    }

    @Test
    public void testRequestName() {
        model.requestName();
        verify(presenter, times(1)).postName(any(Name.class));
    }

    @Test
    public void testRequestAge() {
        model.requestAge();
        verify(presenter, times(1)).postAge(any(Age.class));
    }

    @Ignore
    @Test
    public void testRequestImage() {
        SecondModel model = mock(SecondModel.class);
        model.requestImage(any(Context.class));
    }
}