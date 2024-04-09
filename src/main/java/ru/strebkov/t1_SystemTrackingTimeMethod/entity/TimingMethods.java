package ru.strebkov.t1_SystemTrackingTimeMethod.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "t1persons", name = "timing_methods")
public class TimingMethods {
    @Id
    @Column(name = "id_timing_methods")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_method", nullable = false)
    private String methodName;
    @Column(name = "time_total", nullable = false)
    private long totalTime;

}
