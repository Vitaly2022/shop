package com.vint.shop.service;

import com.vint.shop.domain.Category;
import com.vint.shop.domain.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    boolean deleteReview(Long id);

    boolean saveReview(Review id);
}
