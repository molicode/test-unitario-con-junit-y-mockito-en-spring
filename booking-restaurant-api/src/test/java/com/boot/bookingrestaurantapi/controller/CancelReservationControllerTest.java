package com.boot.bookingrestaurantapi.controller;

import com.boot.bookingrestaurantapi.controllers.CancelReservationController;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.CancelReservationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class CancelReservationControllerTest {

    private static final String SUCCES_STATUS = "Succes";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";


    private static final String RESERVATION_DELETED = "LOCATOR_DELETED";
    private static final String LOCATOR = "Burguer 7";

    @Mock
    CancelReservationService cancelReservationService;

    @InjectMocks
    CancelReservationController cancelReservationController;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        Mockito.when(cancelReservationService.deleteReservation(LOCATOR)).thenReturn(RESERVATION_DELETED);

    }


    @Test
    public void deleteReservationTest() throws BookingException {

        final BookingResponse<String> response = cancelReservationController.deleteReservation(LOCATOR);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), RESERVATION_DELETED);

    }

}
