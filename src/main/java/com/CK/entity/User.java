package com.CK.entity;

import com.CK.utility.EStatus;
import com.CK.utility.EUserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.service.GenericResponseService;

import javax.xml.stream.events.Comment;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(nullable = false, length = 32)
    private String password;
    @Column(nullable = false, length = 32)
    private String rePassword;

    @ElementCollection
    private List<Long> favMoviesId;
    @ElementCollection
    private List<Long> favGenresId;
    @ElementCollection
    private List<Long> commentsId;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EUserType userType = EUserType.USER;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.PENDING;
}
