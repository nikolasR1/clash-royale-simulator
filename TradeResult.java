public class TradeResult {
    private String playerCard;
    private String opponentCard;
    private String winner;
    private int effectiveTrade;

    public TradeResult(String playerCard, String opponentCard, String winner, int effectiveTrade) {
        this.playerCard = playerCard;
        this.opponentCard = opponentCard;
        this.winner = winner;
        this.effectiveTrade = effectiveTrade;
    }

    public String getPlayerCard() { return playerCard; }
    public String getOpponentCard() { return opponentCard; }
    public String getWinner() { return winner; }
    public int getEffectiveTrade() { return effectiveTrade; }
}
