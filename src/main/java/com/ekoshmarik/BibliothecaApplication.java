package com.ekoshmarik;

import com.ekoshmarik.options.OptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliothecaApplication {

	private final OptionManager optionManager;

	@Autowired
	public BibliothecaApplication(OptionManager optionManager) {
		this.optionManager = optionManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(BibliothecaApplication.class, args);
	}

	public void run(String... strings) throws Exception {
		optionManager.execute();
	}
}
