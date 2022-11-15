package spring.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRepository0 orderRepository;

    public void orderItem(String orderId) {
        orderRepository.save(orderId);
    }
}
