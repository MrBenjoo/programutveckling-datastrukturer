

package p6;

	/**
	 * Klassen Character representerar en Array7x7 objekt
	 * för alla tecken A-Z(stora och små), 0-9, och andra
	 * tecken så som +,-,etc.
	 * Varje tecken deifinieras av en 7x7 array(49 element)
	 * @author ansambassamabdulhamid
	 * @author NamraGill
	 */
	public class Character{
		//deklaration och initiering av array med kapaciteten 128
		private static Array7x7[] chars  = new Array7x7[128]; 
		 
		/**
		 * Konstruktorn visar hur tecken och Array7x7-objekt 
		 * kopplas ihop 
		 * Varje tecken representeras av ett objekt 
		 * Alla tecken har skrivits med hänsyn till Ascii tabellen
		 */
		public Character() {
					chars[32] = new Array7x7(charSPACE);
					chars[40] = new Array7x7(charBrV); // (
					chars[41] = new Array7x7(charBrH); // )
					chars[42] = new Array7x7(charSTAR);
					chars[44] = new Array7x7(charCOMMA);
					chars[43] = new Array7x7(charADD);
					chars[45] = new Array7x7(charSUB);
					chars[46] = new Array7x7(charDOT);
					chars[47] = new Array7x7(charSLASH);
					chars[48] = new Array7x7(char0);
					chars[49] = new Array7x7(char1);
					chars[50] = new Array7x7(char2);
					chars[51] = new Array7x7(char3);
					chars[52] = new Array7x7(char4);
					chars[53] = new Array7x7(char5);
					chars[54] = new Array7x7(char6);
					chars[55] = new Array7x7(char7);
					chars[56] = new Array7x7(char8);
					chars[57] = new Array7x7(char9);
					chars[63] = new Array7x7(unknown);
					chars[65] = new Array7x7(charA);
					chars[66] = new Array7x7(charB);
					chars[67] = new Array7x7(charC);
					chars[68] = new Array7x7(charD);
					chars[69] = new Array7x7(charE);
					chars[70] = new Array7x7(charF);
					chars[71] = new Array7x7(charG);
					chars[72] = new Array7x7(charH);
					chars[73] = new Array7x7(charI);
					chars[74] = new Array7x7(charJ);
					chars[75] = new Array7x7(charK);
					chars[76] = new Array7x7(charL);
					chars[77] = new Array7x7(charM);
					chars[78] = new Array7x7(charN);
					chars[79] = new Array7x7(charO);
					chars[80] = new Array7x7(charP);
					chars[81] = new Array7x7(charQ);
					chars[82] = new Array7x7(charR);
					chars[83] = new Array7x7(charS);
					chars[84] = new Array7x7(charT);
					chars[85] = new Array7x7(charU);
					chars[86] = new Array7x7(charV);
					chars[87] = new Array7x7(charW);
					chars[88] = new Array7x7(charX);
					chars[89] = new Array7x7(charY);
					chars[90] = new Array7x7(charZ);
		}
		
		private static int [][] charSPACE ={ 
										   { 0, 0, 0, 0, 0, 0, 0},
										   { 0, 0, 0, 0, 0, 0, 0},
										   { 0, 0, 0, 0, 0, 0, 0},
										   { 0, 0, 0, 0, 0, 0, 0},
										   { 0, 0, 0, 0, 0, 0, 0},
										   { 0, 0, 0, 0, 0, 0, 0},
										   { 0, 0, 0, 0, 0, 0, 0} };
		
		private static int[][] charBrV = { 
										 { 0, 0, 0, 0, 1, 0, 0 }, 
										 { 0, 0, 0, 1, 0, 0, 0 }, 
										 { 0, 0, 1, 0, 0, 0, 0 },
										 { 0, 0, 1, 0, 0, 0, 0 }, 
										 { 0, 0, 1, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 1, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 1, 0, 0 } };

	private static int[][] charBrH = { 
									 { 0, 0, 1, 0, 0, 0, 0 }, 
									 { 0, 0, 0, 1, 0, 0, 0 }, 
									 { 0, 0, 0, 0, 1, 0, 0 },
									 { 0, 0, 0, 0, 1, 0, 0 }, 
									 { 0, 0, 0, 0, 1, 0, 0 }, 
									 { 0, 0, 0, 1, 0, 0, 0 }, 
									 { 0, 0, 1, 0, 0, 0, 0 } };
		
	private static int[][] charSTAR = { { 0, 0, 0, 0, 0, 0, 0 }, 
									    { 0, 1, 0, 1, 0, 1, 0 }, 
									    { 0, 0, 1, 1, 1, 0, 0 },
									    { 0, 1, 1, 1, 1, 1, 0 }, 
									    { 0, 0, 1, 1, 1, 0, 0 }, 
									    { 0, 1, 0, 1, 0, 1, 0 }, 
									    { 0, 0, 0, 0, 0, 0, 0 } };

	private static int[][] charCOMMA = { { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 1, 0, 0 },
										 { 0, 0, 0, 1, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 } };
		

	private static int[][] charADD = { { 0, 0, 0, 1, 0, 0, 0 }, 
									   { 0, 0, 0, 1, 0, 0, 0 }, 
									   { 0, 0, 0, 1, 0, 0, 0 },
									   { 1, 1, 1, 1, 1, 1, 1 }, 
									   { 0, 0, 0, 1, 0, 0, 0 }, 
									   { 0, 0, 0, 1, 0, 0, 0 },
									   { 0, 0, 0, 1, 0, 0, 0 } };

		private static int [][] charSUB ={ 
										 { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 },
										 { 1, 1, 1, 1, 1, 1, 1 },
										 { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 } };

	    private static int[][] charDOT = { { 0, 0, 0, 0, 0, 0, 0 }, 
	    								   { 0, 0, 0, 0, 0, 0, 0 }, 
	    								   { 0, 0, 0, 0, 0, 0, 0 },
	    								   { 0, 0, 0, 1, 0, 0, 0 }, 
	    								   { 0, 0, 0, 0, 0, 0, 0 }, 
	    								   { 0, 0, 0, 0, 0, 0, 0 }, 
	    								   { 0, 0, 0, 0, 0, 0, 0 } };

	    private static int[][] charSLASH = { 
	    								   { 0, 0, 0, 0, 0, 1, 0 }, 
	    								   { 0, 0, 0, 0, 1, 0, 0 },
	    								   { 0, 0, 0, 1, 0, 0, 0 },
	    								   { 0, 0, 1, 0, 0, 0, 0 }, 
	    								   { 0, 1, 0, 0, 0, 0, 0 }, 
	    								   { 1, 0, 0, 0, 0, 0, 0 }, 
	    								   { 0, 0, 0, 0, 0, 0, 0 } };

	    private static int[][] char0 = { { 0, 0, 0, 1, 0, 0, 0 }, 
	    								 { 0, 0, 1, 0, 1, 0, 0 }, 
	    								 { 0, 1, 0, 0, 0, 1, 0 },
	    								 { 0, 1, 0, 0, 0, 1, 0 }, 
	    								 { 0, 1, 0, 0, 0, 1, 0 }, 
	    								 { 0, 1, 0, 0, 0, 1, 0 }, 
	    								 { 0, 0, 1, 1, 1, 0, 0 } };

	    private static int[][] char1 = { { 0, 0, 0, 1, 0, 0, 0 }, 
	    								 { 0, 0, 1, 1, 0, 0, 0 }, 
	    								 { 0, 1, 0, 1, 0, 0, 0 },
	    								 { 0, 0, 0, 1, 0, 0, 0 }, 
	    								 { 0, 0, 0, 1, 0, 0, 0 }, 
	    								 { 0, 0, 0, 1, 0, 0, 0 },
	    								 { 0, 1, 1, 1, 1, 0, 0 } };

	     private static int[][] char2 = { { 0, 0, 0, 1, 0, 0, 0 }, 
	    		 						  { 0, 0, 1, 0, 1, 0, 0 },
	    		 						  { 0, 0, 0, 0, 1, 0, 0 },
	    		 						  { 0, 0, 0, 1, 0, 0, 0 }, 
	    		 						  { 0, 0, 1, 0, 0, 0, 0 }, 
	    		 						  { 0, 1, 0, 0, 0, 0, 0 }, 
	    		 						  { 0, 1, 1, 1, 1, 0, 0 } };

	     private static int[][] char3 = { { 0, 1, 1, 1, 0, 0, 0 }, 
	    		 						  { 0, 0, 0, 0, 1, 0, 0 },
	    		 						  { 0, 0, 0, 0, 1, 0, 0 },
	    		 						  { 0, 1, 1, 1, 1, 0, 0 }, 
	    		 						  { 0, 0, 0, 1, 1, 0, 0 }, 
	    		 						  { 0, 0, 0, 0, 1, 0, 0 },
	    		 						  { 0, 1, 1, 1, 0, 0, 0 } };

	     private static int[][] char4 = { { 0, 1, 0, 1, 0, 0, 0 }, 
	    		 						  { 0, 1, 0, 1, 0, 0, 0 }, 
	    		 						  { 0, 1, 0, 1, 0, 0, 0 },
	    		 						  { 0, 1, 1, 1, 0, 0, 0 }, 
	    		 						  { 0, 0, 0, 1, 0, 0, 0 }, 
	    		 						  { 0, 0, 0, 1, 0, 0, 0 },
	    		 						  { 0, 0, 0, 1, 0, 0, 0 } };

	     private static int[][] char5 = { { 0, 1, 1, 1, 1, 0, 0 }, 
									 	  { 0, 1, 0, 0, 0, 0, 0 }, 
									 	  { 0, 1, 0, 0, 0, 0, 0 },
									 	  { 0, 1, 1, 1, 1, 0, 0 }, 
									 	  { 0, 0, 0, 0, 1, 0, 0 }, 
									 	  { 0, 0, 0, 0, 1, 0, 0 }, 
									 	  { 0, 1, 1, 1, 1, 0, 0 } };

	     private static int[][] char6 = { { 0, 0, 0, 0, 1, 0, 0 }, 
	    		 						  { 0, 0, 0, 1, 0, 0, 0 }, 
	    		 						  { 0, 0, 1, 0, 0, 0, 0 },
			                              { 0, 0, 1, 1, 1, 1, 0 }, 
			                              { 0, 0, 1, 0, 0, 1, 0 },
			                              { 0, 0, 1, 0, 0, 1, 0 }, 
			                              { 0, 0, 0, 1, 1, 0, 0 } };

	    private static int[][] char7 = { { 0, 0, 1, 1, 1, 0, 0 }, 
	    								 { 0, 0, 0, 0, 1, 0, 0 }, 
	    								 { 0, 0, 0, 0, 1, 0, 0 },
	    								 { 0, 0, 0, 1, 1, 1, 0 }, 
	    								 { 0, 0, 0, 0, 1, 0, 0 }, 
	    								 { 0, 0, 0, 0, 1, 0, 0 }, 
	    								 { 0, 0, 0, 0, 1, 0, 0 } };

	   private static int[][] char8 = { { 0, 1, 1, 1, 1, 0, 0 }, 
			   							{ 0, 1, 0, 0, 1, 0, 0 }, 
			   							{ 0, 1, 0, 0, 1, 0, 0 },
			   							{ 0, 1, 1, 1, 1, 0, 0 }, 
			   							{ 0, 1, 0, 0, 1, 0, 0 }, 
			   							{ 0, 1, 0, 0, 1, 0, 0 }, 
			   							{ 0, 1, 1, 1, 1, 0, 0 } };

	   private static int[][] char9 = { { 0, 0, 1, 1, 1, 0, 0 }, 
			   							{ 0, 1, 0, 0, 1, 0, 0 }, 
			   							{ 0, 1, 0, 0, 1, 0, 0 },
			   							{ 0, 0, 1, 1, 1, 0, 0 }, 
			   							{ 0, 0, 0, 0, 1, 0, 0 }, 
			   							{ 0, 0, 0, 0, 1, 0, 0 }, 
			   							{ 0, 0, 0, 0, 1, 0, 0 } };
		
		private static int[][] unknown = {	 
										 { 0, 0, 1, 1, 0, 0, 0 }, 
										 { 0, 1, 0, 0, 1, 0, 0 }, 
										 { 0, 0, 0, 1, 0, 0, 0 },
										 { 0, 0, 0, 1, 0, 0, 0 }, 
										 { 0, 0, 0, 1, 0, 0, 0 }, 
										 { 0, 0, 0, 0, 0, 0, 0 }, 
										 { 0, 0, 0, 1, 0, 0, 0 } };
		
		private static int[][] charA =   { 
										 { 0, 0, 0, 1, 0, 0, 0 }, 
										 { 0, 0, 1, 0, 1, 0, 0 }, 
					          			 { 0, 0, 1, 0, 1, 0, 0 },
					          			 { 0, 0, 1, 1, 1, 0, 0 }, 
					          			 { 0, 0, 1, 0, 1, 0, 0 }, 
					          			 { 0, 0, 1, 0, 1, 0, 0 }, 
					          			 { 0, 0, 1, 0, 1, 0, 0 } };
			
		 private static int[][] charB =  { 
				 						 { 0, 0, 1, 1, 0, 0, 0 }, 
					          			 { 0, 0, 1, 0, 1, 0, 0 }, 
					          			 { 0, 0, 1, 0, 1, 0, 0 },
					          			 { 0, 0, 1, 1, 0, 0, 0 }, 
					          			 { 0, 0, 1, 0, 1, 0, 0 }, 
					          			 { 0, 0, 1, 0, 1, 0, 0 }, 
					          			 { 0, 0, 1, 1, 1, 0, 0 } };
			
		 private static int[][] charC = { 
				 						{ 0, 0, 0, 1, 1, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 },
					          			{ 0, 0, 1, 0, 0, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 }, 
		                      			{ 0, 0, 0, 1, 1, 0, 0 } };
			
	    private static int[][] charD =  { 
	    								{ 0, 0, 1, 1, 0, 0, 0 }, 
					          			{ 0, 0, 1, 0, 1, 0, 0 }, 
					          			{ 0, 0, 1, 0, 1, 0, 0 },
					          		    { 0, 0, 1, 0, 1, 0, 0 }, 
					          			{ 0, 0, 1, 0, 1, 0, 0 }, 
					          			{ 0, 0, 1, 0, 1, 0, 0 }, 
					          			{ 0, 0, 1, 1, 0, 0, 0 } };
			
		private static int[][] charE =  { 
									    { 0, 0, 1, 1, 1, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 },
					          			{ 0, 0, 1, 1, 1, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 }, 
					          			{ 0, 0, 1, 1, 1, 0, 0 } };
			
		private static int[][] charF =  { 
									    { 0, 0, 1, 1, 1, 0, 0 }, 
					          		    { 0, 0, 1, 0, 0, 0, 0 }, 
					          		    { 0, 0, 1, 1, 1, 0, 0 },
					          		    { 0, 0, 1, 0, 0, 0, 0 }, 
					          		    { 0, 0, 1, 0, 0, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 }, 
					          			{ 0, 0, 1, 0, 0, 0, 0 } };
			
		private static int[][] charG = { 
									   { 0, 0, 0, 1, 1, 0, 0 }, 
					          		   { 0, 0, 1, 0, 0, 0, 0 }, 
					          		   { 0, 1, 0, 0, 0, 0, 0 },
					          		   { 0, 1, 0, 0, 0, 0, 0 }, 
					          		   { 0, 1, 0, 1, 1, 0, 0 }, 
					          		   { 0, 1, 0, 0, 1, 0, 0 }, 
					          		   { 0, 0, 1, 1, 1, 0, 0 } };
			
		private static int[][] charH = {     { 0, 0, 1, 0, 1, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 },
					          				 { 0, 0, 1, 1, 1, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 } };
				
		private static int[][] charI = {     { 0, 0, 1, 1, 1, 0, 0 }, 
					          				 { 0, 0, 0, 1, 0, 0, 0 }, 
					          				 { 0, 0, 0, 1, 0, 0, 0 },
					          				 { 0, 0, 0, 1, 0, 0, 0 }, 
					          				 { 0, 0, 0, 1, 0, 0, 0 }, 
					          				 { 0, 0, 0, 1, 0, 0, 0 }, 
					          				 { 0, 0, 1, 1, 1, 0, 0 } };
			
		private static int[][] charJ = {    { 0, 0, 1, 1, 1, 0, 0 }, 
											{ 0, 0, 0, 0, 1, 0, 0 }, 
											{ 0, 0, 0, 0, 1, 0, 0 },
											{ 0, 0, 0, 0, 1, 0, 0 }, 
											{ 0, 0, 0, 0, 1, 0, 0 }, 
											{ 0, 0, 1, 0, 1, 0, 0 }, 
											{ 0, 0, 1, 1, 1, 0, 0 } };
			
		private static int[][] charK = {     { 0, 0, 1, 0, 1, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 }, 
					          				 { 0, 0, 1, 1, 0, 0, 0 },
					          				 { 0, 0, 1, 1, 0, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 }, 
					          				 { 0, 0, 1, 0, 1, 0, 0 } };
				
		private static int[][] charL = {     { 0, 0, 1, 0, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 },
											 { 0, 0, 1, 0, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 }, 
											 { 0, 0, 1, 1, 1, 0, 0 } };
			
		private static int[][] charM = {     { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 1, 1, 0, 1, 1, 0 }, 
											 { 0, 1, 0, 1, 0, 1, 0 },
											 { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 1, 0, 0, 0, 1, 0 } };
			
		private static int[][] charN = {     { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 1, 1, 0, 0, 1, 0 }, 
											 { 0, 1, 0, 1, 0, 1, 0 },
											 { 0, 1, 0, 0, 1, 1, 0 }, 
											 { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 1, 0, 0, 0, 1, 0 }, 
					          				 { 0, 1, 0, 0, 0, 1, 0 } };
			
		private static int[][] charO = {     { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 1, 0, 0, 0, 1, 0 },
											 { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 } };
			
		 private static int[][] charP = {    { 0, 0, 1, 1, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 },
											 { 0, 0, 1, 1, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 } };
			
		private static int[][] charQ = {     { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 },
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 1, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 1, 0 } };
			
		private static int[][] charR = {     { 0, 0, 1, 1, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 },
											 { 0, 0, 1, 1, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 } };
			
		 private static int[][] charS = {    { 0, 0, 1, 1, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 0, 0, 0 },
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 1, 1, 0, 0 } };
			
		private static int[][] charT = {     { 0, 0, 1, 1, 1, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 },
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 } };
			
		private static int[][] charU = {     { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 },
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 } };
			
		private static int[][] charV = {     { 0, 0, 0, 0, 0, 0, 0 }, 
					  		  				 { 0, 1, 0, 0, 0, 1, 0 }, 
					  		  				 { 0, 0, 1, 0, 1, 0, 0 },
					  		  				 { 0, 0, 1, 0, 1, 0, 0 }, 
					  		  				 { 0, 0, 0, 1, 0, 0, 0 }, 
					  		  				 { 0, 0, 0, 0, 0, 0, 0 }, 
					  		  				 { 0, 0, 0, 0, 0, 0, 0 } };
			
		private static int[][] charW= {     { 0, 1, 0, 0, 0, 1, 0 }, 
											{ 0, 1, 0, 0, 0, 1, 0 }, 
											{ 0, 1, 0, 0, 0, 1, 0 },
											{ 0, 1, 0, 0, 0, 1, 0 }, 
											{ 0, 1, 0, 1, 0, 1, 0 }, 
											{ 0, 1, 0, 1, 0, 1, 0 }, 
											{ 0, 0, 1, 0, 1, 0, 0 } };
			
		private static int[][] charX = {     { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 },
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 1, 0, 0, 0, 1, 0 } };
			
		private static int[][] charY = {     { 0, 1, 0, 0, 0, 1, 0 }, 
											 { 0, 0, 1, 0, 1, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 },
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 } };
			
		private static int[][] charZ = {     { 0, 1, 1, 1, 1, 0, 0 }, 
											 { 0, 0, 0, 0, 1, 0, 0 }, 
											 { 0, 0, 0, 1, 0, 0, 0 },
								          	 { 0, 0, 1, 0, 0, 0, 0 }, 
								          	 { 0, 1, 0, 0, 0, 0, 0 }, 
								          	 { 0, 1, 0, 0, 0, 0, 0 }, 
								          	 { 0, 1, 1, 0, 1, 0, 0 } };
			
		/**
		 * Metoden getChar returnerar referens 
		 * till korrekt Array7x7-objekt avseende 
		 * parametern av typen char
		 * 
		 * @param chr  tecken av typen char
		 * @return     referens till rätt objekt
		 */
		public Array7x7 getChar(char chr){
			if((chr>=40 && chr <=57) && (chr>=65 && chr<=90)) { //alla ovanskrivna tecken inom dessa intervall
				return chars[chr]; 
			}
			else if( chr >=97 && chr <=122) {
				return chars[chr-32];  //inmatning av småbokstäver ger samma bokstäver dock som storabokstäver
			}
			else if(chr >=33 && chr <=39) { //tecknen mellan position 33,och 39 
											// i ascii tabellen används inte, har inte initierats
					return chars[63];  // därför returneras "okänt tecken" (unknown) när de väljs
			}
			else if( chr >=58 && chr<=64) {
				return chars[63];
			}
			else if( chr >=91 && chr<=96) {
					return chars[63];
			}
			else {
				   return chars[63];
		}
			}
	 }
			
			

		
	
	
	
	
	
	
			          
	
	
			         
	
	
	
	
			         
			
	
	

