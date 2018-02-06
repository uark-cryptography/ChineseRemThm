class ChineseRemThm{
	
	void run(int a, int b, int c, int d){
		int[] cons = {a,c};
		int[] mods = {b,d};		
		solve(cons, mods);	
	}
	
	void run(int a, int b, int c, int d, int e, int f){
		int[] cons = {a,c,e};
		int[] mods = {b,d,f};		
		solve(cons, mods);		
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
			System.out.println("x equivalent to " + (sum%productMods+productMods) + " mod " + productMods); //sum is neg add pMod
		else
			System.out.println("x equivalent to " + sum%productMods + " mod " + productMods);
	}

	public static void main(String args[]){
		ChineseRemThm crt = new ChineseRemThm();
		
		crt.run(3,7,4,9);				//part a
		crt.run(137, 423, 87, 191);		//part b
		crt.run(133, 451, 237, 697);	//part c
		crt.run(5,9,6,10,7,11);			//part d
		crt.run(37,43,22,49,18,71);		//part e
	}
}