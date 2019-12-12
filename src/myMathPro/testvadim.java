package myMathPro;

public class testvadim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Functions_GUI m =  new Functions_GUI();	
			m.initFromFile("test.txt");
			m.drawFunctions(800, 600, new Range(-10, 10), new Range(-5, 15), 200);
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
