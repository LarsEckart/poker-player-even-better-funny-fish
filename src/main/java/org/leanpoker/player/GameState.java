package org.leanpoker.player;

import java.util.Arrays;

public class GameState {

    private long betIndex;
    private long smallBlind;
    private long currentBuyIn;
    private long pot;
    private long minimumRaise;
    private long orbits;
    private long inAction;
    private PlayerDto[] players;
    private Card[] communityCards;

    public PlayerDto getOurPlayer() {
        return Arrays.stream(getPlayers()).filter(p -> p.getID() == getInAction()).findFirst().get();
    }

    boolean isPreFlop() {
        return Arrays.asList(getCommunityCards()).isEmpty();
    }

    public long getBetIndex() {
        return betIndex;
    }

    public void setBetIndex(long value) {
        this.betIndex = value;
    }

    public long getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(long value) {
        this.smallBlind = value;
    }

    public long getCurrentBuyIn() {
        return currentBuyIn;
    }

    public void setCurrentBuyIn(long value) {
        this.currentBuyIn = value;
    }

    public long getPot() {
        return pot;
    }

    public void setPot(long value) {
        this.pot = value;
    }

    public long getMinimumRaise() {
        return minimumRaise;
    }

    public void setMinimumRaise(long value) {
        this.minimumRaise = value;
    }

    public long getOrbits() {
        return orbits;
    }

    public void setOrbits(long value) {
        this.orbits = value;
    }

    public long getInAction() {
        return inAction;
    }

    public void setInAction(long value) {
        this.inAction = value;
    }

    public PlayerDto[] getPlayers() {
        return players;
    }

    public void setPlayers(PlayerDto[] value) {
        this.players = value;
    }

    public Card[] getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(Card[] value) {
        this.communityCards = value;
    }
}
