package se.gritacademy.fulkopinguthyrning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.gritacademy.fulkopinguthyrning.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}