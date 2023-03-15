package com.vint.shop.service.impl;

import com.vint.shop.domain.Review;
import com.vint.shop.repository.ReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new ReviewServiceImpl(reviewRepository);
    }

    @Test
    void findAll() {
        underTest.findAll();
        Mockito.verify(reviewRepository).findAll();
    }

    @Test
    void saveReview() {
        Review newReview = new Review();
        underTest.saveReview(newReview);
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        Mockito.verify(reviewRepository).save(reviewArgumentCaptor.capture());
        Review capchaReview = reviewArgumentCaptor.getValue();
        assertThat(capchaReview).isEqualTo(newReview);
    }

    @Test
    void viewDeleteReview() {
        Review newOrder = new Review();
        newOrder.setId(5);
        reviewRepository.deleteById(newOrder.getId());
        ArgumentCaptor<Long> reviewArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(reviewRepository).deleteById(reviewArgumentCaptor.capture());
        Long i = reviewArgumentCaptor.getValue();
        Assertions.assertEquals(5, i);
    }

    boolean resultTest = false;

    @Test
    void trueIfFindReview() {
        Review newOrder = new Review();
        when(reviewRepository.findById(newOrder.getId())).thenReturn(Optional.of(newOrder));
        if (reviewRepository.findById(newOrder.getId()).isPresent()) resultTest = true;
        assertThat(resultTest).isTrue();
    }
}