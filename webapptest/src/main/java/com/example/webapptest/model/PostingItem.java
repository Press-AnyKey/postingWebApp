package com.example.webapptest.model;

import jakarta.persistence.*;

@Entity
public class PostingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer itemNum;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "posting_id", nullable = false)
    private Posting posting;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bun_id", nullable = false)
    private Bun bun;

    public PostingItem() {
    }

    public PostingItem(Integer itemNum, Integer quantity, Item item, Posting posting, Bun bun) {
        this.itemNum = itemNum;
        this.quantity = quantity;
        this.item = item;
        this.posting = posting;
        this.bun = bun;
    }

    public PostingItem(Long id, Integer itemNum, Integer quantity, Item item, Posting posting, Bun bun) {
        this.id = id;
        this.itemNum = itemNum;
        this.quantity = quantity;
        this.item = item;
        this.posting = posting;
        this.bun = bun;
    }

    @Override
    public String toString() {
        return "PostingItem{" +
                "id=" + id +
                ", itemNum=" + itemNum +
                ", quantity=" + quantity +
                ", item=" + item +
                ", posting=" + posting +
                ", bun=" + bun +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    public Bun getBun() {
        return bun;
    }

    public void setBun(Bun bun) {
        this.bun = bun;
    }
}

