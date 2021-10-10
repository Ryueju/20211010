package co.eju.prj;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Stream {

	Scanner sc = new Scanner(System.in);

	public void menu() {
		System.out.println("1. 텍스트 파일 불러오기");
		System.out.println("2. 텍스트 파일 복사하기");
		System.out.println("3. 프로그램 종료");
	}

	public void run() {
		while (true) {
			menu();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				System.out.println("텍스트 파일을 불러옵니다. 존재하는 파일이 없을 경우 자동으로 생성됩니다.");
				inputString();
				break;

			case 2:
				System.out.println("파일을 복사합니다.");
				copyfile();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;

			}

		}

	}

	public void copyfile() {

		File file = new File("C:\\\\Users\\\\eju43\\\\OneDrive\\\\바탕 화면\\\\입출력스트림 과제.txt");
		File outPutFile = new File("C:\\\\Users\\\\eju43\\\\OneDrive\\\\바탕 화면\\\\입출력스트림 과제-.txt");

		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		try {
			fileInputStream = new FileInputStream(file);
			fileOutputStream = new FileOutputStream(outPutFile);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(fileInputStream.available());

		} catch (IOException e) {
			e.printStackTrace();
		}

		int i = 0;
		try {
			while ((i = fileInputStream.read()) != -1) {
				fileOutputStream.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			// close the stream
			if (fileInputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		System.out.println("복사 완료");

	}
	// TODO Auto-generated method stub

	File file = new File("C:\\Users\\eju43\\OneDrive\\바탕 화면\\입출력스트림 과제.txt");

	public void inputString() {
		try {
			if (file.exists()) {
				Desktop.getDesktop().edit(file);
			} else {

				System.out.println("존재하는 텍스트 파일이 없어 새로 생성합니다.");
				// sc.nextInt();
				file.createNewFile();
				Desktop.getDesktop().edit(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
