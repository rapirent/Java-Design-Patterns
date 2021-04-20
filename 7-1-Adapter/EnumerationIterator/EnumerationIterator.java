package enumerationIterator;
import java.util.*;
public class EnumerationIterator implements Iterator<Object> {
    //https://stackoverflow.com/questions/11392380/generics-what-does-actually-mean
    protected Enumeration<?> enumee = null;
    public EnumerationIterator(Enumeration<?> enumee) {
        this.enumee = enumee;
    }
    @Override
    public boolean hasNext() {
        return enumee.hasMoreElements();
    }
    @Override
    public Object next() {
        return enumee.nextElement();
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
