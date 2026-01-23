package com.wipro.ofs.util;

public class ItemNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
@Override
    public String toString() {
        return "ItemNotFoundException: Menu item not found.";
    }
}
