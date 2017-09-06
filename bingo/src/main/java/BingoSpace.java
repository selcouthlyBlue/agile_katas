public class BingoSpace {
    private int number;
    private boolean isMarked;

    public BingoSpace(int number) {
        this.number = number;
        this.isMarked = false;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BingoSpace that = (BingoSpace) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (isMarked ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        if(number == 0)
            return "FREE";
        return String.valueOf(number);
    }

    public boolean isMarked(){
        if(number == 0)
            return true;
        return isMarked;
    }

    public void setAsMarked() {
        this.isMarked = true;
    }

    public boolean contains(int numberCalled) {
        return this.number == numberCalled;
    }
}
