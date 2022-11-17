package spring.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.strategy.code.strategy.ContextV2;
import spring.advanced.trace.strategy.code.strategy.StrategyLogic1;
import spring.advanced.trace.strategy.code.strategy.StrategyLogic2;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV0() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }


    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        int index = 1;
        contextV2.execute(() -> log.info("비지니스 로직" + index + " 실행"));
        contextV2.execute(() -> log.info("비지니스 로직2 실행"));
    }

}
