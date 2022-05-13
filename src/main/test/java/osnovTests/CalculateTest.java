package osnovTests;

import static org.junit.Assert.*;
import osago.One_tarif;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateTest {

@BeforeClass
public static void setUpBeforeClass() throws Exception {
new One_tarif(5437, 1.72, 1, 1.93, 1.94, 0.6, 1);
}

@Test
public void test() {
assertTrue(One_tarif.getSum() == 5437*1.72*1*1.93*1.94*0.6*1);
}

}
