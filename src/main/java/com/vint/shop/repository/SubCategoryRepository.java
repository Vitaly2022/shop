package com.vint.shop.repository;

import com.vint.shop.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository <SubCategory, Integer> {
}
