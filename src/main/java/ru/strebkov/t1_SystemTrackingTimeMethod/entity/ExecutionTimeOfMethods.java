package ru.strebkov.t1_SystemTrackingTimeMethod.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "t1persons", name = "execution_time_of_methods")
public class ExecutionTimeOfMethods {
    @Id
    @Column(name = "id_time_of_methods", columnDefinition = "serial")
    private int idTimeOfMethods;
    @Column(name = "method_name", nullable = false)
    private String methodName;
    @Column(name = "total_time", nullable = false)
    private double totalTime;
}
