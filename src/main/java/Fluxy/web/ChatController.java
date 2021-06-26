package Fluxy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import Fluxy.data.ChatRepository;
import Fluxy.domain.Chat;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;

    private int x = 0;

    @GetMapping(value="/chat", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getChat() {
        return chatRepository.findAllByMessage("Hello");
    }

    @Scheduled(fixedRate = 3000)
    private void saveChat() {
        System.out.println("add msg hello: "+x);
        chatRepository.save(new Chat("Hello")).block();
        x++;
    }
}
