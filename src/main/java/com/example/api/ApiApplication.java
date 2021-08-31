package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args); //Почему бы не SpringApplication.run(ReconTool.class, args)?
		// Потому что таким образом пружина настроена не полностью (без сканирования компонентов и т. д.). Создается только bean-компонент, определенный в run () (ReconTool).
		//Нужно запустить Application.run(), т.к. этот метод запускает весь Spring Framework. Приведенный выше код объединяет main() с Spring Boot,
		// будет работать при любых обстоятельствах, хотите ли вы запустить приложение из IDE или из инструмента сборки.
	}



}
