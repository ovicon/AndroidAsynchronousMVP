package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.FirstModel;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    public void testUserIsValid() {
        assertTrue(firstModel.isValid(new User("admin", "admin")));
    }

    @Test
    public void testUserIsInvalidWithEmptyCredentials() {
        assertFalse(firstModel.isValid(new User("", "")));
    }

    @Test
    public void testUserIsInvalidWithWrongUserAndRightPassword() {
        assertFalse(firstModel.isValid(new User("Admin", "admin")));
    }

    @Test
    public void testUserIsInvalidWithWrongPasswordAndRightUser() {
        assertFalse(firstModel.isValid(new User("admin", "Admin")));
    }

    @Test
    public void testUserIsInvalidWithMissingPassword() {
        assertFalse(firstModel.isValid(new User("admin", "")));
    }

    @Test
    public void testUserIsInvalidWithMissingUser() {
        assertFalse(firstModel.isValid(new User("", "admin")));
    }

    @Test
    public void requestMessage() {
        assertNotNull(firstModel.requestMessage());
        assertNotNull(firstModel.requestMessage().getMessage());
    }
}