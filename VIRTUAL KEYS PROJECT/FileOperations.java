package com.lockedMe.prooject;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
@SuppressWarnings("unused")
public class FileOperations {
	public static void handleWelcomeScreenInput() {
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				FileMenuOption.displayMenuScreen();
				int option = scan.nextInt();

				switch (option) {
				case 1:
					FileOperations.displayAllFiles("main");
					break;
				case 2:
					FileOperations.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully....");
					flag = false;
					scan.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (flag== true);
	}
	
	static void displayAllFiles(String string) {
		
		
	}

	public static void handleFileMenuOptions() {
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				FileMenuOption.displayFileMenuOptions();
				FileOperations.createMainFolderIfNotExist("main");
				
				int option = scanner.nextInt();
				switch (option) {
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String Addfile = scanner.next();
					
					FileOperations.createFiles(Addfile, scanner);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = scanner.next();
					
					FileOperations.createMainFolderIfNotExist("main");
					List<String> Deletefiles = FileOperations.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\n Select index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int input = scanner.nextInt();
					
					if (input != 0) {
						FileOperations.deleteFileRepitatively(Deletefiles.get(input - 1));
					} else {
						
						// If input == 0, delete all files displayed for the name
						for (String path : Deletefiles) {
							FileOperations.deleteFileRepitatively(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String thefileName = scanner.next();
					
					FileOperations.createMainFolderIfNotExist("main");
					FileOperations.displayFileLocations(thefileName, "main");

					
					break;
				case 4:
					// Go to Previous menu
					return ;
					
				case 5:
					// Exit
					System.out.println("Program exited successfully...");
					flag = false;
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (flag == true);
	}

	static void deleteFileRepitatively(String string) {
		// TODO Auto-generated method stub
		
	}

	static List<String> displayFileLocations(String fileToDelete, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	static void createFiles(String addfile, Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	static void createMainFolderIfNotExist(String string) {
		// TODO Auto-generated method stub
		
	}
}