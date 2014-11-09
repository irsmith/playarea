package playground;

public class Compress {

	String compressed;

	public Compress(String string) {
		assert string != null;
		compressed = perform(string.toCharArray());
	}

	public String getCompressed() {
		return compressed;

	}

	private String perform(char[] a) {
		if (a.length < 2) return String.valueOf(a);

		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = 0;
		while (i < a.length) {
			int cnt = 1;
			while (j < (a.length - 1) && a[j] == a[j + 1]) {
                cnt++;
                j++;
			}
            if (cnt > 1) {
            	String temp = new Integer(cnt).toString();
            	sb.append(a[j] + temp);
            	i = i + cnt;
            	j = i;
            } else {
            	//cnt==1
            	sb.append(a[j++]);
            }
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		int a[] = { 3,6,3,7,4,2,8,};
		
		
	}
}
