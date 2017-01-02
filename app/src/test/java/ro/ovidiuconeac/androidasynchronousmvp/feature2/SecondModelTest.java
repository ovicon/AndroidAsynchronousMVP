package ro.ovidiuconeac.androidasynchronousmvp.feature2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ovidiuconeac.androidasynchronousmvp.feature2.model.SecondModel;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by ovidiu on 1/2/17.
 */

public class SecondModelTest {

    private static SecondModel secondModel;

    @Before
    public void setUp() {
        secondModel = new SecondModel();
    }

    @After
    public void tearDown() {
        secondModel = null;
    }

    @Test
    public void testModelIsNotNull() {
        assertNotNull(secondModel);
    }

    @Test
    public void testRequestAge() {
        boolean testResult = false;
        for (int i=0; i<10 ; i++) {
            testResult = isValid(secondModel.requestAge());
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
        // TODO - hot to test?
    }
}
