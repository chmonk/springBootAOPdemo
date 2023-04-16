package com.monk.AOPdemo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

	@Autowired
	Controller1 con1;

	@GetMapping("/2")
	public String GetMethod() throws Exception {
		
		PriorityQueue<Integer> a=new PriorityQueue<>();
		TreeSet<Integer> ad= new TreeSet<>();
		a.add(3);
		try {
			throw new DataFormatException("TEST");
		} catch (Exception e) {
			throw new DataFormatException("TEST1");

			
		}
//		return "helloFROM controller2";
	}

	@GetMapping("/21")
	public String firstGetMethod() throws Exception {

		System.out.println(GetMethod());

		System.out.println(con1.GetMethod());

		return "hello 21";
	}

	@GetMapping("/22")
	public String privateMethodTestAspect() {
		return "helloFROM controller3";
	}

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		float totalSize = Float.parseFloat(br.readLine());

		float transSpeed = Float.parseFloat(br.readLine());

		Integer archiverNums = Integer.parseInt(br.readLine());

		Queue<float[]> archives = new LinkedList<>();
		for (int i = 0; i < archiverNums; i++) {
			float[] rate = new float[2];
			String[] s = br.readLine()
					.split(" ");
			rate[0] = Float.parseFloat(s[0]);
			rate[1] = Float.parseFloat(s[1]);
			archives.add(rate);
		}

		int ans = calMinProcessTime(totalSize, transSpeed, archives);

		System.out.println(ans);

//	    System.out.println(totalSize.split(" ").toString());
		// System.out.println(input);

//	    1000 total bytes
		// 10 trsSpeed
		// 2 2 files
		// 100 50 processingSpeed 100/s 50%
		// 60 20 processingSpeed 60/s 20%
	}

	private static int calMinProcessTime(float totalSize, float transSpeed, Queue<float[]> archives) {

		int minTime = Integer.MAX_VALUE;

		while (archives.peek() != null) {
			float[] rate = archives.poll();

			float compressSize = totalSize * rate[1] / 100.0f;
			float compressTime = totalSize / rate[0];
			float transferTime = compressSize / transSpeed;

			int totalTime = (int) Math.round((Math.ceil(compressTime + transferTime)));
			minTime = Math.min(minTime, totalTime);
		}

		return minTime;
	}

}
