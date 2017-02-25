package com.example.bajob.movieshatch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static org.mockito.Mockito.*;

/**
 * Created by bajob on 1/30/2017.
 */
public class MainActivityTest {

    private CompositeSubscription compositeSubscription ;
    private Subscription subscription;

    @Before
    public void setUp() throws Exception {
        compositeSubscription = new CompositeSubscription();

    }

    @After
    public void tearDown() throws Exception {
       compositeSubscription.unsubscribe();
    }

    @Test
    public void testThatThisIsWrong() throws Exception {
        Mockito.mock(Subscription.class);
        compositeSubscription.add(subscription);
        verify(compositeSubscription).hasSubscriptions();

    }

}