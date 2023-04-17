package com.vint.shop.service.controllers;

import com.vint.shop.domain.Review;
import com.vint.shop.repository.ReviewRepository;
import com.vint.shop.service.impl.ReviewServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/review")
public class ReviewController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
    @Autowired
    protected ReviewServiceImpl reviewServiceImpl;

    @Autowired
    protected ReviewRepository reviewRepository;

    @GetMapping
    public String viewCategory(Model model) {
        model.addAttribute("allReview", reviewServiceImpl.findAll());
        model.addAttribute("newReviewForm", new Review());
        return "admin/review/review";
    }

    @PostMapping
    public String newCategory(@ModelAttribute("newReviewForm") Review newReviewForm, Model model) {
        if (!reviewServiceImpl.saveReview(newReviewForm)) {
            model.addAttribute("reviewnameError", "This title review is taken");
            return "admin/review";
        }
        logger.debug(String.format("Review with id: %s successfully created.", newReviewForm.getId()));
        return "redirect:/admin/review";

    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        reviewServiceImpl.deleteReview(id);
        logger.debug(String.format("Review with id: %s has been successfully deleted.", id));
        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") long id, Model model) {
        if (!reviewRepository.existsById(id)) {
            return "redirect:admin/review";
        }
        Review review = reviewRepository.findById(id).get();
        ArrayList<Review> editReview = new ArrayList<>();
        editReview.add(review);
        model.addAttribute("editReview", editReview);
        return "admin/review/editreview";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable("id") long id, @RequestParam String title, @RequestParam String content, Model model) {
        Review review = reviewRepository.findById(id).get();
        review.setTitle(title);
        review.setContent(content);
        reviewRepository.save(review);
        logger.debug(String.format("Review with id: %s has been successfully update.", id));
        return "redirect:/admin/review";
    }


}
