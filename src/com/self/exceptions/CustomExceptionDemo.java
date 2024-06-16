package com.self.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomExceptionDemo {
	public static void main(String[] args) {
		System.out.println("Within main.");
		try {
			trial(1);
		}
		catch (BasicCustomException e){
			System.out.println(e.getMessage());
			System.out.println("Empty exception called.");
		}
		catch (CustomException e){
			System.out.println(e.getMessage());
			System.out.println(e.getResponse());
			System.out.println(e.getCode());
		}
		
		try {
			trial(3);
		}
		catch (BasicCustomException e){
			System.out.println(e.getMessage());
			System.out.println("Empty exception called.");
		}
		catch (CustomException e){
			System.out.println(e.getMessage());
			System.out.println(e.getResponse());
			System.out.println(e.getCode());
		}

	}

	public static void trial(int data) throws BasicCustomException, CustomException
	{
		if(data == 1)
			//throw new BasicCustomException("BasicCustomException invoked.");//Gives error
			throw new BasicCustomException();
		else
			throw new CustomException("Custom Exception reached.", "404");

	}

}
