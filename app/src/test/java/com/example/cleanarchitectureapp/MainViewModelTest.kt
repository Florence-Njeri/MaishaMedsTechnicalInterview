package com.example.cleanarchitectureapp

import com.example.cleanarchitectureapp.repository.DataRepository
import com.example.cleanarchitectureapp.ui.viewmodel.MainActivityViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class MainViewModelTest {
    val dataRepository: DataRepository = mock()
    private lateinit var mainActivityViewModel: MainActivityViewModel
    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mainActivityViewModel = MainActivityViewModel(dataRepository)
        Dispatchers.setMain(testDispatcher)

    }

    @Test
    fun `get dummy data calls repository to fetch data`() {
        mainActivityViewModel.getDummyData()
        verify(dataRepository).fetchData()
    }

    @Test
    fun `refresh data calls repository to refresh data from network`(){
        mainActivityViewModel.refreshData()
        runBlocking {
            verify(dataRepository).refreshData()
        }
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown(){
        Dispatchers.resetMain()
        // Clean up the TestCoroutineDispatcher to make sure no other work is running.
        testDispatcher.cleanupTestCoroutines()
    }
}