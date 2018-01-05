package com.techlabs.resume.test;

import com.techlabs.resumee.ResumeBuilder;

public class ResumeTest {

	public static void main(String details[]) {
		ResumeBuilder resume = new ResumeBuilder("Sarvesh","9878653254","coding","Computer Engineer");
		resume.createResume();
	}
}
