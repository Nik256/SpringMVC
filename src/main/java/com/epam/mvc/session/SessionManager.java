package com.epam.mvc.session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionManager {

    @Value("${maxRequestCount}")
    private int maxRequestCount;

    public void reduceRequestNumber() {
        maxRequestCount--;
    }

    public boolean isRequestAvailable() {
        return maxRequestCount != 0;
    }
}
