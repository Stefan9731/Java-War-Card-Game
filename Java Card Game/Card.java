public class Card{
    String suit, rank;
    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public int getValue() {
        if (this.rank == "J") return 11;
        else if (this.rank == "Q") return 12;
        else if (this.rank == "K") return 13;
        else if (this.rank == "A") return 14;
        return Integer.parseUnsignedInt(this.rank);
    }
}
