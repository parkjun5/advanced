package spring.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.strategy.code.strategy.ContextV1;
import spring.advanced.trace.strategy.code.strategy.Strategy;
import spring.advanced.trace.strategy.code.strategy.StrategyLogic1;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {

        logic1();
        logic2();
    }
    
    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비지니스 로직1 실행");
        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("resultTIme={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비지니스 로직2 실행");
        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("resultTIme={}", resultTime);
    }

    @Test
    void strategyV1() {
        Strategy strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        Strategy strategyLogic2 = new StrategyLogic1();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategy1 = () -> log.info("비지니스 로직1 실행");
        ContextV1 contextV1 = new ContextV1(strategy1);
        log.info("strategyLogic1 = {}", strategy1.getClass());
        contextV1.execute();

        Strategy strategy2 = new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        };
        ContextV1 contextV2 = new ContextV1(strategy2);
        log.info("strategyLogic2 = {}", strategy2.getClass());
        contextV2.execute();
    }

    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("비지니스 로직1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        });
        contextV2.execute();
    }
}
