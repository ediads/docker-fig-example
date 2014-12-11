package com.edkurowski.controller;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/memcached")
public class Memcached {

    @Autowired
    private MemcachedClient memcachedClient;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<SocketAddress, Map<String, String>> getValues() {
        return memcachedClient.getStats();
    }

    @RequestMapping("/set/{key}/{value}")
    @ResponseBody
    public Boolean setValue(@PathVariable String key, @PathVariable String value) throws ExecutionException, InterruptedException {
        return memcachedClient.set(key, 0, value).get();
    }

    @RequestMapping("/get/{key}")
    @ResponseBody
    public Object getValue(@PathVariable String key) {
        return memcachedClient.get(key);
    }
}
