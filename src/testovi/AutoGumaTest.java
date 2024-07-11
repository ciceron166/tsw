package testovi;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import gume.AutoGuma;
import gume.VulkanizerskaRadnja;

public class AutoGumaTest {
	
	public AutoGuma AG;
	
	
	@Rule
	public final TestRule timeout = Timeout.seconds(5);
	
	@BeforeClass
	public static void ProveriOs() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public final ErrorCollector ec = new ErrorCollector();
	
	@Before
	public void init() {
		AG = new AutoGuma("Michelin", true, 18, 180, 40);
	}
	
	@Rule
	public final TestName name = new TestName();


	@Test
	public void testGetZimska() {
		boolean ocekivaniR = true;
		try {
			boolean stvarniR = AG.getZimska();
			assertEquals(ocekivaniR,stvarniR);
		}catch(Throwable t) {
			ec.addError(t);
		}
	}
	
	@Test
	public void setZimskaTest() {
		AG.setZimska(true);
		boolean ocekivaniR = true;
		boolean stvarniR = AG.getZimska();
		assertEquals(ocekivaniR,stvarniR);
		
		
		AG.setZimska(false);
		 ocekivaniR = false;
		 stvarniR = AG.getZimska();
		assertEquals(ocekivaniR,stvarniR);
		
	}
	
	@Test
	public void getMarkaModelTest() {
		String ocekivaniR = "Michelin";
		String stvarniR = AG.getMarkaModel();
		assertEquals(ocekivaniR,stvarniR);
	}
	
	/* radi ali da probam onaj stanicev metod
	 * @Test public void setMarkaModelTest() { AG.setMarkaModel("Michelin"); String
	 * ocekivaniR = "Michelin"; String stvarniR = AG.getMarkaModel();
	 * assertEquals(ocekivaniR,stvarniR);
	 * 
	 * try { AG.setMarkaModel(""); }catch(RuntimeException e) {
	 * assertEquals("Morate uneti marku i model",e.getMessage()); }
	 * 
	 * }
	 */
	
	@Test(expected = RuntimeException.class)
	public void getMarkaTest1() {
		String ocekivaniR = "Michelin";
		String stvarniR = AG.getMarkaModel();
		assertEquals(ocekivaniR,stvarniR);
		
		AG.setMarkaModel(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void getMarkaTest2() {
		String ocekivaniR = "Michelin";
		String stvarniR = AG.getMarkaModel();
		assertEquals(ocekivaniR,stvarniR);
		
		AG.setMarkaModel("A1");
	}
	
	@Test()
	public void getMarkaTest3() {
		String ocekivaniR = "Michelin";
		String stvarniR = AG.getMarkaModel();
		assertEquals(ocekivaniR,stvarniR);
		
		AG.setMarkaModel("KURELI");
		 ocekivaniR = "KURELI";
		 stvarniR = AG.getMarkaModel();
		assertEquals(ocekivaniR,stvarniR);
	}
	
	@Test
	public void getPrecnikTest() {
		int ocekivaniR = 18;
		int stvarniR = AG.getPrecnik();
		assertEquals(ocekivaniR,stvarniR);
	}
	
	@Test
	public void setPrecnikTest() {
		AG.setPrecnik(18);
		int ocekivaniR = 18;
		int stvarniR = AG.getPrecnik();
		assertEquals(ocekivaniR,stvarniR);
		
		try {
			AG.setPrecnik(25);
		}catch(RuntimeException e) {
			assertEquals("Precnik van opsega", e.getMessage());
		}
		
	}
	
	@Test(expected = RuntimeException.class)
	public void setPrecnikTest1() {
		
		AG.setPrecnik(18);
		int ocekivaniR = 18;
		int stvarniR = AG.getPrecnik();
		assertEquals(ocekivaniR,stvarniR);
		
		
		AG.setPrecnik(11);
	}
	
	@Test
	public void getSirinaTest() {
		int ocekivaniR = 180;
		int stvarniR = AG.getSirina();
		assertEquals(ocekivaniR,stvarniR);
	}
	
	@Test
	public void setSirinaTest() {
		AG.setSirina(180);
		int ocekivaniR = 180;
		int stvarniR = AG.getSirina();
		assertEquals(ocekivaniR,stvarniR);
		
		try {
			AG.setSirina(100);
		}catch(RuntimeException e) {
			assertEquals("Sirina van opsega", e.getMessage());
		}
		
		try {
			AG.setSirina(450);
		}catch(RuntimeException e) {
			assertEquals("Sirina van opsega", e.getMessage());
		}
		
	}
	
	@Test
	public void getVisinaTest() {
		int ocekivaniR = 40;
		int stvarniR = AG.getVisina();
		assertEquals(ocekivaniR,stvarniR);
	}
	
	
	@Test
	public void setVisinaTest() {
		AG.setVisina(40);
		int ocekivaniR = 40;
		int stvarniR = AG.getVisina();
		assertEquals(ocekivaniR,stvarniR);
		
		try {
			AG.setVisina(20);
		}catch(RuntimeException e) {
			assertEquals("Visina van opsega", e.getMessage());
		}
		
		try {
			AG.setVisina(500);
		}catch(RuntimeException e) {
			assertEquals("Visina van opsega", e.getMessage());
		}
		
	}

	
	@Test
	public void izracunajCenuTest() {
		double ocekivaniR = (AG.getPrecnik()*3+AG.getSirina()+AG.getVisina())*28.53;
		double stvarniR = AG.izracunajCenu();
		assertEquals(ocekivaniR, stvarniR,0.001);
	}
	
	@Test
	public void povoljnaGumaTest() {
		boolean ocekivaniR = false;
		boolean stvarniR = AG.povoljnaGuma();
		assertEquals(ocekivaniR, stvarniR);
		
	}
	
	@Test
	public void povoljnaGumaTest1() {
		AG.setPrecnik(15);
		AG.setVisina(30);
		AG.setSirina(140);
		boolean ocekivaniR = true;
		boolean stvarniR = AG.povoljnaGuma();
		assertEquals(ocekivaniR, stvarniR);
	
	}
	
	@Test
	public void toStringTest() {
		String ocekivaniR = "AutoGuma [markaModel=" + AG.getMarkaModel() + ", precnik=" + AG.getPrecnik() + ", sirina=" + AG.getSirina() + ", visina="+ AG.getVisina() + "]";
		String stvarniR = AG.toString();
		assertEquals(ocekivaniR, stvarniR);
	}
	
	@Test
	public void equalsTest1() {
		AutoGuma AG2 = new AutoGuma("Michelin", true, 18, 180, 40);
		assertTrue(AG.equals(AG2));
	}
	@Test
	public void equalsTest2() {
		VulkanizerskaRadnja VK = new VulkanizerskaRadnja();
		assertEquals(false, AG.equals(VK));
	}
	@Test
	public void equalsTest3() {
		AutoGuma AG2 = AG;
		assertTrue(AG.equals(AG2));
	}
	@Test
	public void equalsTest4() {
		AutoGuma AG2 = new AutoGuma(null, true, 18, 180, 40);
		assertFalse(AG.equals(AG2));
	}
	@Test
	public void equalsTest5() {
		AutoGuma AG2 = new AutoGuma(null, true, 18, 180, 40);
		AutoGuma AG3 = new AutoGuma(null, true, 18, 180, 40);
		assertTrue(AG2.equals(AG3));
	}
	@Test
	public void equalsTest6() {
		AutoGuma AG2 = new AutoGuma(null, true, 18, 180, 40);
		AutoGuma AG3 = new AutoGuma("Michelin", true, 18, 180, 40);
		assertFalse(AG2.equals(AG3));
	}
	@Test
	public void equalsTest7() {
		AutoGuma AG2 = new AutoGuma("Michelin", true, 19, 180, 40);
		assertFalse(AG.equals(AG2));
	}
	@Test
	public void equalsTest8() {
		AutoGuma AG2 = new AutoGuma("Michelin", true, 18, 185, 40);
		assertFalse(AG.equals(AG2));
	}
	@Test
	public void equalsTest9() {
		AutoGuma AG2 = new AutoGuma("Michelin", true, 18, 180, 35);
		assertFalse(AG.equals(AG2));
	}
	
}
