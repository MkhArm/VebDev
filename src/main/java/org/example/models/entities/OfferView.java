package org.example.models.entities;

import jakarta.persistence.*;
import org.example.models.baseEntities.BaseEntity;

@Entity
@Table(name = "offer_view")
public class OfferView extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    private int views;

    public OfferView(Offer offer, int views) {
        this.offer = offer;
        this.views = views;
    }

    public OfferView() {
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @ManyToOne
    @JoinColumn(name = "offer_id")
    public Offer getOffer() {
        return offer;
    }

    @Column(name = "views", length = 12, nullable = false)
    public int getViews() {
        return views;
    }

    @Override
    public String toString() {
        return "OfferView{" +
                "offer=" + offer +
                ", views=" + views +
                '}';
    }
}
