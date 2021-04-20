package duckSort;
public class Duck implements Comparable<Duck> {
    protected String name;
    protected int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return name + " weights " + weight;
    }

    public int compareTo(Duck object) {
        //原書這邊並沒有使用template用法
        if (this.weight < object.weight) {
            return -1;
        } else if (this.weight == object.weight) {
            return 0;
        } else {
            return 1;
        }
    }
}
