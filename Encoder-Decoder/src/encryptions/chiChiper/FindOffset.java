package encryptions.chiChiper;

import java.util.Random;

public class FindOffset {

	private int random = new Random().nextInt();
	/**
	 * 
	 * @return Offset and its "Seed"
	 */
	
	public void genSeed(){
		boolean gen = true;
		while(gen){
			
			
			random =  (random < 0) ? -random : random;
					
					
					String string = Integer.toString(random);

					int offset = 0;
					  for(int i = 0; i<string.length(); ++i){
					     
						  offset += Integer.parseInt(string.substring(i, i+1));
					  
					  }
					
					  
					  if(offset > 63){
						  
						  random = new Random().nextInt();  
						  
					  }else{
						  
						  gen = false;
					  }
						 
			
		}
		
	}
	public int[] getOffset(){
		
random =  (random < 0) ? -random : random;
		
		
		String string = Integer.toString(random);

		int offset = 0;
		  for(int i = 0; i<string.length(); ++i){
		     
			  offset += Integer.parseInt(string.substring(i, i+1));
		  
		  }
		
		  
		  
		int[] out = {offset,random};
		return out;
	}

	public int getOffset(int in){
		
		

		String string = Integer.toString(in);

		int offset = 0;
		  for(int i = 0; i<string.length(); ++i){
		     
			  offset += Integer.parseInt(string.substring(i, i+1));
		  
		  }
		
		  return offset;
	}
	
	
	public int getPasswordOffset(BasicChiper chiper,String in){
		int offset = 0;
		for(int i = 0; i<in.length(); ++i){

			offset = offset + chiper.getPostion(in.charAt(i));
			if(offset > 63){
			
				offset = offset - 63;
				
			}
		}
		
		return offset;	
	}
}
