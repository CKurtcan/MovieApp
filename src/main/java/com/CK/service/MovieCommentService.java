package com.CK.service;

import com.CK.entity.MovieComment;
import com.CK.repository.MovieCommentRepository;
import com.CK.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MovieCommentService implements ICrudService<MovieComment, Long> {
    private final MovieCommentRepository movieCommentRepository;
    @Override
    public MovieComment save(MovieComment movieComment) {
        return null;
    }

    @Override
    public MovieComment update(MovieComment movieComment) {
        return null;
    }

    @Override
    public Iterable<MovieComment> saveAll(Iterable<MovieComment> t) {
        return null;
    }

    @Override
    public Optional<MovieComment> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<MovieComment> findAll() {
        return null;
    }

    @Override
    public Optional<MovieComment> findByProductNameIgnoreCase(String productName) {
        return Optional.empty();
    }

    @Override
    public List<MovieComment> findByProductNameContainsIgnoreCase(String productName) {
        return null;
    }

    @Override
    public List<MovieComment> findByProductPriceBetween(Double startPrice, Double endPrice) {
        return null;
    }

    @Override
    public List<MovieComment> findByProductUnitInStockGreaterThan(Integer minStockQuantity) {
        return null;
    }

    @Override
    public List<MovieComment> findByProductPriceGreaterThanEqual(Double price) {
        return null;
    }

    @Override
    public Long countByProductCategory(String productCategory) {
        return null;
    }

    @Override
    public Integer countByProductName(String productName) {
        return null;
    }

    @Override
    public boolean existsByProductCategory(String productCategory) {
        return false;
    }

    @Override
    public List<MovieComment> findByProductCategoryIsNull() {
        return null;
    }

    @Override
    public List<MovieComment> findByProductCategoryStartingWith(char startChar) {
        return null;
    }
}
