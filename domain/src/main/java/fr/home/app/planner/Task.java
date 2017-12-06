package fr.home.app.planner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private String title;
    private String description;

    @ManyToOne
    private Goal parent;

    @ManyToOne
    private TaskCategory category;

    @Column(name = "Score", columnDefinition = "Decimal(10,2) default '0'")
    private Double score;

    @ManyToOne
    private Address place;
}
