package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestInputTxt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan;
		try {
		
		File file = new File("input.txt");
		scan = new Scanner(file);
		scan.useDelimiter(",");
		for(int j =0; j < 12; j++) {
		String info = scan.nextLine();
		String[] infoArr = info.split(",");
		
		for(int i = 0; i < 3; i++) {
			System.out.print(infoArr[i] + " ");
		}
		System.out.println();
		}
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
