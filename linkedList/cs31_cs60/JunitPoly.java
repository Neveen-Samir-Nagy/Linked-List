package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

import org.junit.Assert;
import org.junit.Test;

/**.
 * junit
 * @author EL-hamd
 *
 */
public class JunitPoly {

	/**.
	 * poly
	 */
	private Polynomial p = new Polynomial();

	/**.
	 * test1
	 */
	@Test
	public void testevaluate() {
		int[][] array = new int[][] { { 1, 2 }, { 0, 1 }, { 2, 3 }, { 4, 3 }, { 1, 5 } };
		p.setPolynomial('A', array);
		float value = p.evaluatePolynomial('A', 4);
		final float ans = 1424;
		Assert.assertEquals(ans, value);
	}

	/**.
	 * test2
	 */
	@Test
	public void testString() {
		String s = p.print('A');
		String str = "x^5+6x^3+x^2";
		Assert.assertEquals(str, s);
	}

	/**.
	 * test3
	 */
	@Test
	public void testadd() {
		int[][] arr = new int[][] { { 1, 0 }, { 1, 1 }, { 2, 2 }, { 4, 3 }, { 1, 4 } };
		p.setPolynomial('B', arr);
		int[][] add = p.add('A', 'B');
		int[][] testadd = new int[][] { { 1, 5 }, { 1, 4 }, { 10, 3 }, { 3, 2 }, { 1, 1 }, { 1, 0 } };
		Assert.assertArrayEquals(testadd, add);
	}

	/**.
	 * test4
	 */
	@Test
	public void testsubtract() {
		int[][] subtract = p.subtract('A', 'B');
		int[][] testsubtract = new int[][] { { 1, 5 }, { -1, 4 }, { 2, 3 }, { -1, 2 }, { -1, 1 }, { -1, 0 } };
		Assert.assertArrayEquals(testsubtract, subtract);
	}

}
