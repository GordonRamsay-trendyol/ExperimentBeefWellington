package com.trendx.notification.user.controller;

import com.trendx.notification.user.model.Product;
import com.trendx.notification.user.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/user-follows-product")
public class UserFollowsProductController {

    @PostMapping
    public ResponseEntity<?> followProduct(@RequestBody Product product) {
        System.out.println(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> unFollowProduct(User user, Product product) {
        return ResponseEntity.ok().build();
    }
}
