package com.health.metrics.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 7:56 PM
 **/

@Setter
@Getter
@ToString
public class AggregationUserHealthParamsDTO {
    private long mobileNumber;
    private double averageHeight;
    private double averageWeight;
    private double averageCalories;
    private double averageCaloriesBurn;

    @Builder
    public AggregationUserHealthParamsDTO(long mobileNumber, double averageHeight, double averageWeight, double averageCalories, double averageCaloriesBurn){
        this.mobileNumber = mobileNumber;
        this.averageHeight = averageHeight;
        this.averageWeight = averageWeight;
        this.averageCalories = averageCalories;
        this.averageCaloriesBurn = averageCaloriesBurn;
    }
}
