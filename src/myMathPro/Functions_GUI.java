package myMathPro;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import com.google.gson.Gson;

public class Functions_GUI implements functions {
	ArrayList<function> tab;

	public Functions_GUI() {
		this.tab = new ArrayList<function>();
	}

	@Override
	public boolean add(function func) {
		return this.tab.add(func);
	}

	@Override
	public boolean addAll(Collection<? extends function> func) {
		return this.tab.addAll(func);
	}

	@Override
	public void clear() {
		this.tab.clear();
	}

	@Override
	public boolean contains(Object func) {
		return this.tab.contains(func);
	}

	@Override
	public boolean containsAll(Collection<?> func) {
		return this.tab.containsAll(func);
	}

	@Override
	public boolean isEmpty() {
		return this.tab.isEmpty();
	}

	@Override
	public Iterator<function> iterator() {
		return this.tab.iterator();
	}

	@Override
	public boolean remove(Object func) {
		return this.tab.remove(func);
	}

	@Override
	public boolean removeAll(Collection<?> func) {
		return this.tab.removeAll(func);
	}

	@Override
	public boolean retainAll(Collection<?> func) {
		return this.tab.retainAll(func);
	}

	@Override
	public int size() {
		return this.tab.size();
	}

	@Override
	public Object[] toArray() {
		return this.tab.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.tab.toArray(a);
	}

	@Override
	public void initFromFile(String file) throws IOException { // add Exce if the function isnt right
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("The functions have read");
			while (br.ready()) {

				ComplexFunction cf = new ComplexFunction();
				function y = cf.initFromString(br.readLine());
				System.out.println("f(x)= " + y);
				this.add(y);

			}
			br.close();
		} catch (Exception e) {
			System.out.println("coulndt find the file/ entered a wrong f(x)");
		}
	}

	@Override
	public void saveToFile(String file) throws IOException {
		try {
			String fileName = file;
			PrintWriter pw = new PrintWriter(new File(fileName));
			String userName = "";
			System.out.println("enter functions u want to push 1 by 1");
			System.out.println("to finish enter: end ");
			while (!userName.equals("end")) {
				StringBuilder sb = new StringBuilder();
				Scanner x = new Scanner(System.in);
				System.out.print("Enter f(x): ");
				userName = x.nextLine();
				sb.append(userName);
				pw.write(sb.toString());
				pw.println();
			}
			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		StdDraw.setCanvasSize(width, height);
		
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		
		double maxY = 2.0, minY = -2.0;
		// the function y = sin(4x), sampled at n+1 points
		// between x = 0 and x = pi
		double[] x = new double[resolution+1];
		double[][] y = new double[tab.size()][resolution+1];
	
		
		
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		
		
		
		for (double i = rx.get_min(); i < Math.abs( rx.get_min() - rx.get_max())  ; i++) {
			StdDraw.line(rx.get_min()+i, ry.get_min(), rx.get_min()+i, ry.get_max());
		}
		for (double i = ry.get_min(); i < Math.abs( ry.get_min() - ry.get_max())  ; i++) {
			StdDraw.line(rx.get_min(), ry.get_min()+i , rx.get_max(), ry.get_min()+i);
		}
		
		
		//StdDraw.setXscale(min, max);
	//	StdDraw.line(x0, y0, x1, y1);
		
		
		
	}

	@Override
	public void drawFunctions(String json_file) {

	}

}
