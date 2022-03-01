package org.leanpoker.player;

public class PlayerDto {

    private long id;
    private String name;
    private String status;
    private String version;
    private long stack;
    private long bet;
    private Card[] holeCards;

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

    public long getStack() {
        return stack;
    }

    public void setStack(long value) {
        this.stack = value;
    }

    public long getBet() {
        return bet;
    }

    public void setBet(long value) {
        this.bet = value;
    }

    public Card[] getHoleCards() {
        return holeCards;
    }

    public void setHoleCards(Card[] value) {
        this.holeCards = value;
    }
}
