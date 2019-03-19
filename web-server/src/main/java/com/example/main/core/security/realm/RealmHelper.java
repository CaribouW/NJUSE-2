package com.example.main.core.security.realm;

import com.example.main.core.security.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RealmHelper {
    private static final Logger logger = LoggerFactory.getLogger(RealmHelper.class);
    @Autowired
    TokenManager tokenManager;

    public Set<String> getRoleContent(String userId) {
        return null;
    }

    public Set<String> getPermissionContent(String userId) {
        return null;
    }
}
