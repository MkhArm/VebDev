package org.example.services;

import org.example.services.impl.OfferViewCounterServiceImpl;
import java.util.List;

public interface OfferViewCounterService {
    // Метод для увеличения количества просмотров для указанного offerId
    Long incrementAndGetViews(String offerId);

    // Метод для получения количества просмотров для указанного offerId
    Long getViews(String offerId);

    // Метод для получения списка пар (offerId, количество просмотров) из кеша
    List<OfferViewCounterServiceImpl.OfferViewCountPair> getAllOfferViews();

    // Метод для загрузки данных о просмотрах из базы данных
    List<OfferViewCounterServiceImpl.OfferViewCountPair> loadOfferViewsFromDatabase();

    // Метод для обновления кеша данными из базы данных
    void updateCache(List<OfferViewCounterServiceImpl.OfferViewCountPair> offerViewPairs);

}
