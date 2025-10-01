import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Build decks with multiple cards
        ArrayList<Card> playerDeck = new ArrayList<>();
        ArrayList<Card> opponentDeck = new ArrayList<>();

        playerDeck.add(new Card("Musketeer", 4, 400, 120, Card.CardType.TROOP, Card.AttackType.RANGED));
        playerDeck.add(new Card("Knight", 3, 600, 90, Card.CardType.TROOP, Card.AttackType.MELEE));
        playerDeck.add(new Card("Mini P.E.K.K.A", 4, 600, 200, Card.CardType.TROOP, Card.AttackType.MELEE));
        playerDeck.add(new Card("Archers", 3, 300, 80, Card.CardType.TROOP, Card.AttackType.RANGED));
        playerDeck.add(new Card("Fire Spirits", 2, 200, 100, Card.CardType.TROOP, Card.AttackType.SPLASH));

        opponentDeck.add(new Card("Mega Minion", 3, 500, 130, Card.CardType.TROOP, Card.AttackType.RANGED));
        opponentDeck.add(new Card("Goblin", 2, 200, 80, Card.CardType.TROOP, Card.AttackType.MELEE));
        opponentDeck.add(new Card("Valkyrie", 4, 800, 110, Card.CardType.TROOP, Card.AttackType.SPLASH));
        opponentDeck.add(new Card("Skeleton Army", 3, 100, 50, Card.CardType.TROOP, Card.AttackType.SPLASH));
        opponentDeck.add(new Card("Ice Spirit", 1, 150, 70, Card.CardType.TROOP, Card.AttackType.SPLASH));

        int simulations = 5; // Number of random deck simulations
        int totalTradeAllDecks = 0;

        for(int s = 1; s <= simulations; s++){
            System.out.println("=== Deck Simulation " + s + " ===");

            Collections.shuffle(playerDeck);
            Collections.shuffle(opponentDeck);

            int totalTradeThisDeck = 0;
            int max = Math.max(playerDeck.size(), opponentDeck.size());

            for(int i = 0; i < max; i++){
                TradeResult result = null;

                if(i < playerDeck.size() && i < opponentDeck.size()){
                    result = BattleSimulator.simulate(playerDeck.get(i), opponentDeck.get(i));
                    totalTradeThisDeck += result.getEffectiveTrade();
                } else if(i < playerDeck.size()){
                    result = new TradeResult(playerDeck.get(i).getName(), "None", playerDeck.get(i).getName(), -playerDeck.get(i).getElixirCost());
                    totalTradeThisDeck += result.getEffectiveTrade();
                } else {
                    result = new TradeResult("None", opponentDeck.get(i).getName(), opponentDeck.get(i).getName(), opponentDeck.get(i).getElixirCost());
                    totalTradeThisDeck += result.getEffectiveTrade();
                }

                System.out.println(result.getPlayerCard() + " vs " + result.getOpponentCard());
                System.out.println("Winner: " + result.getWinner());
                System.out.println("Effective elixir trade: " + result.getEffectiveTrade());
                System.out.println("---------------------------");
            }

            System.out.println("Total elixir trade this deck: " + totalTradeThisDeck + "\n");
            totalTradeAllDecks += totalTradeThisDeck;
        }

        double averageTradeAcrossDecks = (double) totalTradeAllDecks / simulations;
        System.out.println("Average elixir trade across all deck simulations: " + averageTradeAcrossDecks);
    }
}
