package com.wipro.ofs.util;

public class InvalidUserException extends Exception {
	private static final long serialVersionUID = 1L;
@Override
    public String toString() {
        return "InvalidUserException: User ID does not exist.";
    }
}
