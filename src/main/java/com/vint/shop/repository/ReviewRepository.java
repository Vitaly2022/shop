package com.vint.shop.repository;

import com.vint.shop.domain.Review;
import com.vint.shop.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review findByTitle(String title);
}
