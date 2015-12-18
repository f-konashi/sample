package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * このアプリケーションのエントリークラスです.
 * 
 * @author f-konashi
 */
@SpringBootApplication
public class Application {
	/**
	 * このアプリケーションのエントリーメソッド(mainメソッド)です.
	 * 
	 * @param args　コマンドライン引数
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
