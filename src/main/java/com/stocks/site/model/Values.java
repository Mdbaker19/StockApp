package com.stocks.site.model;


import javax.persistence.*;

@Entity
@Table(name = "stock_values")
public class Values {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private long id;

    @Column(nullable = false)
    private int timeId;

    @Column(nullable = false)
    private String valueString;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public Values(){}

    public Values(long id, String valueString, Stock stock, int timeId) {
        this.id = id;
        this.timeId = timeId;
        this.valueString = valueString;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
