package osnovTests;

import static org.junit.Assert.*;

import org.junit.Test;

import osago.SignUp;

public class StartTest {

	@Test
	public void test() {
		assertTrue(SignUp.name != null && SignUp.password != null);
	}

}