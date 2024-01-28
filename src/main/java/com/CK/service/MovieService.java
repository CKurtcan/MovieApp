package com.CK.service;

import com.CK.entity.Movie;
import com.CK.repository.MovieRepository;
import com.CK.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MovieService implements ICrudService<Movie, Long> {
    private final MovieRepository movieRepository;
    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> findByProductNameIgnoreCase(String productName) {
        return Optional.empty();
    }

    @Override
    public List<Movie> findByProductNameContainsIgnoreCase(String productName) {
        return null;
    }

    @Override
    public List<Movie> findByProductPriceBetween(Double startPrice, Double endPrice) {
        return null;
    }

    @Override
    public List<Movie> findByProductUnitInStockGreaterThan(Integer minStockQuantity) {
        return null;
    }

    @Override
    public List<Movie> findByProductPriceGreaterThanEqual(Double price) {
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
    public List<Movie> findByProductCategoryIsNull() {
        return null;
    }

    @Override
    public List<Movie> findByProductCategoryStartingWith(char startChar) {
        return null;
    }
}
