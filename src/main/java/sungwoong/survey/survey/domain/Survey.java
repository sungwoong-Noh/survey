package sungwoong.survey.survey.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.ToString;
import sungwoong.survey.BaseEntity;

import java.time.LocalDateTime;

@Getter
@ToString
@Entity
public class Survey extends BaseEntity {

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
