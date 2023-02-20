package com.vint.shop.repository;

import com.vint.shop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long>{

   Category findByName(String name);


}
