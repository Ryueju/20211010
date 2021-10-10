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
		System.out.println("1. �ؽ�Ʈ ���� �ҷ�����");
		System.out.println("2. �ؽ�Ʈ ���� �����ϱ�");
		System.out.println("3. ���α׷� ����");
	}

	public void run() {
		while (true) {
			menu();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				System.out.println("�ؽ�Ʈ ������ �ҷ��ɴϴ�. �����ϴ� ������ ���� ��� �ڵ����� �����˴ϴ�.");
				inputString();
				break;

			case 2:
				System.out.println("������ �����մϴ�.");
				copyfile();
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				sc.close();
				return;

			}

		}

	}

	public void copyfile() {

		File file = new File("C:\\\\Users\\\\eju43\\\\OneDrive\\\\���� ȭ��\\\\����½�Ʈ�� ����.txt");
		File outPutFile = new File("C:\\\\Users\\\\eju43\\\\OneDrive\\\\���� ȭ��\\\\����½�Ʈ�� ����-.txt");

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
		System.out.println("���� �Ϸ�");

	}
	// TODO Auto-generated method stub

	File file = new File("C:\\Users\\eju43\\OneDrive\\���� ȭ��\\����½�Ʈ�� ����.txt");

	public void inputString() {
		try {
			if (file.exists()) {
				Desktop.getDesktop().edit(file);
			} else {

				System.out.println("�����ϴ� �ؽ�Ʈ ������ ���� ���� �����մϴ�.");
				// sc.nextInt();
				file.createNewFile();
				Desktop.getDesktop().edit(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
