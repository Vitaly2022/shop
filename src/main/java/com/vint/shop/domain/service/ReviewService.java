package com.vint.shop.domain.service;

import com.vint.shop.domain.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    boolean deleteReview(Long id);

    boolean saveReview(Review id);
}
