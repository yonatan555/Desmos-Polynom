package myMathPro;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	public void initFromFile(String file) throws IOException { //  read only functions and add to the arrayList
		try {
			tab = new ArrayList<function>();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while (br.ready()) {
				
				ComplexFunction cf = new ComplexFunction();
				function y = cf.initFromString(br.readLine());
				System.out.println("f(x)= " + y);
				this.add(y);

			}
			System.out.println("The functions have read");
			br.close();
		} catch (Exception e) {
			System.out.println("coulndt find the file/ entered a wrong f(x)");
		}
	}

	@Override
	public void saveToFile(String file) throws IOException {
		try {
			FileWriter read = new FileWriter(file);
			Iterator<function> itrfunc = tab.iterator();
			while(itrfunc.hasNext())
			{
				function func = itrfunc.next();
				read.write(func.toString()+"/n");
			}
			read.close();
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
		
		double[] x = new double[resolution+1];
		double[][] y = new double[tab.size()][resolution+1];	
		StdDraw.setPenColor(Color.lightGray);
		for (double i = rx.get_min(); i < Math.abs( rx.get_min() - rx.get_max())  ; i++) {
			StdDraw.line(rx.get_min()+i, ry.get_min(), rx.get_min()+i, ry.get_max());
		}
		for (double i = ry.get_min(); i < Math.abs( ry.get_min() - ry.get_max())  ; i++) {
			StdDraw.line(rx.get_min(), ry.get_min()+i , rx.get_max(), ry.get_min()+i);
		}
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.006);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.setFont(new Font("T", Font.ITALIC, 15));
		for (double i = ry.get_min(); i <= ry.get_max(); i++) {
			StdDraw.text(-0.20,i, Integer.toString(Math.toIntExact((long) i)));
		}
		for (double i = rx.get_min(); i <= rx.get_max(); i++) {
			StdDraw.text(i, -0.30, Integer.toString(Math.toIntExact((long) i)));
		}	
		for (function function : tab) {
			double rx_step = (Math.abs(rx.get_min())+Math.abs(rx.get_max()))/resolution;
			int first = (int)(Math.random()*256);
			int sec = (int)(Math.random()*256);
			int third = (int)(Math.random()*256);
			Color color = new Color(first,sec,third);
			StdDraw.setPenColor(color);
			for (double i = rx.get_min(); i < rx.get_max(); i+=rx_step)
			{
				StdDraw.line(i, function.f(i), i+rx_step, function.f(i+rx_step));
			}
			System.out.println(function.toString());		
		}
	}
	@Override
	public void drawFunctions(String json_file) {

	}
	
	public String toString() {
		String ans = "[";
		for (int i = 0; i< this.size();i++) {
			ans+=this.tab.get(i).toString()+",";
		}
		return ans + "]";
	}

}
