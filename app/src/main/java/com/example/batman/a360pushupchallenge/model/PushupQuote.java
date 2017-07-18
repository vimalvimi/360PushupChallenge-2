package com.example.batman.a360pushupchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PushupQuote {

    @SerializedName("id")
    @Expose
    private int quoteId;
    @SerializedName("quote")
    @Expose
    private String quoteText;

    public PushupQuote(int quoteId, String quoteText) {
        this.quoteId = quoteId;
        this.quoteText = quoteText;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }
}
