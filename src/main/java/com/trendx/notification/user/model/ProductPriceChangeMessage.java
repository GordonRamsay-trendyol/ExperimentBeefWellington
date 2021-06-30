package com.trendx.notification.user.model;

public class ProductPriceChangeMessage {
    private final long productId;
    private final String title;
    private final String url;

    public ProductPriceChangeMessage(Long id, String title, String url) {
        this.productId = id;
        this.title = title;
        this.url = url;
    }

    public Long getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
