package projeto.sistema.de.biblioteca;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {

	public AppTest() {
		System.out.println("oi");
	}

	 
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	 
	public void testApp() {
		assertTrue(true);
	}
}
