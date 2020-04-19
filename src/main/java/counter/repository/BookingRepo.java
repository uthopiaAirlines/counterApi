package counter.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import counter.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

    List<Booking> findByPatron(String patron);
}