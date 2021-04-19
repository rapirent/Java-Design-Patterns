public EnumerationIterator implements Iterator {
    Enumeration enumee;
    public EnumerationIterator(Enumeration enumee) {
        this.enumee = enumee;
    }
    public boolean hasNext() {
        return enumee.hasMoreElements();
    }
    public Object next() {
        return enumee.nextElement();
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
