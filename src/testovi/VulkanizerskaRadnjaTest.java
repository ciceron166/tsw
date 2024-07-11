package testovi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.rules.TestRule;

import gume.AutoGuma;
import gume.VulkanizerskaRadnja;
@RunWith(Parameterized.class)
public class VulkanizerskaRadnjaTest {
	
	private AutoGuma AG;
	private VulkanizerskaRadnja VR;
	
	@BeforeClass
	public static void ProveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public final TestRule timeout = Timeout.seconds(5);
	
	public VulkanizerskaRadnjaTest(AutoGuma AG) {
		this.AG = AG;
	}
	
	@Parameters
	public static Collection<Object[]> gume(){
		return Arrays.asList(new Object[][] {
			{new AutoGuma("Michelin", true, 18, 180, 40)},
			{new AutoGuma("Michelin", true, 18, 180, 40)},
			{new AutoGuma("Michelin", true, 18, 180, 40)},
			{new AutoGuma("KURELI", false, 19, 170, 30)}
			
		});
	}
	
	@Before
	public void init() {
		VR = new VulkanizerskaRadnja();
	}
	
	@Test(expected = NullPointerException.class)
	public void dodajGumuTest() {
		AG = null;
		VR.dodajGumu(AG);
	}
	
	@Test(expected = RuntimeException.class)
	public void dodajGumuTest1() {
		VR.dodajGumu(AG);
		VR.dodajGumu(AG);
	}
	
	@Test
	public void dodajGumuTest3() {
		assertFalse(VR.gume.contains(AG));
		VR.dodajGumu(AG);
		assertTrue(VR.gume.contains(AG));
	}
	
	
	@After
	public void destroy() {
		VR = null;
	}

}
