package com.practise.code.memory;

public class StrongReference {

	private String status = "Hi I am active";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static void main(String[] args) {
		StrongReference ex = new StrongReference();
		System.out.println(ex.getStatus());
	}
}
