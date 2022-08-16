package com.lockedMe.prooject;

public final class Lockedme {
public static void main(String[] args) {
		
	
		FileOperations.createMainFolderIfNotExist("main");
		
		FileMenuOption.printWelcomeScreen("LockedMe.com", "SIVA");
		
		FileHandleOption.handleWelcomeScreenInput();
	}

	
}
