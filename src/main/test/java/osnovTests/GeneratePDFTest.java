package osnovTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import osago.PdfListener;

public class GeneratePDFTest {
	String first = "1";
	String second = "2";
	String third = "3";
	String fourth = "4";
	String fith = "5";
	String sixth = "6";
	String seventh = "7";
	String eighth = "8";

	@Test
	public void test() throws FileNotFoundException, IOException {
		assertNotNull(new PdfListener(first, second, third, fourth, fith, sixth, seventh, eighth));
	}

}