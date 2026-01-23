package com.wipro.ofs.util;

public class OutOfStockException extends Exception {
	private static final long serialVersionUID = 1L;
 @Override
    public String toString() {
        return "OutOfStockException: Requested quantity exceeds available stock.";
    }
}
