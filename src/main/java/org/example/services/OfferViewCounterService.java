package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OfferViewCounterService {

    private final RedisTemplate<String, Long> redisTemplate;

    @Autowired
    public OfferViewCounterService(RedisTemplate<String, Long> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long incrementAndGetViews(String offerId) {
        String key = "offer_views:" + offerId;
        return redisTemplate.opsForValue().increment(key);
    }

    public Long getViews(String offerId) {
        String key = "offer_views:" + offerId;
        Long views = redisTemplate.opsForValue().get(key);
        return views != null ? views : 0L;
    }

    public List<OfferViewCountPair> getAllOfferViews() {
        List<OfferViewCountPair> offerViewCounts = new ArrayList<>();

        // Assuming your offer keys follow the pattern "offer_views:offerId"
        Set<String> keys = redisTemplate.keys("offer_views:*");

        if (keys != null && !keys.isEmpty()) {
            for (String key : keys) {
                String offerId = key.substring("offer_views:".length());
                Long views = redisTemplate.opsForValue().get(key);
                offerViewCounts.add(new OfferViewCountPair(offerId, views));
            }
        }

        return offerViewCounts;
    }

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
