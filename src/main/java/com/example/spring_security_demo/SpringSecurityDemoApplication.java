package com.example.spring_security_demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
//		String password = "password";
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		System.out.println(encoder.encode(password));



//		//Данный пример показывает, что ThreadLocal хранит уникальное значение для каждого потока,
//		//хотя мы юзаем один и тот же объект name, имена в значения переменных в разных потоках разные
//		//изменения ThreadLocal видны только в пределах потока, в котором мы с ней работаем.
//		ThreadLocal<String> name = new ThreadLocal<>();
//		//A
//		Thread threadA = new Thread(() -> {
//			System.out.println("In A thread: " + name.get());
//			name.set("In thread A");
//			System.out.println("In A thread: " + name.get());
//		});
//		threadA.start();
//
//		Thread.sleep(3000);
//
//		//B
//		Thread threadB = new Thread(() -> {
//			System.out.println("In B thread: " + name.get());
//			name.set("In thread B");
//			System.out.println("In B thread: " + name.get());
//		});
//		threadB.start();
	}

}
