package Fluxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Fluxy.data.ChatRepository;
import Fluxy.domain.Chat;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    @Autowired
    ChatRepository chatRepository;

    public Flux<Chat> getChatMessages(String message){
        return chatRepository.findAllByMessage(message);
    }
}
