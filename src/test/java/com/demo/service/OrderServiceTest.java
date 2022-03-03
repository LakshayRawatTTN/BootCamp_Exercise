package com.demo.service;
import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    String cc = null;

    @Mock
    Order order = mock(Order.class);
    OrderService orderService = spy(OrderService.class);
    EmailService emailService = spy(EmailService.class);

    @Test(expected = RuntimeException.class)
    public void placeOrder_WhenOnlyOrderIsPlaced()
    {
        orderService.placeOrder(order);
    }

    @Test(expected = NullPointerException.class)
    public void placeOrder_WhenOnlyOrderIsPlacedAndOrderIsNull(){
        order = null;
        orderService.placeOrder(order);
    }

    @Test
    public void placeOrder_WhenWePassEmailAndPlaceOrder()
    {
        assertTrue(orderService.placeOrder(order,cc));
    }

    @Test(expected = NullPointerException.class)
    public void placeOrder_WhenWePassEmailAndOrderIsNull(){
        order = null;
        orderService.placeOrder(order,cc);
    }

    @Test
    public void placeOrder_VerifyingPlaceOrderMethodCalls(){
        double price = 0.0;
        orderService.placeOrder(order,cc);
        emailService.sendEmail(order,cc);

        verify(orderService,times(1)).placeOrder(order,cc);
        verify(order,times(1)).setPriceWithTax(price);
        verify(order,times(3)).setCustomerNotified(true);
        verify(emailService,times(1)).sendEmail(order,cc);

    }



}
