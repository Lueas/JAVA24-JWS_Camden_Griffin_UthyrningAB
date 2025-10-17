package se.gritacademy.fulkopinguthyrning.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingRequest {
    @NotNull(message = "Item ID cannot be null.")
    private Long itemId;

    @NotNull(message = "Person ID cannot be null.")
    private Long personId;

    @NotNull(message = "Start date cannot be null.")
    @FutureOrPresent(message = "Start date must not be in the past.")
    private LocalDate rentalStartDate;

    @NotNull(message = "End date cannot be null.")
    private LocalDate rentalEndDate;
}