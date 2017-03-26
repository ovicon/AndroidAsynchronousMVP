package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter.FirstPresenter;

import static org.junit.Assert.assertEquals;
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

    private FirstModel firstModel;

    @Before
    public void setUp() {
        firstModel = new FirstModel();
    }

    @After
    public void tearDown() {
        firstModel = null;
    }

    @Test
    public void testRequestLoginWithValidUser() {
        Valid result = firstModel.requestLogin(new User("admin", "admin"));
        assertNotNull(result);
        assertEquals(true, result.getValue());
    }

    @Test
    public void testRequestLoginWithInvalidUser() {
        Valid result = firstModel.requestLogin(new User("admina", "admin"));
        assertNotNull(result);
        assertEquals(false, result.getValue());
    }

    @Test
    public void requestMessage() {
        Message result = firstModel.requestMessage();
        assertNotNull(result);
        assertNotNull(result.getMessage());
    }
}