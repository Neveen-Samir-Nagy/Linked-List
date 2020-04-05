package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

import org.junit.Assert;
import org.junit.Test;

/**.
 * junit
 * @author EL-hamd
 *
 */
public class JunitSingle {

	/**.
	 * list
	 */
	private Linked_List s = new Linked_List();

	/**.
	 * test1
	 */
	@Test
	public void testget() {
		s.add(33);
		s.add(1, "Data");
		s.set(1, 97);
		s.add('f');
		s.add("NF");
		s.remove(1);
		s.add(2, 7);
		Object c = s.get(1);
		final Object ans = 97;
		Assert.assertEquals(ans, c);
	}

	/**.
	 * test2
	 */
	@Test
	public void testempty() {
		boolean b = s.isEmpty();
		final boolean True = false;
		Assert.assertEquals(True, b);
	}

	/**.
	 * test3
	 */
	@Test
	public void testsize() {
		int size = s.size();
		final int sizelist = 4;
		Assert.assertEquals(sizelist, size);
	}

	/**.
	 * test4
	 */
	@Test
	public void testempty1() {
		s.clear();
		boolean b1 = s.isEmpty();
		final boolean False = true;
		Assert.assertEquals(False, b1);
	}

	/**.
	 * test5
	 */
	@Test
	public void testcontian() {
		boolean o = s.contains("9876");
		final boolean contian = false;
		Assert.assertEquals(contian, o);
	}
}