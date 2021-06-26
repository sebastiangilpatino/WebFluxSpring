package Fluxy.data;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import Fluxy.domain.Chat;
import reactor.core.publisher.Flux;

@Repository
public interface ChatRepository extends ReactiveCrudRepository<Chat, Integer> {
    @Tailable
    Flux<Chat> findAllByMessage(String message);
}
