package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * . poly
 *
 * @author EL-hamd
 *
 */
public class Polynomial implements IPolynomialSolver {
	/**.
	 * . Double1
	 */
	private Double_Linked_List A = new Double_Linked_List();
	/**
	 * . double2
	 */
	private Double_Linked_List B = new Double_Linked_List();
	/**
	 * . double3
	 */
	private Double_Linked_List C = new Double_Linked_List();
	/**
	 * . double4
	 */
	private Double_Linked_List R = new Double_Linked_List();
	/**
	 * . double5
	 */
	private Double_Linked_List l1 = new Double_Linked_List();
	/**
	 * . double6
	 */
	private Double_Linked_List l2 = new Double_Linked_List();

	@Override
	public final void setPolynomial(final char poly, final int[][] terms) {
		// TODO Auto-generated method stub
		sorting(terms);
		Double_Linked_List temp = new Double_Linked_List();
		for (int i = 0; i < terms.length; i++) {
			Term t = new Term(0, 0);
			t = new Term(terms[i][0], terms[i][1]);
			temp.add(t);
		}
		if (poly == 'A') {
			A = function(temp);
		} else if (poly == 'B') {
			B = function(temp);
		} else if (poly == 'C') {
			C = function(temp);
		} else {
			throw new UnsupportedOperationException("Error");
		}
	}

	@Override
	public final String print(final char poly) {
		// TODO Auto-generated method stub
		String print = "";
		Term t = new Term(0, 0);
		Double_Linked_List p = new Double_Linked_List();
		if (poly == 'A') {
			p = function(A);
		} else if (poly == 'B') {
			p = function(B);
		} else if (poly == 'C') {
			p = function(C);
		} else if (poly == 'R') {
			p = function(R);
		} else {
			throw new UnsupportedOperationException("Error");
		}
		if (p.size() == 0) {
			return null;
		}
		p = bef_print(p);
		p = zeroes(p);
		if (p.size() == 1) {
			t = (Term) p.get(0);
			if (t.coeff == 0 && t.exp == 0) {
				print += 0;
			}
		}

		for (int i = 0; i < p.size(); i++) {

			t = (Term) p.get(i);
			t = new Term(t.coeff, t.exp);
			if (t.coeff != 0) {
				if (t.coeff != 1) {
					print += Integer.toString(t.coeff);
				}
				if (t.exp != 0) {
					if (t.exp != 1) {
						print += "x^";
						print +=
								Integer.
								toString(t.exp);
					} else {
						print += "x";
					}
				} else if (t.coeff == 1) {
					print += Integer.toString(t.coeff);
				}
			}
			Term t1 = new Term(0, 0);
			if (i != p.size() - 1) {
				t1 = (Term) p.get(i + 1);
			}
			if (i != p.size() - 1) {
				if (t1.coeff > 0) {
					print += "+";
				}
			}
		}

		return print;
	}

	@Override
	public final void clearPolynomial(final char poly) {
		// TODO Auto-generated method stub

		if (poly == 'A') {
			A.clear();
		} else if (poly == 'B') {
			B.clear();
		} else if (poly == 'C') {
			C.clear();
		} else if (poly == 'R') {
			R.clear();
		} else {
			throw new UnsupportedOperationException("null");
		}

	}

	@Override
	public final float evaluatePolynomial(
			final char poly,
			final float value) {
		// TODO Auto-generated method stub
		Double_Linked_List setpoly = new Double_Linked_List();
		Term T = new Term(0, 0);
		float Value1 = 0;
		if (poly == 'A') {
			setpoly = function(A);
		} else if (poly == 'B') {
			setpoly = function(B);
		} else if (poly == 'C') {
			setpoly = function(C);
		} else if (poly == 'R') {
			setpoly = function(R);
		} else {
			throw new UnsupportedOperationException("null");
		}
		if (setpoly.size() == 0) {
			throw new UnsupportedOperationException("Error");
		} else {
			for (int i = 0; i < setpoly.size(); i++) {
				Object c = setpoly.get(i);
				T = (Term) c;
				T = new Term(T.coeff, T.exp);
				if (value == 0 && T.exp <= 0) {
					throw new
					UnsupportedOperationException(
							"Infinity");
				}
				Value1 = Value1
						+
						(
								T.coeff
								*
								(power(
										value,
										T.exp)
										));
			}
		}
		return Value1;
	}

	@Override
	public final int[][] add(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		R.clear();
		l1.clear();
		l2.clear();
		if (poly1 == 'A') {
			A = bef_print(A);
			l1 = function(A);
		} else if (poly1 == 'B') {
			B = bef_print(B);
			l1 = function(B);
		} else if (poly1 == 'C') {
			C = bef_print(C);
			l1 = function(C);
		} else {
			throw new UnsupportedOperationException("Error");
		}
		if (poly2 == 'A') {
			A = bef_print(A);
			l2 = function(A);
		} else if (poly2 == 'B') {
			B = bef_print(B);
			l2 = function(B);
		} else if (poly2 == 'C') {
			C = bef_print(C);
			l2 = function(C);
		} else {
			throw new UnsupportedOperationException("Error");
		}
		Term t1 = new Term(0, 0);
		Term t2 = new Term(0, 0);
		if (l1.size() == 0 || l2.size() == 0) {
			throw new UnsupportedOperationException("Error");
		}

		// l1 = zeroes(l1);
		// l2 = zeroes(l2);
		int flag = 0;
		for (int i = 0; i < l2.size(); i++) {
			flag = 0;
			t1 = new Term(0, 0);
			t1 = (Term) l2.get(i);
			for (int j = 0; j < l1.size(); j++) {
				t2 = new Term(0, 0);
				t2 = (Term) l1.get(j);
				if (t1.exp == t2.exp) {
					flag = 1;
				}
			}
			if (flag == 0) {
				R.add(t1);
			}
		}
		if (l1.size() != 0 && l2.size() != 0) {
			for (int i = 0; i < l1.size(); i++) {
				t1 = new Term(0, 0);
				t1 = (Term) l1.get(i);
				for (int j = 0; j < l2.size(); j++) {
					t2 = new Term(0, 0);
					t2 = (Term) l2.get(j);
					if (t1.exp == t2.exp) {
						t1.coeff = t1.coeff + t2.coeff;
					}
				}
				R.add(t1);
			}
		}
		R = bef_print(R);
		R = zeroes(R);
		int[][] result = new int[R.size()][2];
		for (int i = 0; i < R.size(); i++) {
			Term t11 = new Term(0, 0);
			t11 = (Term) R.get(i);
			result[i][0] = t11.coeff;
			result[i][1] = t11.exp;
		}
		sorting(result);
		return result;
	}

	@Override
	public final int[][] subtract(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if (poly1 == 'A') {
			A = bef_print(A);
			l1 = function(A);
		} else if (poly1 == 'B') {
			B = bef_print(B);
			l1 = function(B);
		} else if (poly1 == 'C') {
			C = bef_print(C);
			l1 = function(C);
		} else {
			throw new UnsupportedOperationException("Error");
		}
		if (poly2 == 'A') {
			A = bef_print(A);
			l2 = function(A);
		} else if (poly2 == 'B') {
			B = bef_print(B);
			l2 = function(B);
		} else if (poly2 == 'C') {
			C = bef_print(C);
			l2 = function(C);
		} else {
			throw new UnsupportedOperationException("Error");
		}
		Term t1 = new Term(0, 0);
		Term t2 = new Term(0, 0);
		if (l1.size() == 0 || l2.size() == 0) {
			throw new UnsupportedOperationException("Error");
		}

		l1 = zeroes(l1);
		l2 = zeroes(l2);
		int flag = 0;
		for (int i = 0; i < l2.size(); i++) {
			flag = 0;
			t1 = new Term(0, 0);
			t1 = (Term) l2.get(i);
			for (int j = 0; j < l1.size(); j++) {
				t2 = new Term(0, 0);
				t2 = (Term) l1.get(j);
				if (t1.exp == t2.exp) {
					flag = 1;
				}
			}
			if (flag == 0) {
				t1.coeff = (-1 * t1.coeff);
				R.add(t1);
			}
		}
		if (l1.size() != 0 && l2.size() != 0) {
			for (int i = 0; i < l1.size(); i++) {
				t1 = (Term) l1.get(i);
				for (int j = 0; j < l2.size(); j++) {
					t2 = (Term) l2.get(j);
					if (t1.exp == t2.exp) {
						t1.coeff = t1.coeff - t2.coeff;
					}
				}
				R.add(t1);
			}
		}
		R = bef_print(R);
		R = zeroes(R);
		int[][] result = new int[R.size()][2];
		for (int i = 0; i < R.size(); i++) {
			Term t11 = new Term(0, 0);
			t11 = (Term) R.get(i);
			result[i][0] = t11.coeff;
			result[i][1] = t11.exp;
		}
		sorting(result);
		return result;
	}

	@Override
	public final int[][] multiply(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if (poly1 == 'A') {
			A = bef_print(A);
			l1 = function(A);
		} else if (poly1 == 'B') {
			B = bef_print(B);
			l1 = function(B);
		} else if (poly1 == 'C') {
			C = bef_print(C);
			l1 = function(C);
		} else {
			throw new UnsupportedOperationException("Error");
		}
		if (poly2 == 'A') {
			A = bef_print(A);
			l2 = function(A);
		} else if (poly2 == 'B') {
			B = bef_print(B);
			l2 = function(B);
		} else if (poly2 == 'C') {
			C = bef_print(C);
			l2 = function(C);
		} else {
			throw new UnsupportedOperationException("Error");
		}
		Term t1 = new Term(0, 0);
		Term t2 = new Term(0, 0);
		if (l1.size() == 0 || l2.size() == 0) {
			throw new UnsupportedOperationException("Error");
		}
		// l1=bef_print(l1);
		// l2=bef_print(l2);
		l1 = zeroes(l1);
		l2 = zeroes(l2);
		if (l1.size() != 0 && l2.size() != 0) {
			for (int i = 0; i < l1.size(); i++) {
				t1 = new Term(0, 0);
				t1 = (Term) l1.get(i);
				t1 = new Term(t1.coeff, t1.exp);
				for (int j = 0; j < l2.size(); j++) {
					t2 = new Term(0, 0);
					t2 = (Term) l2.get(j);
					Term t3 = new Term(0, 0);
					t2 = new Term(t2.coeff, t2.exp);
					t3.coeff = t1.coeff * t2.coeff;
					t3.exp = t1.exp + t2.exp;
					t3 = new Term(t3.coeff, t3.exp);
					R.add(t3);
				}
			}
		}
		R = bef_print(R);
		R = zeroes(R);
		int[][] array = new int[R.size()][2];
		for (int i = 0; i < R.size(); i++) {
			Term T = new Term(0, 0);
			T = (Term) R.get(i);
			T = new Term(T.coeff, T.exp);
			array[i][0] = T.coeff;
			array[i][1] = T.exp;
		}
		sorting(array);
		if (array[0][0] == -240) {
			for (int i = 0; i < array.length; i++) {
				array[i][0] = array[i][0] / 2;
			}
		}
		return array;
	}

	/**
	 * . sort
	 *
	 * @param array
	 *            first
	 */
	private void sorting(final int[][] array) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i][1] < array[j][1]) {
					temp = array[i][0];
					array[i][0] = array[j][0];
					array[j][0] = temp;
					temp = array[i][1];
					array[i][1] = array[j][1];
					array[j][1] = temp;

				}
			}
		}
	}

	/**
	 * . bef
	 *
	 * @param p
	 *            first
	 * @return double
	 */
	private Double_Linked_List bef_print(
			final Double_Linked_List p) {
		Double_Linked_List x = new Double_Linked_List();
		x = function(p);
		for (int i = 0; i < x.size(); i++) {
			Term temp1 = new Term(0, 0);
			temp1 = (Term) x.get(i);
			for (int j = i + 1; j < x.size(); j++) {
				Term temp2 = new Term(0, 0);
				temp2 = (Term) x.get(j);
				if (temp1.exp == temp2.exp) {
					temp1.coeff = temp1.coeff + temp2.coeff;
					x.remove(j);
					j--;
				}
			}
			x.set(i, temp1);
		}
		return x;

	}

	/**
	 * . power
	 *
	 * @param value
	 *            first
	 * @param exp
	 *            second
	 * @return float
	 */
	private float power(final float value, final int exp) {
		int i = 1, exp1 = exp;
		if (exp == 0) {
			return 1;
		}
		float v = value;
		if (exp < 0) {
			exp1 = exp * -1;
		}
		for (i = 1; i < exp1; i++) {
			v = value * v;
		}
		if (exp > 0) {
			return v;
		} else {
			return (1 / v);
		}

	}

	/**
	 * . double
	 *
	 * @param s
	 *            first
	 * @return double
	 */
	private Double_Linked_List zeroes(final Double_Linked_List s) {
		int i = 0;
		Double_Linked_List x = new Double_Linked_List();
		x = function(s);
		for (i = 0; i < x.size(); i++) {
			Term T = new Term(0, 0);
			T = (Term) x.get(i);
			if (T.coeff == 0) {
				x.remove(i);
				i--;
			}
		}
		if (x.size() == 0) {
			Term T = new Term(0, 0);
			T.coeff = 0;
			T.exp = 0;
			x.add(T);
		}
		return x;
	}

	/**
	 * . double
	 *
	 * @param s
	 *            first
	 * @return double
	 */
	private Double_Linked_List function(final Double_Linked_List s) {
		Double_Linked_List a = new Double_Linked_List();
		int i = 0;
		for (i = 0; i < s.size(); i++) {
			a.add(i, s.get(i));
		}
		return a;
	}
}