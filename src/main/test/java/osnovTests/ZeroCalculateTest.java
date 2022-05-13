package osnovTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import osago.One_tarif;

public class ZeroCalculateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new One_tarif(0, 0, 1, 0, 1.94, 0.6, 1);
	}

	@Test
	public void test() {
		assertNotNull(One_tarif.getSum());
	}

}