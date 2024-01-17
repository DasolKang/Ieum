package com.ukcorp.ieum.pill.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "PILL_INFO")
public class PillInfo {
    @Id
    private long pillInfoNo;
    private long careNo;
    private LocalDate pillStartDate;
    private LocalDate pillEndDate;
//    식전/식후
    private String pillMethod;
    @OneToMany
    private List<PillTime> pillTimes;
}