package org.example.services;

import org.springframework.scheduling.annotation.Scheduled;

public interface OfferViewService {

    // Вызывается каждые 5 секунд
    @Scheduled(fixedRate = 5000)
    void updateOfferViewsPeriodically();

    int getViews(String offerId);
}
