package memory;
// used 가 max 를 넘게 되면 메모리 부족 오류가 발생
public class Memory {
    private long used; //used : 사용중인 메모리
    private long max; //max : 최대 메모리
    public Memory(long used, long max) {
        this.used = used;
        this.max = max;
    }
    public long getUsed() {
        return used;
    }
    public long getMax() {
        return max;
    }
    @Override
    public String toString() {
        return "Memory{" +
                "used=" + used +
                ", max=" + max +
                '}';
    } }
