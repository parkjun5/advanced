package spring.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;
import spring.advanced.trace.TraceStatus;

class ThreadLocalLogTraceTest {

    @Test
    void requestTest() {
        ThreadLocalLogTrace fieldLogTrace = new ThreadLocalLogTrace();
        TraceStatus status1 = fieldLogTrace.begin("HI NEWBIE");
        TraceStatus status2 = fieldLogTrace.begin("LEVEL 2");
        TraceStatus status3 = fieldLogTrace.begin("LEVEL 3");

        fieldLogTrace.end(status3);
        fieldLogTrace.end(status2);
        fieldLogTrace.end(status1);
    }

    @Test
    void exceptionTest() {
        ThreadLocalLogTrace fieldLogTrace = new ThreadLocalLogTrace();
        TraceStatus status1 = fieldLogTrace.begin("HI NEWBIE");
        TraceStatus status2 = fieldLogTrace.begin("LEVEL 2");
        TraceStatus status3 = fieldLogTrace.begin("LEVEL 3");

        fieldLogTrace.exception(status3, new IllegalStateException("예외발생"));
        fieldLogTrace.exception(status2, new IllegalStateException("예외발생"));
        fieldLogTrace.exception(status1, new IllegalStateException("예외발생"));
    }
}