package projecteuler.problem33;

public class DigitCancelFraction {

	/**
	 * Author: James Norcross
	 * Date: 1/8/15
	 * Purpose: Project Euler problem 33
	 * Description:  Finds 'non-trivial' digit canceling fractions
	 */
	public static void main(String[] args) {

		int num1, denom1, num2, denom2, numprod = 1, denomprod = 1;
		
		for (int d1 = 1; d1<10; d1++) 
		{
			for(int d2 = 1; d2<10; d2++) 
			{
				for(int n1 = 1; n1<=d1; n1++) 
				{
					for(int n2=1; n2<10; n2++)
					{
						num1 = n1*10 + n2;
						denom1 = d1*10 + d2;
						
						if(n1 == d1)
						{
							num2 = n2;
							denom2 = d2;
						}
						else if (n1 == d2)
						{
							num2 = n2;
							denom2 = d1;
						}
						else if (n2 == d1)
						{
							num2 = n1;
							denom2 = d2;
						}
						else if (n2 == d2)
						{
							num2 = n1;
							denom2 = d1;
						}
						else
						{
							num2 = 0;
							denom2 = 1;
						}
						
						if(((num1*denom2) == (num2*denom1)) && !(num1 == denom1))
						{
							System.out.println(num1 + " / " + denom1 + "   " + num2 + " / " + denom2);
							numprod *= num1;
							denomprod *= denom1;
						}
					}
				}
			}
		}
		
		System.out.println("The denominator of the product of non-trivial digit canceling fractions is " + denomprod/gcd(numprod,denomprod));
	}

	private static int gcd(int a, int b) 
	{
		while (b>0)
		{
			int c = a % b;
			a = b;
			b = c;
		}
		
		return a;
	}
}
