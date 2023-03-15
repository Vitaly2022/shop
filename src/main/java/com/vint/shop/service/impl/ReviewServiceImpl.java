package com.vint.shop.service.impl;

import com.vint.shop.domain.Review;
import com.vint.shop.service.ReviewService;
import com.vint.shop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    protected ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
    @Transactional
    @Override
    public boolean saveReview(Review title) {
        Review reviewFromDB = reviewRepository.findByTitle(title.getTitle());

        if (reviewFromDB != null) {
            return false;
        }
        reviewRepository.save(title);
        return true;
    }
    @Transactional
    @Override
    public boolean deleteReview(Long reviewId) {
        if (reviewRepository.findById(reviewId).isPresent()) {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

}
