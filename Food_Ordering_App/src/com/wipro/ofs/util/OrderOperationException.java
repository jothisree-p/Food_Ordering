package com.wipro.ofs.util;

public class OrderOperationException extends Exception {
	private static final long serialVersionUID = 1L;
@Override
    public String toString() {
        return "OrderOperationException: Invalid order operation.";
    }
}
