public class BattleSimulator {
    public static TradeResult simulate(Card player, Card opponent) {
        int playerHP = player.getHitPoints();
        int opponentHP = opponent.getHitPoints();


        while (playerHP > 0 && opponentHP > 0) {
            opponentHP -= player.getDamagePerSecond();
            playerHP -= opponent.getDamagePerSecond();
        }

        playerHP = Math.max(playerHP, 0);
        opponentHP = Math.max(opponentHP, 0);

        int playerValue = (playerHP * player.getElixirCost()) / player.getHitPoints();
        int opponentValue = (opponentHP * opponent.getElixirCost()) / opponent.getHitPoints();
        int effectiveTrade = (opponent.getElixirCost() + opponentValue) - (player.getElixirCost() + playerValue);

        String winner;
        if (playerHP > 0) {
            winner = player.getName();
        } else if (opponentHP > 0) {
            winner = opponent.getName();
        } else {
            winner = "Draw";
        }

        return new TradeResult(player.getName(), opponent.getName(), winner, effectiveTrade);
    }
}
