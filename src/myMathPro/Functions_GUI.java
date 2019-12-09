package myMathPro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import com.google.gson.Gson;
public class Functions_GUI implements functions {
	ArrayList<function> tab;

	public Functions_GUI() {
		this.tab = new ArrayList<function>();
		this.tab.add(new ComplexFunction());
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
	public void initFromFile(String file) throws IOException {
		try {
			FileReader fr = new FileReader("GUI_params.txt"); 
			BufferedReader br = new BufferedReader (fr);
			while(br.ready()) 
	        { 
	            System.out.println(br.readLine());   	 
			}
		} catch (Exception e) {
			System.out.println("coulndt find the file");
		}
	}

	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}
