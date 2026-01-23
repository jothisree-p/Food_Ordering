package com.wipro.ofs.util;

public class OrderNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
@Override
    public String toString() {
        return "OrderNotFoundException: Order ID not found.";
    }
}
