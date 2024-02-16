package com.panrose.tacocloud;

//import com.panrose.tacocloud.service.HomeController;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {

		SpringApplication.run(TacoCloudApplication.class, args);
		/*ApplicationContext appContext = new AnnotationConfigApplicationContext(TacoCloudAppConfig.class);
		HomeController homeController = appContext.getBean("homeController", HomeController.class);
		System.out.println(homeController.getHomePage());*/
	}

}
