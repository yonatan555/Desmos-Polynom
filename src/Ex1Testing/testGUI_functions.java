package Ex1Testing;

import myMathPro.Functions_GUI;
import myMathPro.Range;

public class testGUI_functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Functions_GUI m = new Functions_GUI();
			m.initFromFile("test123.txt");
			m.saveToFile("test1234.txt");
			m.drawFunctions(800, 600, new Range(-10, 10), new Range(-5, 15), 200); // regular check for draw function
			m.drawFunctions("GUI_params.txt");// check for json file draw
		} catch (Exception e) {
			System.out.println("couldnt read the functions/and save them to a file");
		}
	}
}
