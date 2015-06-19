import java.util.ArrayList;


public class Playfair {

	
	private String key;
	private char[][] matrix = new char [5][5];
	private ArrayList<Integer>  alphabet = new ArrayList<Integer>();
	
	
	/**
	 * Initializes a new Playfair object with an normal uppercase alphabet
	 * @param key
	 */
	public Playfair(String key){
		this.key = key;
		buildAlphabet();
		this.buildMatrix();
	}
	
	
	/**
	 * Build our alphabet of upper case chars
	 */
	private void buildAlphabet(){
		int charNumber = 65;
		for(int i = 0; i<26;i++){
			this.alphabet.add(charNumber++);
		}
	}
	
	
	/**
	 * Build the matrix of the playfair-chiffre with the given keyword
	 */
	private void buildMatrix(){
		int index= 0 ;
		this.key = this.key.toUpperCase();
		this.key = removeDuplicates();
		this.removeUsedCharactersFromAlphabet();
		for(int i = 0; i<5;i++){
			for(int j = 0;j<5;j++){
				
				try{
					matrix[i][j]=(char) removeChar();
				}catch(NullPointerException e){
					int a = alphabet.get(index++);
					matrix[i][j] = (char) a;
				}
			}
		}
		printMatrix();
	}
	
	
	
	/**
	 * Encode the given text with the playfair chiffre
	 * @param text
	 * @return encoded String
	 */
	public String encode (String text){
		System.out.println(System.lineSeparator());
		System.out.println("____________Enccode_____________" + System.lineSeparator());
		text = this.prepareString(text);
		String[] bigrams = this.buildBigrams(text);	
		StringBuffer encodedBuffer = new StringBuffer();
		char a = 0;
		char b = 0;
		int rowA = 0;
		int columnA = 0;
		int rowB = 0 ;
		int columnB = 0;
		
		
		
		for(int i = 0 ; i<bigrams.length;i++){
			if(bigrams[i].length()==2){
				a = bigrams[i].charAt(0);
				b = bigrams[i].charAt(1);
				System.out.println(a+"+"+b);
			}
			
		
				for(int j = 0; j<5;j++){
					for(int k = 0; k<5;k++){
						if(a == matrix [j][k] ){
							rowA= j;
							columnA = k;
							System.out.println(a +" found at: Row'"+rowA+"' and Column'"+columnA+"'");
						}
						
						if(b == matrix [j][k]){
							rowB=j;
							columnB = k;
							System.out.println(b +" found at: Row'"+rowB+"' and Column'"+columnB+"'");	
						}						
					}
				}

			if(rowA == rowB){
				encodedBuffer.append(matrix[rowA][(columnA+1)%5]);
				encodedBuffer.append(matrix[rowB][(columnB+1)%5]);
			}
			
			if(columnA == columnB){
				encodedBuffer.append(matrix[(rowA+1)%5][columnA]);
				encodedBuffer.append(matrix[(rowB+1)%5][columnB]);
			}
			
			if(rowA!=rowB && columnA!=columnB){
				encodedBuffer.append(matrix[rowA][columnB]);
				encodedBuffer.append(matrix[rowB][columnA]);	
			}
				
			
		}
		return encodedBuffer.toString();	
	}
	
	
	
	
	
	
	/**
	 * decode the given cipher with the playfair chiffre
	 * @param text
	 * @return decoded String
	 */
	public String decode (String text){
		
		System.out.println(System.lineSeparator());
		System.out.println("____________Decode_____________"+System.lineSeparator());
		String[] bigrams = this.buildBigrams(text);
		StringBuffer decodedBuffer = new StringBuffer();
		
		char a = 0;
		char b = 0;
		int rowA = 0;
		int columnA = 0;
		int rowB = 0 ;
		int columnB = 0;
		
		
		
		for(int i = 0 ; i<bigrams.length;i++){
			if(bigrams[i].length()==2){
				a = bigrams[i].charAt(0);
				b = bigrams[i].charAt(1);
				System.out.println(a+"+"+b);
			}
			
		
				for(int j = 0; j<5;j++){
					for(int k = 0; k<5;k++){
						if(a == matrix [j][k] ){
							rowA= j;
							columnA = k;
							System.out.println(a +" found at: Row'"+rowA+"' and Column'"+columnA+"'");
						}
						
						if(b == matrix [j][k]){
							rowB=j;
							columnB = k;
							System.out.println(b +" found at: Row'"+rowB+"' and Column'"+columnB+"'");	
						}						
					}
				}

			if(rowA == rowB){
				
				if(columnA-1<0){
					columnA = columnA+5;
				}
				if(columnB-1<0){
					columnB = columnB+5;
				}
				
				decodedBuffer.append(matrix[rowA][(columnA-1)%5]);
				decodedBuffer.append(matrix[rowB][(columnB-1)%5]);
			}
			
			if(columnA == columnB){
				
				if(rowA-1<0){
					rowA = rowA+5;
				}
				if(rowB-1<0){
					rowB=rowB+5;
				}
				
				decodedBuffer.append(matrix[(rowA-1)%5][columnA]);
				decodedBuffer.append(matrix[(rowB-1)%5][columnB]);
			}
			
			if(rowA!=rowB && columnA!=columnB){
				decodedBuffer.append(matrix[rowA][columnB]);
				decodedBuffer.append(matrix[rowB][columnA]);	
			}
				
			
		}
		return decodedBuffer.toString();	
	}
	
	
	
	
	
	
	
	/**
	 * Remove all duplicates from the keyword
	 * @return a String
	 */
	private String removeDuplicates(){
		StringBuilder finalKey = new StringBuilder();
		for(int i = 0; i<this.key.length();i++){
			String subString = this.key.substring(i, i+1);
				if(finalKey.indexOf(subString)==-1){
					finalKey.append(subString);
				}
			}
		return finalKey.toString();
		}
	
	
	/**
	 * Get an char from the keyword and remove it
	 * @return a char
	 */
	private Object removeChar(){
		char returnChar;
		try{
			returnChar = this.key.charAt(0);
			this.key = this.key.substring(1, key.length());
		}catch(StringIndexOutOfBoundsException e){
			return null;
		}
		
		return returnChar;
	}
	
	

	/**
	 * Remove all characters of the keyword from the alphabet
	 */
	private void removeUsedCharactersFromAlphabet(){
		alphabet.remove(9); // remove 'J'
		for(int i = 0; i<this.key.length();i++){
			Integer remove = (int) this.key.charAt(i);
			alphabet.remove(remove);
		}
	}

	
	
	/**
	 * Delete all whitespaces and write the text to uppercase
	 * @param text
	 * @return a String where all whitespaces were deleted and all characters are in uppercase
	 */
	private String prepareString(String text){
		text = text.trim();
		text = text.toUpperCase(); 
		text = text.replaceAll("\\s+","");
		return text;
	}
	


	/**
	 * Build the bigrams of the text. First it checks if a bigram will has a duplicated character. 
	 * If yes it will insert an 'X' between them. (Rule of the playfair-chiffre)
	 * @param text to encode
	 * @return a String array consisting of the bigrams of the text
	 */
	private String[] buildBigrams(String text){
		System.out.println("Original text: " + text );
		int runtime = (text.length()/2);
		int index = 0;
		while(runtime>0){
			String checkString = text.substring(index, index+2);
			if(checkString.charAt(0)==checkString.charAt(1)){
				text = text.substring(0, index+1) + "X" +text.substring(index+1, text.length());
			}
			index = index+2;

			runtime--;
		}
		
		System.out.println("Prepared text: " + text);
		
		String bigrams[] = text.split("(?<=\\G.{2})");
		System.out.print("Bigrams: ");
		for(int h = 0 ; h<bigrams.length;h++){
			if(bigrams[h].length()<2){
				bigrams[h] = bigrams[h].charAt(0)+"X";
			}
			
			if(h==(bigrams.length-1)){
				System.out.println(bigrams[h]+" ");
			}else{
				System.out.print(bigrams[h]+" ");
			}
		}
		return  bigrams;
	}
	
	
	/**
	 * Prints the matrix on the screen
	 */
	private void printMatrix(){
		System.out.println("    0 1 2 3 4  ");
		System.out.println();
		for(int i = 0; i<5;i++){
			System.out.print(i+"   ");
			for(int j = 0;j<5;j++){
				System.out.print( matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("________________");
	}
	
	

	
	public static void main (String[] args){
		Playfair playfair = new Playfair(args[0]);
		String text = args[1];
		String encoded = playfair.encode(text);
		String decoded = playfair.decode(encoded);
		
		System.out.println(System.lineSeparator());
		System.out.println("____________Outputs_____________"+System.lineSeparator());
		System.out.println("Encoded text: " + encoded);
		System.out.println("Decoded text: " + decoded);
	}
}
