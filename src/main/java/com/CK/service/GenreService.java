package com.CK.service;

import com.CK.entity.Genre;
import com.CK.repository.GenreRepository;
import com.CK.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class GenreService implements ICrudService<Genre, Long> {
    private final GenreRepository genreRepository;
    @Override
    public Genre save(Genre genre) {
        return null;
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }

    @Override
    public Iterable<Genre> saveAll(Iterable<Genre> t) {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Optional<Genre> findByProductNameIgnoreCase(String productName) {
        return Optional.empty();
    }

    @Override
    public List<Genre> findByProductNameContainsIgnoreCase(String productName) {
        return null;
    }

    @Override
    public List<Genre> findByProductPriceBetween(Double startPrice, Double endPrice) {
        return null;
    }

    @Override
    public List<Genre> findByProductUnitInStockGreaterThan(Integer minStockQuantity) {
        return null;
    }

    @Override
    public List<Genre> findByProductPriceGreaterThanEqual(Double price) {
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
    public List<Genre> findByProductCategoryIsNull() {
        return null;
    }

    @Override
    public List<Genre> findByProductCategoryStartingWith(char startChar) {
        return null;
    }
}
