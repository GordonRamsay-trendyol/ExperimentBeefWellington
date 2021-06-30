package com.trendx.notification.user.repo;

import com.trendx.notification.user.model.Product;

import java.util.Optional;

public interface ProductRepo {
    Optional<Product> find(Long id);
}
