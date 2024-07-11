package testovi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gume.AutoGuma;
import gume.VulkanizerskaRadnja;
@RunWith(Parameterized.class)
public class VulkanizerskaRadnjaTest2 {
	
	private AutoGuma AG;
	private VulkanizerskaRadnja VR;
	
	@Rule
	public final TestRule timeout = Timeout.seconds(5);
	
	@BeforeClass
	public static void ProveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	public VulkanizerskaRadnjaTest2(AutoGuma AG) {
		this.AG = AG;
	}
	
	@Parameters
	public static Collection<Object[]>gume(){
		return Arrays.asList(new Object [][] {
			{new AutoGuma("KURELI",true,18,180,40)},
			{new AutoGuma("KURELI",true,18,180,40)},
			{new AutoGuma("KURELI",true,18,180,40)},
			{new AutoGuma("PEEEEP",false,16,170,35)}
		});
	}
	
	@Before
	public void init() {
		VR = new VulkanizerskaRadnja();
	}

	@Test
	public void pronadjiGumuTest() {
		String marka = null;
		assertNull(VR.pronadjiGumu(marka));
	}
	
	@Test
	public void pronadjiGumuTest2() {
		assertFalse(VR.gume.contains(AG));
		VR.dodajGumu(AG);
		LinkedList<AutoGuma> gumes = new LinkedList<AutoGuma>();
		gumes.add(AG);
		assertNotEquals(gumes,VR.pronadjiGumu("MICHELLIN - NotExistingModel"));
	}
	
	@After
	public void destroy() {
		VR = null;
	}

}
