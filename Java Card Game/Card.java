public class Card{
    String suit, rank;
    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public int getValue() {
        if (this.rank == "A") return 11;
        else if (this.rank == "J") return 12;
        else if (this.rank == "Q") return 13;
        else if (this.rank == "K") return 14;
        return Integer.parseUnsignedInt(this.rank);
    }
}
