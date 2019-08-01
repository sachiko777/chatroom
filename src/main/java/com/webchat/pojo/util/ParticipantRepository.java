package com.webchat.pojo.util;

import com.webchat.pojo.UserNew;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *在线用户仓库，存储在线用户
 */
@Component
public class ParticipantRepository {
    private Map<String, UserNew> activeSessions=new ConcurrentHashMap<String, UserNew>();//在线用户map，键：用户名称，值：用户对象

    public Map<String, UserNew> getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(Map<String, UserNew> activeSessions) {
        this.activeSessions = activeSessions;
    }

    public void add(String name,UserNew user){
        activeSessions.put(name,user);
    }

    public UserNew reomve(String name){
        return activeSessions.remove(name);
    }

    //验证键值对是否存在此KEY值
    public boolean containsUserName(String name){
        return activeSessions.containsKey(name);
    }

}
