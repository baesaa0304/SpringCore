package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {
    @Test
    void createOrder() {
      MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
      memoryMemberRepository.save(new Member(1L, "name" , Grade.VIP));

      OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository , new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}
