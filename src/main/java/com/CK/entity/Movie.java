package com.CK.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String genre;
    private String language;
    private String image;
    private String name;
    private String country;
    private Double rating;
    @Column(length = 5000)
    private String summary;
    private String premiered;
    private String url;

    @ElementCollection
    private List<Long> genresId;
    @ElementCollection
    private List<Long> commentsId;
}
