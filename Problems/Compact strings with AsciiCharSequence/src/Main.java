
import java.nio.charset.StandardCharsets;
import java.util.*;

class AsciiCharSequence implements  CharSequence {
    private byte[] chars;
    public AsciiCharSequence(byte[]  chars) {
        //int size = chars.length;
        //this.chars = new byte[size];
       // System.arraycopy(chars, 0, this.chars, 0, size);
        this.chars = chars.clone();
    }
    @Override
    public int length() {
        return this.chars.length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || ! (index < this.length())) {
            throw new IndexOutOfBoundsException("index value of: "+ index + " is out of possible values");
        }
        return (char) this.chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end < 0 || start > this.length()
        || end > this.length() || start > end
        ) {
            throw new IndexOutOfBoundsException("start and end values are not proper");
        } else if(start == end) {
            return  new AsciiCharSequence(new byte[]{});
        }
        else {
            //var bytes = new String(this.chars, StandardCharsets.UTF_8).getBytes();
            //byte[] slice = Arrays.copyOfRange(bytes,start, end - 1);
            int len = end - start;
            byte[] slice = new byte[len];
            System.arraycopy(this.chars, start, slice, 0, len);
            return  new AsciiCharSequence(slice);
        }

    }

    public String toString() {
        return new String(this.chars, StandardCharsets.UTF_8);
    }
}