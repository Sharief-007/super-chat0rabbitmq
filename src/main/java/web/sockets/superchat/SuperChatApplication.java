package web.sockets.superchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SuperChatApplication {

	@GetMapping("/")
	public String home(){
		return "index";
	}

	@MessageMapping("/map")
	@SendTo("/topic/active")
	public String send(@Payload String message){
		return message.toUpperCase();
	}
	public static void main(String[] args) {
		SpringApplication.run(SuperChatApplication.class, args);
	}

}
