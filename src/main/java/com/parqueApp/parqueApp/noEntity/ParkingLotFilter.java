package com.parqueApp.parqueApp.noEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLotFilter implements Serializable {

    @Nullable
    private LocalTime start_time;

    @Nullable
    private LocalTime end_time;

    @Nullable
    private double min_Amount;

    @Nullable
    private double max_Amount;

    private String type;
}
