package org.example.services.impl;

import org.example.models.entities.OfferView;
import org.example.repositories.OfferViewRepository;
import org.example.services.OfferViewCounterService;
import org.example.services.OfferViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferViewServiceImpl implements OfferViewService {

    private OfferViewRepository offerViewRepository;
    private OfferViewCounterService offerViewCounterService;

    @Autowired
    public OfferViewServiceImpl(OfferViewRepository offerViewRepository, OfferViewCounterService offerViewCounterService) {
        this.offerViewRepository = offerViewRepository;
        this.offerViewCounterService = offerViewCounterService;
    }

    // Вызывается каждые 5 секунд
    @Override
    @Scheduled(fixedRate = 60000) // fixedRate / 1000 миллисекунд = fixedRate секунд
    public void updateOfferViewsPeriodically() {
        // Получение данных из кэша
        List<OfferViewCounterService.OfferViewCountPair> offerViewCounts = offerViewCounterService.getAllOfferViews();
//        System.out.println();
        for (OfferViewCounterService.OfferViewCountPair pair : offerViewCounts) {
//            System.out.println("Offer ID: " + pair.getOfferId() + ", Views: " + pair.getViewCount());

            // Обновление или запись данных в базу данных
            String offerId = pair.getOfferId();
            Long views = pair.getViewCount();

            // Попытка найти запись просмотра по offerId
            OfferView offerView = offerViewRepository.findByOfferId(offerId);

            if (offerView == null) {
                // Если запись не найдена, вы можете решить не предпринимать дополнительных действий,
                // или создать логику для обработки ситуации отсутствия OfferView
//                System.out.println("OfferView not found for Offer ID: " + offerId);
            } else {
                // Если запись найдена, обновляем количество просмотров
                offerView.setViews(views.intValue());
                // Сохраняем обновленную запись в базе данных
                offerViewRepository.save(offerView);
            }
        }
    }

    @Override
    public int getViews(String offerId) {
        // Попытка найти запись просмотра по offerId
        OfferView offerView = offerViewRepository.findByOfferId(offerId);

        // Если запись найдена, возвращаем количество просмотров, иначе возвращаем 0
        return (offerView != null) ? offerView.getViews() : 0;
    }
}


