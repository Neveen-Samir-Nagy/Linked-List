package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

/**
 * . public
 *
 * @author EL-hamd
 *
 */
public class Term {
	/**.
	 * . coeff
	 */
	int coeff;
	/**
	 * . exp
	 */
	int exp;

	/**
	 * . term
	 *
	 * @param x
	 *            first
	 * @param y
	 *            second
	 */
	Term(final int x, final int y) {
		coeff = x;
		exp = y;
	}

	/**
	 * . get
	 *
	 * @return int
	 */
	public int getCoeff() {
		return coeff;
	}

	/**
	 * . void
	 *
	 * @param newcoeff
	 *            first
	 */
	public void setCoeff(final int newcoeff) {
		this.coeff = newcoeff;
	}

	/**
	 * . get
	 *
	 * @return int
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * . void
	 *
	 * @param newexp
	 *            first
	 */
	public void setExp(final int newexp) {
		this.exp = newexp;
	}
}
