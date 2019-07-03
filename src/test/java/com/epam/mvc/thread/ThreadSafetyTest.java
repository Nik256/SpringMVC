package com.epam.mvc.thread;

import com.epam.mvc.ProductApp;
import com.epam.mvc.model.Product;
import com.epam.mvc.repository.ProductRepository;
import com.epam.mvc.service.ProductService;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProductApp.class})
public class ThreadSafetyTest {
    private static final int THREAD_COUNT = 1000;
    private static final int OPERATION_COUNT = 100000;
    private static final Faker faker = new Faker();

    @SpyBean
    private ProductRepository productRepository;

    @Test
    public void testProductCreationThreadSafety() throws InterruptedException {
        int initialSize = productRepository.getAll().size();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        IntStream.range(0, OPERATION_COUNT).forEach(i -> executorService.submit(() -> productRepository.create(
                new Product(i,
                faker.book().title(),
                faker.book().genre() + faker.book().author()))));
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        assertEquals(initialSize + OPERATION_COUNT, productRepository.getAll().size());
    }
}
