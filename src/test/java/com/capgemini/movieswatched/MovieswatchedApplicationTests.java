package com.capgemini.movieswatched;

import com.capgemini.movieswatched.Controllers.MoviesController;
import com.capgemini.movieswatched.Repositories.MoviesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.capgemini.movieswatched.Models.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieswatchedApplicationTests {

	@InjectMocks
	private MoviesController reservationController;

	@Mock
	private MoviesRepository reservationRepository;

	@Mock
	private Movie mockMovie;

	@Test
	public void getAll() throws Exception {
        // mockwaarde
        final List<Movie> mockReservationList = new ArrayList<>();
        mockReservationList.add(mockMovie);
        when(reservationRepository.findAll()).thenReturn(mockReservationList);
    /*
        when(mockMovie.getReservationNumber()).thenReturn(1L);
        when(mockMovie.getGuest()).thenReturn(new Guest());
        when(mockMovie.getRoom()).thenReturn(new Room());
        when(mockMovie.getStartDate()).thenReturn(LocalDateTime.now());
        when(mockMovie.getEndDate()).thenReturn(LocalDateTime.now());
        when(mockMovie.isPayment()).thenReturn(true);


        // Repository lijst met Reservations
        final Iterable<ReservationDTO> ReservationDTOList = reservationController.getAll();

        // Check of Reservation repo aangeroepen
        verify(reservationRepository, times(1)).findAll();

        // Resultaat van controller overeenkomt met mock-waarde
        assertEquals(1, ReservationDTOList.spliterator().getExactSizeIfKnown());

        // Check dateformatter in DTO


        // Wat verwacht je van je DTO obv mockwaarden?
*/
    }
}
