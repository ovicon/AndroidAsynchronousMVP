package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ovidiu on 1/2/17.
 */

public class SecondModelTest {

   /* private static SecondModel secondModel;

    @Before
    public void setUp() {
        secondModel = new SecondModel();
    }

    @After
    public void tearDown() {
        secondModel = null;
    }

    @Test
    public void testRequestAge() {
        boolean testResult = false;
        for (int i=0; i<10 ; i++) {
            testResult = isValid(secondModel.requestAge().getAge());
            if (!testResult) {
                break;
            }
        }
        assertTrue(testResult);
    }

    private boolean isValid(int age) {
        return age >= 0 && age <= 100;
    }

    @Test
    public void testRequestImage() {
        Image image = new Image();
        SecondModel model = mock(SecondModel.class);
        when(model.requestImage(any(Context.class))).thenReturn(image);
        Image result = model.requestImage(any(Context.class));
        assertNotNull(result);
        assertEquals(image, result);
    }*/
}