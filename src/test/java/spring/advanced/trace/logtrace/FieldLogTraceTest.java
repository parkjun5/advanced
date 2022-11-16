package spring.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;
import spring.advanced.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {

    @Test
    void requestTest() {
        FieldLogTrace fieldLogTrace = new FieldLogTrace();
        TraceStatus status1 = fieldLogTrace.begin("HI NEWBIE");
        TraceStatus status2 = fieldLogTrace.begin("LEVEL 2");
        TraceStatus status3 = fieldLogTrace.begin("LEVEL 3");

        fieldLogTrace.end(status3);
        fieldLogTrace.end(status2);
        fieldLogTrace.end(status1);
    }

    @Test
    void exceptionTest() {
        FieldLogTrace fieldLogTrace = new FieldLogTrace();
        TraceStatus status1 = fieldLogTrace.begin("HI NEWBIE");
        TraceStatus status2 = fieldLogTrace.begin("LEVEL 2");
        TraceStatus status3 = fieldLogTrace.begin("LEVEL 3");

        fieldLogTrace.exception(status3, new IllegalStateException("예외발생"));
        fieldLogTrace.exception(status2, new IllegalStateException("예외발생"));
        fieldLogTrace.exception(status1, new IllegalStateException("예외발생"));
    }
}