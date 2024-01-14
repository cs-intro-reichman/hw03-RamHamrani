public class LoanCalc {
	
	static double epsilon = 0.001;
	static int iterationCounter;
	
	public static void main(String[] args) {		
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		iterationCounter = 0;  // Resetting the iteration counter to 0
		
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Side effect: modifies the class variable iterationCounter.
	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
		double payment = loan/n;
		while(endBalance(loan, rate, n, payment) > 0){
			payment+= epsilon;
			iterationCounter++;
		}
		return payment;
	}
    
	// Side effect: modifies the class variable iterationCounter.
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		double L = loan / n;
		double H = loan * (1 + rate / 100); // #feedback - H should be just the loan. The rate is calculated in endBalance.
		double payment = (L + H) / 2;
		
		while (Math.abs(H - L) > epsilon) { // #feedback - Math.abs is not needed here since H should always be larger than L.
			double midBalance = endBalance(loan, rate, n, payment);
			
			if (midBalance > 0) {
				L = payment;
			} else {
				H = payment;
			}
			
			payment = (L + H) / 2;
			iterationCounter++;
		}
		return payment;
	}

	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) {
		for(int i = 0; i < n; i++ ){
			loan-= payment;
			loan *= (1+rate/100);
		}
		return loan; 
	}	
}
