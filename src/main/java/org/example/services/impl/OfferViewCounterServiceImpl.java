package org.example.services.impl;

import org.example.models.entities.OfferView;
import org.example.repositories.OfferViewRepository;
import org.example.services.OfferViewCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferViewCounterServiceImpl implements OfferViewCounterService {

    private OfferViewRepository offerViewRepository;

    private RedisTemplate<String, Long> redisTemplate;

    @Autowired
    public OfferViewCounterServiceImpl(OfferViewRepository offerViewRepository, RedisTemplate<String, Long> redisTemplate) {
        this.offerViewRepository = offerViewRepository;
        this.redisTemplate = redisTemplate;
    }

    // Метод для увеличения количества просмотров для указанного offerId
    @Override
    public Long incrementAndGetViews(String offerId) {
        String key = "offer_views:" + offerId;
        return redisTemplate.opsForValue().increment(key);
    }

    // Метод для получения количества просмотров для указанного offerId
    @Override
    public Long getViews(String offerId) {
        String key = "offer_views:" + offerId;
        // Если ключ не найден в кеше, возвращаем 0
        Long views = redisTemplate.opsForValue().get(key);
        return views != null ? views : 0L;
    }

    // Метод для получения списка пар (offerId, количество просмотров) из кеша
    @Override
    public List<OfferViewCountPair> getAllOfferViews() {
        List<OfferViewCountPair> offerViewCounts = new ArrayList<>();

        // Предполагаем, что ключи offer следуют шаблону "offer_views:offerId"
        Set<String> keys = redisTemplate.keys("offer_views:*");

        if (keys != null && !keys.isEmpty()) {
            // Если ключи найдены в кеше, извлекаем данные из кеша
            for (String key : keys) {
                String offerId = key.substring("offer_views:".length());
                Long views = redisTemplate.opsForValue().get(key);
                offerViewCounts.add(new OfferViewCountPair(offerId, views));
            }
        } else {
            // Если кеш пуст, загружаем данные из базы данных и обновляем кеш
            List<OfferViewCountPair> offerViewPairsFromDatabase = loadOfferViewsFromDatabase();
            updateCache(offerViewPairsFromDatabase);
            offerViewCounts.addAll(offerViewPairsFromDatabase);
        }

        return offerViewCounts;
    }

    // Метод для загрузки данных о просмотрах из базы данных
    @Override
    public List<OfferViewCountPair> loadOfferViewsFromDatabase() {
        // Получаем из базы данных все записи OfferView
        List<OfferView> offerViewsFromDatabase = offerViewRepository.findAll();

        // Преобразуем записи в объекты OfferViewCountPair
        List<OfferViewCountPair> offerViewPairs = offerViewsFromDatabase.stream()
                .map(offerView -> new OfferViewCountPair(offerView.getOffer().getId(), (long) offerView.getViews()))
                .collect(Collectors.toList());

        return offerViewPairs;
    }


    // Метод для обновления кеша данными из базы данных
    @Override
    public void updateCache(List<OfferViewCountPair> offerViewPairs) {
        // Обновляем кеш данными, загруженными из базы данных
        for (OfferViewCountPair pair : offerViewPairs) {
            String key = "offer_views:" + pair.getOfferId();
            redisTemplate.opsForValue().set(key, pair.getViewCount());
        }
    }

    // Внутренний класс для представления пары (offerId, количество просмотров)
    public static class OfferViewCountPair {
        private final String offerId;
        private final Long viewCount;

        public OfferViewCountPair(String offerId, Long viewCount) {
            this.offerId = offerId;
            this.viewCount = viewCount;
        }

        public String getOfferId() {
            return offerId;
        }

        public Long getViewCount() {
            return viewCount;
        }
    }
}

