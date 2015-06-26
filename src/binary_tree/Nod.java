package binary_tree;


public class Nod  {
    Nod  left, right;
    Integer data;

    public Nod(Integer data) {
        this.data = data;
    }
    

	@Override
	public String toString() {
		return String.valueOf(data);
	}

}