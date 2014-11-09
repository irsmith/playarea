package playground;

import org.junit.Assert;
import org.junit.Test;

public class CompressTest {

	@Test
	public void testsimple() {
		Assert.assertEquals("a", new Compress("a").getCompressed());
		Assert.assertEquals("a2", new Compress("aa").getCompressed());
		Assert.assertEquals("ab3cr4", new Compress("abbbcrrrr").getCompressed());

	}

	@Test
	public void test() {

		Assert.assertEquals("ab12cr4",
				new Compress("abbbbbbbbbbbbcrrrr").getCompressed());

		Assert.assertEquals("", new Compress("").getCompressed());
		Assert.assertEquals(null, new Compress(null).getCompressed());

	}

}
