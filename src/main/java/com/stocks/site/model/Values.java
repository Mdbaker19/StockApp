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
    private String timeId;

    @Column(nullable = false)
    private double valueAtTime;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public Values(){}

    public Values(long id, double valueAtTime, Stock stock, String timeId) {
        this.id = id;
        this.timeId = timeId;
        this.valueAtTime = valueAtTime;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }

    public double getValueAtTime() {
        return valueAtTime;
    }

    public void setValueAtTime(double valueAtTime) {
        this.valueAtTime = valueAtTime;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
