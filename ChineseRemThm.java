import java.math.BigInteger;

class ChineseRemThm{
	
	char problem ='A';
	
	void run(int a, int b, int c, int d){
		int[] gcd = {a,b,c,d};
		int[] cons = {a,c};
		int[] mods = {b,d};	
		
		if(isCoprime(gcd))	
			solve(cons, mods);	
		problem++;
	}
	
	void run(int a, int b, int c, int d, int e, int f){
		
		int[] gcd = {a,b,c,d,e,f};
		
		int[] cons = {a,c,e};
		int[] mods = {b,d,f};	

		if(isCoprime(gcd))	
			solve(cons, mods);

		problem++;
	}
	
	boolean isCoprime(int[] gcd){
		
		int a = 0;
		int b = 0;
		for(int i = 1; i < gcd.length; i+=2){			
			for(int j = 1; j < gcd.length; j+=2){				
				if(gcd(gcd[i],gcd[j]) == 1){
					
					return true;
				}
			}
		}
		System.out.println(problem + ". No solution - moduli are not coprime");
		return false;
	}
	
	
	//for multiplicative inverse
	int multiInverse(int a, int b){
				
		int s = 0;
		int output = 1;
		int r = b;
		int r_tmp = a;
				
		while(r!=0){
			int q = r_tmp/r;
			
			int swap = r;
			r = r_tmp-(q*r);
			r_tmp = swap;
			
			swap = s;
			s = output - (q*s);
			output = swap;				
		}			
		return output;
	}
	

	int gcd(int a, int b){
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd  = b1.gcd(b2);
		return gcd.intValue();
	}
		
	void solve(int[] cons, int[] mods){	
		
		int[] inverse = new int[mods.length];
		int productMods = 1;
		
		
		for(int i = 0; i < mods.length; i++){
			productMods *= mods[i];   //multiplying all modulus
		}
		
		int sum = 0;
		for(int i = 0; i < mods.length; i++){
			inverse[i] = multiInverse(productMods/mods[i],mods[i]);
			sum += (productMods/mods[i])*cons[i]*inverse[i];			
		}
				
		if (sum < 0)
			System.out.println(problem+". x equivalent to " + (sum%productMods+productMods) + " mod " + productMods); //sum is neg add pMod
		else
			System.out.println(problem+". x equivalent to " + sum%productMods + " mod " + productMods);
		
	}

	public static void main(String args[]){
		ChineseRemThm crt = new ChineseRemThm();
		
		crt.run(3,7,4,9);				//part a
		crt.run(137, 423, 87, 191);		//part b
		crt.run(133, 451, 237, 697);	//part c The modulus is not coprime to previous ones
		crt.run(5,9,6,10,7,11);			//part d
		crt.run(37,43,22,49,18,71);		//part e
	}
}