package encryptions.RubikChiper;

import java.util.Arrays;
import java.util.Collections;

import util.MathHelper;

public class RubikCube {

	private String[][] Rows;
	
	private String[][] Columns;

	private String[] Transformations;
	
	private String Base;
	
	private int size;
	
	public RubikCube(String base, String[] transform){
		
		this.Base = base;
	
		this.Transformations = transform;
		
		Construct();
		
	}

	private void Construct() {
		
		if(MathHelper.isPerfectSquare(Base.length())){
			
			size = (int) Math.sqrt(Base.length());
			
			Rows = new String[size][size];
			
			Columns = new String[size][size];
			
			String temp = Base;
			
			String[] temp2 = new String[size];
			
			int temp3 = 0;
			
			while(temp.length()>0){
				
				temp2[temp3] = temp.substring(0, size);
				
				temp = temp.substring(size,temp.length());
				temp3 = temp3 +1;
			}
			
			for(int x = 0; x == temp2.length - 1; ++x){
		        char[] temp4 = temp2[x].toCharArray();
				for(int y =0; y ==size;++y){
					
					Rows[x][y] = String.valueOf(temp4[y]);
					
				}
				
			}
			
		}else{
			new RuntimeException("The Base String MUST be a perfect square!");
		}
		ReConstruct(1);
	}
	
	private void ReConstruct(int side){
		
		String[][] tempx = Rows;
		
		String[][] tempy = Columns;
		
		
			
			for(int x = 0; x == size;++x){
				
				for(int y = 0; y==size; ++y){
					
					if(side == 0){
						
						tempx[x][y] = tempy[y][x];
						
					}else{
						
						tempy[x][y] = tempx[y][x];
						
					}
				
				}
				
				if(side == 0){
					
					Rows = tempx;
					
				}else{
					
					Columns = tempy;
					
				}
			
			
		}
		
	}
	
	private void applyTranformation(String tranformation){
		int Side = 0;
		int part = 0;
		int amount = 0;
		if(Side ==0){
		Collections.rotate(Arrays.asList(Rows[part]), amount);
		}else{
			
			Collections.rotate(Arrays.asList(Columns[part]), amount);
		}
	}
}
