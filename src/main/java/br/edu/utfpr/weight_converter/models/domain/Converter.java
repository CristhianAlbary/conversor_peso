package br.edu.utfpr.weight_converter.models.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "converter")
@Data(staticConstructor = "of")
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Converter {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "initial_value")
    private BigDecimal initValue;

    @NonNull
    @Column(name = "unity_for")
    private String unityFor;

    @NonNull
    @Column(name = "unity_to")
    private String unityTo;

    @NonNull
    @Column(name = "result_value")
    private BigDecimal resultValue;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

}