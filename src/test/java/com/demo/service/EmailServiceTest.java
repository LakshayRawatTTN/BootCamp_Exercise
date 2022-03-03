package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {


    EmailService eService = spy(EmailService.class);
    @Mock
    Order order = mock(Order.class);
    String cc = null;


    //Test Cases for sendEmail(Order order, String cc) method.

    @Test(expected = NullPointerException.class)
    public void sendEmailTest_whenWePassEmailAndPlaceNoOrder() {
        order = null;
        cc = "dummyemail@gmail.com";
        eService.sendEmail(order, cc);
    }

    @Test(expected = NullPointerException.class)
    public void sendEmailTest_whenWePlaceOrderButEmailIsNull() {
        if (cc == null) {
            throw new NullPointerException();
        }
        eService.sendEmail(order, cc);
    }


    @Test(expected = NullPointerException.class)
    public void sendEmailTest_whenOrderAndEmailArePassedAsNull() {
        order = null;
        eService.sendEmail(order, null);
    }

    @Test
    public void sendEmailTest_whenWePassEmailAndPlaceOrder() {
        cc = "dummyemail@gmail.com";
        assertEquals(true, eService.sendEmail(order, cc));
    }


    //Test cases for sendEmail(Order order) method.

    @Test(expected = RuntimeException.class)
    public void sendEmailTest_WhenOrderIsNotNull() {
        eService.sendEmail(order);
    }

    @Test(expected = NullPointerException.class)
    public void sendEmail_WhenOrderIsNull() {
        order = null;
        eService.sendEmail(order);
    }

    @Test
    public void sendEmail_VerifyingMethodCalling() {
        eService.sendEmail(order, cc);
        verify(eService, times(1)).sendEmail(order, cc);
        verify(order, times(1)).setCustomerNotified(true);
    }
}