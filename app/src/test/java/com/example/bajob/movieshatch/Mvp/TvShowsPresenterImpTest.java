package com.example.bajob.movieshatch.Mvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by bajob on 2/10/2017.
 */
public class TvShowsPresenterImpTest {
    @Mock
    DataSourceManager dataSourceManager;
    @Mock
    TvShowsView mvpView;

    TvShowsPresenterImp tvShowsPresenterImp;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.tvShowsPresenterImp = new TvShowsPresenterImp(dataSourceManager);
        this.tvShowsPresenterImp.bindView(mvpView);

    }

    @Test
    public void testLoadListData() throws Exception {
        tvShowsPresenterImp.loadListData(1);
        verify(mvpView).showProgress();
        verify(dataSourceManager).loadData(1);
    }

    @Test
    public void testBindView() throws Exception {
        tvShowsPresenterImp.bindView(mvpView);
        assertNotNull(this.tvShowsPresenterImp.view);

    }

    @Test
    public void testUnbindView() throws Exception {
        tvShowsPresenterImp.unbindView();
        assertNull(this.tvShowsPresenterImp.view);

    }
}